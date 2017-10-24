package com.login.dao;


import java.util.HashMap;

import java.util.Map;

import org.springframework.stereotype.Repository;
@Repository("LoginRepository")
public class LoginDaoImpl implements LoginDao {

	Map<String, String> userCred = null;
	
	public Map<String, String> insertData() {

		userCred = new HashMap<String,String>();
		
		userCred.put("robhert", "robert@123");
		userCred.put("sham", "sham@123");
		userCred.put("ram", "ram@123");
		userCred.put("joejoe", "joejoe@123");
		userCred.put("tesfay", "tesfay@123");
		userCred.put("lincy", "lincy@123");
		userCred.put("fincy", "fincy@123");
		userCred.put("semere", "semere@123");
		
		return userCred;
	}

	public boolean checkUserId(String userId) {
		
		return userCred.containsKey(userId);
		
	}

	public boolean checkCredentials(String userId, String password) {
		
		insertData();
		boolean userExist = checkUserId(userId);
		if(userExist)
		{
			String pass = userCred.get(userId);
			if(pass.equals(password.trim()))
				return true;
		}
		else
		{
		  return false;
		}
		return false;
	}

}
