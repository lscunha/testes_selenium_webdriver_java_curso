package dev.lucas.automation.pratice.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class LoginTest {
	private WebDriver driver;
	
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		WebElement emailAddressLocator = driver.findElement(By.id("email"));
		emailAddressLocator.sendKeys("Lucas.lsc@hotmail.com.br");
		
		WebElement passwordElement = driver.findElement(By.name("passwd"));
		passwordElement.sendKeys("123456@Ca");
		
		WebElement submitBtnElement = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]"));
		submitBtnElement.click();
		
		WebElement tagMyAccount = driver.findElement(By.tagName("h1"));
		String textTagH1 = tagMyAccount.getText();
		
		Assertions.assertTrue(textTagH1.equals("MY ACCOUNT"));
		
	}

}
