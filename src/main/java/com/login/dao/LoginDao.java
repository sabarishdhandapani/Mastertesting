package com.login.dao;


import java.util.Map;

public interface LoginDao {
  public Map<String, String> insertData();
  public boolean checkUserId(String userId);
  public boolean checkCredentials(String userId, String password);
  
}
