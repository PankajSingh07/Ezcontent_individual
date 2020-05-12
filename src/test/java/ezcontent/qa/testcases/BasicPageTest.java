package ezcontent.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ezcontent.qa.base.TestBase;
import ezcontent.qa.pages.BasicPage;
import ezcontent.qa.pages.LoginPage;
import ezcontent.qa.util.TestUtil;

public class BasicPageTest extends TestBase {
	LoginPage login;
	TestUtil util;
	BasicPage basic;

	public BasicPageTest() {
		super();
	}

	@BeforeClass
	public void setup() throws IOException {
		TestBase.browserLaunch();
		login = new LoginPage();
		util = new TestUtil();
		basic = new BasicPage();
	}

	@Test(priority = 1)
	public void loginTest() {
		login.validateLogin();

	}

	@Test(priority = 2)
	public void dashboard() throws InterruptedException {
		basic.dashboard();
	}

	@Test(priority = 3)
	public void title() {
		boolean flag1 = basic.title();
		Assert.assertTrue(flag1);
	}

	@Test(priority = 5)
	public void body() throws InterruptedException {
		basic.body();

	}
	
	@Test(priority= 4)
	public void verify() {
		boolean flag2 = basic.menus();
		Assert.assertTrue(flag2);
	}
	@Test(priority=6)
	public void verifySuccessfull() 
	{
		String success = basic.successfully();
		Assert.assertEquals(success, "Test");
	}

}
