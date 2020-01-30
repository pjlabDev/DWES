package testCases;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TestCase {

	private WebDriver driver;
	private String tituloEsperado = "Selenium - Wikipedia, la enciclopedia libre";
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void test_WikipediaSeleniumTitle() {
		
		driver.get("https://www.wikipedia.es");
		WebElement searchbox = driver.findElement(By.id("searchInput"));
		WebElement searchButton = driver.findElement(By.id("searchButton"));
		
		searchbox.sendKeys("Selenium");
		searchButton.click();
		
		String title = driver.getTitle();
		
		assertEquals(tituloEsperado,title);
		
	}
	
	@After
	public void shutdown() {
		driver.quit();
	}
	
}
