package com.employee.sb.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.sb.entity.Login;
import com.employee.sb.repository.LoginRepository;
import com.employee.sb.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginRepository lrepo;

	@Override
	public Login loginUser(String userName, String password) {
		Login login = lrepo.findByUserNameAndPassword(userName, password);
		return login;
	}


}
