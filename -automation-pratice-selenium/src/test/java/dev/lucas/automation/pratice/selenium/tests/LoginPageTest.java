package dev.lucas.automation.pratice.selenium.tests;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.lucas.automation.pratice.selenium.pages.LoginPage;

class LoginPageTest {
	private LoginPage loginPage;
	private final String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

	@BeforeEach
	void setUp() throws Exception {
		loginPage = new LoginPage();
		loginPage.visit(this.URL);
	}

	@AfterEach
	void tearDown() throws Exception {
		loginPage.quitWebDriver();
	}

	@Test
	void test() {
		//when
		loginPage.signin();
		
		//then
		Assertions.assertTrue(this.loginPage.getMyAccountMessage().equals("MY ACCOUNT"));
		Assertions.assertTrue(this.loginPage.getCurrentUrl().equals(this.URL));
	}

}
