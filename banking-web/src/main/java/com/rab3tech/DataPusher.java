package com.rab3tech;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.rab3tech.admin.dao.repository.AccountStatusRepository;
import com.rab3tech.admin.dao.repository.AccountTypeRepository;
import com.rab3tech.admin.dao.repository.CustomerRepository;
import com.rab3tech.customer.dao.repository.LoginRepository;
import com.rab3tech.customer.dao.repository.RoleRepository;
import com.rab3tech.dao.entity.AccountStatus;
import com.rab3tech.dao.entity.AccountType;
import com.rab3tech.dao.entity.Customer;
import com.rab3tech.dao.entity.Login;
import com.rab3tech.dao.entity.Role;

@Component
public class DataPusher implements CommandLineRunner {
	
	@Value("${spring.mail.username:javatech1000@gmail.com}")
	private String empUsername;
	
	@Autowired
	private AccountStatusRepository accountStatusRepository;
	
	@Autowired
	private AccountTypeRepository accountTypeRepository;
	
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Optional<AccountStatus> optional1=accountStatusRepository.findById(1);
		if(!optional1.isPresent()) {
			AccountStatus accountStatus1=new AccountStatus(1,"AS01","PENDING","PENDING");
			AccountStatus accountStatus2=new AccountStatus(2,"AS02","PROCESSING","PROCESSING");
			AccountStatus accountStatus3=new AccountStatus(3,"AS03","DORMANT","DORMANT");
			AccountStatus accountStatus4=new AccountStatus(4,"AS04","APPROVED","APPROVED");
			AccountStatus accountStatus5=new AccountStatus(5,"AS05","ACTIVE","ACTIVE");
			accountStatusRepository.save(accountStatus1);
			accountStatusRepository.save(accountStatus2);
			accountStatusRepository.save(accountStatus3);
			accountStatusRepository.save(accountStatus4);
			accountStatusRepository.save(accountStatus5);
		}
		
		Optional<AccountType> optional2=accountTypeRepository.findById(1);
		if(!optional2.isPresent()) {
			AccountType accountType1=new AccountType(1,"AC001","SAVING","SAVING");
			AccountType accountType2=new AccountType(2,"AC002","CURRENT","SAVING");
			AccountType accountType3=new AccountType(3,"AC003","CORPORATE","SAVING");
			AccountType accountType4=new AccountType(4,"AC004","CHECKING","SAVING");
			
			List<AccountType> accountTypes=new ArrayList<>();
			accountTypes.add(accountType1);
			accountTypes.add(accountType2);
			accountTypes.add(accountType3);
			accountTypes.add(accountType4);
			
			accountTypeRepository.saveAll(accountTypes);
			
		}
		
		Optional<Role> optional3=roleRepository.findById(1);
		if(!optional3.isPresent()) {
			Role role1=new Role(1,"ROLE_ADMIN","ROLE_ADMIN");
			Role role2=new Role(2,"ROLE_EMPLOYEE","ROLE_EMPLOYEE");
			Role role3=new Role(3,"ROLE_CUSTOMER","ROLE_CUSTOMER");
			Role role4=new Role(4,"ROLE_MANAGER","ROLE_MANAGER");
			
			List<Role> roles=new ArrayList<>();
			roles.add(role1);
			roles.add(role2);
			roles.add(role3);
			roles.add(role4);
			
			roleRepository.saveAll(roles);
		}
		Optional<Login> optional=loginRepository.findByLoginid(empUsername);
		if(!optional.isPresent()) {
			Customer pcustomer = new Customer();
			pcustomer.setAddress("Fremont");
			pcustomer.setName("James Robert");
			pcustomer.setMobile("320432043");
			pcustomer.setGender("Male");
			pcustomer.setJobTitle("Bank Employee");
			pcustomer.setSsn("23432");
			pcustomer.setFather("Mr. Jack");
			pcustomer.setQualification("NA");
			pcustomer.setDom(new Timestamp(new Date().getTime()));
			pcustomer.setDob("12-03-2020");
			pcustomer.setDoe(new Timestamp(new Date().getTime()));
			pcustomer.setEmail(empUsername);
			Login login = new Login();
			login.setNoOfAttempt(3);
			login.setLoginid(pcustomer.getEmail());
			login.setName(pcustomer.getName());
			login.setPassword("cool@123$");
			login.setToken("2230303");
			login.setLocked("no");
			
			Role entity=roleRepository.findById(2).get();
			Set<Role> roles=new HashSet<>();
			roles.add(entity);
			//setting roles inside login
			login.setRoles(roles);
			//setting login inside
			pcustomer.setLogin(login);
			customerRepository.save(pcustomer);
		}
		
	}
}
