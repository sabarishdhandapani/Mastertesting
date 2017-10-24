package com.login.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.login.config.AppConfig;
import com.login.service.LoginService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class, loader=AnnotationConfigContextLoader.class)
public class LoginServiceTest {
	
	@Autowired
	private LoginService loginService;

	
	@BeforeClass
	public static void setUp() {
		System.out.println("-----> SETUP <-----");
	}
	
	@Before
	public void beforeEachTest() {
		System.out.println("This is executed before each Test");
	}

	@After
	public void afterEachTest() {
		System.out.println("This is exceuted after each Test");
	}
	
    @Test
	public void testLoginService() {
		assertEquals("class com.login.service.LoginServiceImpl",this.loginService.getClass().toString());
	}
	
	@Test
	public void checkCredentialsForValidCustomer() {
		
		assertEquals(true,loginService.validateLoginCredentials("lincy", "lincy@123"));
		
	}
	@Test
	public void checkCredentialsForNull() {
		
		assertEquals(false,loginService.validateLoginCredentials(null, null));
		
	}
	@Test
	public void checkCredentialsForEmptyString() {
		
		assertEquals(false,loginService.validateLoginCredentials(" ", " "));
		
	}
	
	@Test
	public void checkCredentialsForInvalidCustomer() {
		
		assertEquals(false,loginService.validateLoginCredentials("Tesfamicheal", " Tesfamicheal@123"));
		
	}
	
	

	@AfterClass
	public static void afterTest() {
		System.out.println("-----> DESTROY <-----");
	}
}
