package com.login.dao;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.login.config.AppConfig;
import com.login.service.LoginService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class, loader=AnnotationConfigContextLoader.class)
public class LoginDaoTest {
	
	@Autowired
	private LoginDao loginDao;

	static Map<String, String> userCred = new HashMap<String, String>();
	
	@BeforeClass
	public static void setUp() {
		
		userCred.put("robhert", "robert@123");
		userCred.put("sham", "sham@123");
		userCred.put("ram", "ram@123");
		userCred.put("joejoe", "joejoe@123");
		userCred.put("tesfay", "tesfay@123");
		userCred.put("lincy", "lincy@123");
		userCred.put("fincy", "fincy@123");
		userCred.put("semere", "semere@123");
		System.out.println("-----> SETUP <-----");
		System.out.println("changes");
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
		assertEquals("class com.login.dao.LoginDaoImpl",this.loginDao.getClass().toString());
	}
	
	@Test
	public void checkCredentialsForValidCustomer() {
		
		assertEquals(true,loginDao.checkCredentials("lincy", "lincy@123"));
	}
	
	@Test
	public void checkCredentialsForNull() {
		
		assertEquals(false,loginDao.checkCredentials(null, null));
	}
		
	@Test
	public void checkCredentialsForEmptyString() {
		
		assertEquals(false,loginDao.checkCredentials(" ", " "));
		
	}
	
	@Test
	public void checkCredentialsForInvalidCustomer() {
		
		assertEquals(false,loginDao.checkCredentials("Tesfamicheal", " Tesfamicheal@123"));
		
	}
	
	@Test
	public void checkInsertData() {
		
		assertEquals(userCred,loginDao.insertData());
		
	}
	
	@Test
	public void checkUserId() {
		
		assertEquals(true,loginDao.checkUserId("ram"));
		System.out.println("Checking for Building purpose");
		
	}

	@AfterClass
	public static void afterTest() {
		System.out.println("-----> DESTROY <-----");
	}

}
