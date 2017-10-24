package com.login.service;
/**
 * 
 * This interface provides the service for validating the user credentials of login page
 * @author Rafi
 * @since 19-04-20167
 */
public interface LoginService {
	/*
	 * This method validate user credentials of login page
	 */
   public boolean validateLoginCredentials(String userId, String password );
}
