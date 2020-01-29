package com.example.tests;

//import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.edge.*;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.support.ui.Select;

public class CT01ValidarLayout {
	private WebDriver driver;
	private String baseUrl;
	// private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	//private final String pathIEDriver = "C:\\Selenium\\IEDriverServer.exe"; // PARA RECONHECER O DRIVE DO IE
	 private final String pathFirefoxDriver = "C:\\Selenium\\geckodriver.exe"; //
	// PARA RECONHECER O DRIVE DO FIREFOX

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
//		System.setProperty("webdriver.ie.driver", pathIEDriver);
//		driver = new InternetExplorerDriver();
		System.setProperty("webdriver.gecko.driver", pathFirefoxDriver);
		driver = new FirefoxDriver();
		driver.manage().window().maximize(); // BROWSER � EXIBIDO EM TELA CHEIA
		baseUrl = "https://livros.inoveteste.com.br/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

//	@Test
//	public void testCT01ValidarLayout() throws Exception {
//		// Acessa a página de contato do site Inove Teste
//		driver.get(baseUrl + "/contato");
//		// Valida o layout do formulário de contato
//		Thread.sleep(20000);
//		assertTrue(isElementPresent(By.cssSelector("h1")));
//		assertTrue(isElementPresent(By.cssSelector("label")));
//		assertTrue(isElementPresent(By.xpath("//div[@id='wpcf7-f372-p24-o1']/form/p[2]/label")));
//		assertTrue(isElementPresent(By.xpath("//div[@id='wpcf7-f372-p24-o1']/form/p[3]/label")));
//		assertTrue(isElementPresent(By.xpath("//div[@id='wpcf7-f372-p24-o1']/form/p[4]/label")));
//		assertTrue(isElementPresent(By.cssSelector("input.wpcf7-form-control.wpcf7-submit")));
//	}
	@Test
	public void testCT01ValidarLayout() throws Exception {
		// Acessa a p�gina de contato do site Inove Teste
		driver.get(baseUrl + "/contato");
		// Valida os layout do formul�rio de contato
		assertEquals(driver.findElement(By.cssSelector("h1")).getText(), "Envie uma mensagem");
		assertTrue(isElementPresent(By.name("your-name")));
		assertTrue(isElementPresent(By.name("your-email")));
		assertTrue(isElementPresent(By.name("your-subject")));
		assertTrue(isElementPresent(By.name("your-message")));
		assertTrue(isElementPresent(By.cssSelector("input.wpcf7-form-control.wpcf7-submit")));
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
//
//	private boolean isAlertPresent() {
//		try {
//			driver.switchTo().alert();
//			return true;
//		} catch (NoAlertPresentException e) {
//			return false;
//		}
//	}
//
//	private String closeAlertAndGetItsText() {
//		try {
//			Alert alert = driver.switchTo().alert();
//			String alertText = alert.getText();
//			if (acceptNextAlert) {
//				alert.accept();
//			} else {
//				alert.dismiss();
//			}
//			return alertText;
//		} finally {
//			acceptNextAlert = true;
//		}
//	}
}
