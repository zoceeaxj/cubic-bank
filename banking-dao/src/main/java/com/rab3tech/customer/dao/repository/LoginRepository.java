package com.rab3tech.customer.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rab3tech.dao.entity.CustomerSaving;
import com.rab3tech.dao.entity.Login;

/**
 * 
 * @author nagendra
 * 
 * Spring Data JPA repository
 *
 */
public interface LoginRepository extends JpaRepository<Login, Integer> {
	
}

