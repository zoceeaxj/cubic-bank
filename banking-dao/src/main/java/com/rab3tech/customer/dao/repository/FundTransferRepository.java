package com.rab3tech.customer.dao.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.rab3tech.dao.entity.FundTransferEntity;
import com.rab3tech.dao.entity.PayeeInfo;


public interface FundTransferRepository extends JpaRepository<PayeeInfo, Integer>  {


    @Query("select f from FundTransferEntity f where f.fromAccount.customerId.loginid=?1")
    Optional<List<FundTransferEntity>> findBySender(String username);

    @Modifying
    @Query("delete from FundTransferEntity t where t.fromAccount.id=?1 OR t.toAccount.id=?1")
    void deleteByCustomer(Long lid);

    void save(FundTransferEntity fundTransferEntity);

   
	
}
