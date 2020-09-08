package com.rab3tech.customer.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.rab3tech.dao.entity.PayeeInfo;


public interface PayeeRepository extends JpaRepository<PayeeInfo, Integer>  {

	@Query("SELECT tt FROM PayeeInfo tt where tt.payeeStatus.id = 1") 
	List<PayeeInfo> findPendingPayee();
	

    /*
     * @Query("SELECT tt FROM PayeeInfo tt where tt.payeeStatus.id = 2 and tt.customerId =?1"
     * ) List<PayeeInfo> findRegisteredPayee(String customerId);
     */
	
	@Query("SELECT tt FROM PayeeInfo tt where tt.payeeStatus.id = 2") 
    List<PayeeInfo> findRegisteredPayee();
	
	public Optional<PayeeInfo> findByUrnAndPayeeAccountNo(int urn,String payeeAccountNo);
	
	@Modifying
    @Query("DELETE from PayeeInfo p where id = ?1")
    void rejectPayee(int id);
	
	
}
