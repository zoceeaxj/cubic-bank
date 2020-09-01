package com.rab3tech.customer.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rab3tech.dao.entity.PayeeInfo;


public interface PayeeRepository extends JpaRepository<PayeeInfo, Integer>  {

	@Query("SELECT tt FROM PayeeInfo tt where tt.payeeStatus.id = 2") 
	List<PayeeInfo> findPendingPayee();
	
	public Optional<PayeeInfo> findByUrnAndPayeeAccountNo(int urn,String payeeAccountNo);
	
	
}
