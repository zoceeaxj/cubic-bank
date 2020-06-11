package com.rab3tech.customer.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rab3tech.customer.dao.repository.SecurityQuestionsRepository;
import com.rab3tech.dao.entity.SecurityQuestions;
import com.rab3tech.vo.SecurityQuestionsVO;

@Service
public class SecurityQuestionServiceImpl implements SecurityQuestionService {

	@Autowired
	private SecurityQuestionsRepository questionsRepository;
	
	@Override
	public List<SecurityQuestionsVO>  findAll(){
		List<SecurityQuestions>  securityQuestions=questionsRepository.findAll();
		List<SecurityQuestionsVO> questionsVOs=new ArrayList<>();
		for(SecurityQuestions questions:securityQuestions) {
			SecurityQuestionsVO questionsVO=new SecurityQuestionsVO();
			BeanUtils.copyProperties(questions, questionsVO);
			questionsVOs.add(questionsVO);
		}
		return questionsVOs;
		/*return securityQuestions.stream().map(tt->{
			SecurityQuestionsVO questionsVO=new SecurityQuestionsVO();
			BeanUtils.copyProperties(tt, questionsVO);
			return questionsVO;
		}).collect(Collectors.toList());*/
	}
	
}
