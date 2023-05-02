package com.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dao.LoginRepository;
import com.product.model.Login;

@Service
public class LoginService {
	@Autowired
	LoginRepository lr;
	public Login saveUser(Login l)
	{
		return lr.save(l);
	}
	public String valideteUser(String username,String password)
	{
		String result=" ";
		Login l=lr.findByUsername(username);
		if(l==null)
		{
			result="Invalid user";
		}
		else
		{
			if(l.getPassword().equals(password))
			{
				result="Login success";
			}
			else
			{
				result="Login failed";
			}
		}
		return result;
	}

}
