package dev.lucas.automation.pratice.selenium.tests;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.lucas.automation.pratice.selenium.pages.RegisterPage;

class RegisterPageTest {
	
	
	private RegisterPage registerPage;
	private final String URL = "";

	@BeforeEach
	void setUp() throws Exception {
		this.registerPage = new RegisterPage();
		this.registerPage.visit(null);
	}

	@AfterEach
	void tearDown() throws Exception {
		this.registerPage.quitWebDriver();
	}

	@Test
	void test() {
		//when
		this.registerPage.insertEmailToRegister();
		
		//then
		String expected = "lucas.lsc@hotmail.com.br";
		String actual = this.registerPage.getEmailNewAccount();
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	void test2() {
		//when
		this.registerPage.fillOutForm();
		
		//then
		String expected = "welcome to your account. Here you can manage all of your personal information and orders. \n";
		String actual = this.registerPage.getWelcomeMessage();
		Assertions.assertEquals(expected, actual);
		
		String actualUrl = this.registerPage.getCurrentUrl();
		Assertions.assertFalse(this.URL.equals(this.registerPage.getCurrentUrl()));
		
	}

}
