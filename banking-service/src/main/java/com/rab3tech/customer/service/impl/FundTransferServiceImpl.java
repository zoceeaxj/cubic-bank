package com.rab3tech.customer.service.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rab3tech.customer.dao.repository.CustomerAccountInfoRepository;
import com.rab3tech.customer.dao.repository.FundTransferRepository;
import com.rab3tech.customer.service.FundTransferService;
import com.rab3tech.dao.entity.CustomerAccountInfo;
import com.rab3tech.dao.entity.FundTransferEntity;
import com.rab3tech.utils.Utils;
import com.rab3tech.vo.FundTransferVO;
import com.rab3tech.vo.LoginVO;

@Service
@Transactional
public class FundTransferServiceImpl implements FundTransferService  {
    
    @Autowired
    private CustomerAccountInfoRepository customerAccountInfoRepository;
    
    @Autowired
    private FundTransferRepository fundTransferRepository;
   
    @Override
    public String convertToWords(String amount) {

        return Utils.amountToWords(amount);
    }
    
    public void fundTransfer(FundTransferVO fundTransferVO, LoginVO loginVO) {
        
        String custIdFrom = loginVO.getUsername();
        CustomerAccountInfo customerFrom = customerAccountInfoRepository.findByCustomerUsernameAndAccountType(custIdFrom, fundTransferVO.getFromAccount()).get();
        System.out.println(fundTransferVO.getToAccount());
        String toAccNo = fundTransferVO.getToAccount().substring(0, 12);
        System.out.println(toAccNo);
        CustomerAccountInfo customerTo = customerAccountInfoRepository.findByAccountNumber(toAccNo).get();
        
        customerFrom.setAvBalance(-fundTransferVO.getAmount());
        customerFrom.setTavBalance(customerFrom.getTavBalance()- fundTransferVO.getAmount());
        
        customerTo.setAvBalance(fundTransferVO.getAmount());
        customerTo.setTavBalance(customerTo.getTavBalance()+ fundTransferVO.getAmount());
        
        FundTransferEntity fundTransferEntity = new FundTransferEntity();
        fundTransferEntity.setFromAccount(customerFrom);
        fundTransferEntity.setToAccount(customerTo);
        fundTransferEntity.setAmount(fundTransferVO.getAmount());
        fundTransferEntity.setRemarks(fundTransferVO.getRemarks());
        fundTransferEntity.setOtp(0);
        fundTransferEntity.setTransactionDate(new Date());
        fundTransferRepository.save(fundTransferEntity);
        
        
    }

}