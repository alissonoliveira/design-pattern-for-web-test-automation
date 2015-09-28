package my_patterns.test.automation.web.package_for_log4j_level_debug;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import my_patterns.test.automation.web.DriverFactory;

import java.io.IOException;

public class SeleniumTest {
	
	private WebDriver driver;
	private Logger logger = LogManager.getLogger(getClass());

	@BeforeClass
	public void before() throws IOException {
		logger.debug("Obtain ChromeDrive instance");
		driver = DriverFactory.producesDrive();
		logger.debug("Instance of ChromeDrive obtained");
	}

	@AfterClass
	public void after() {
		logger.debug("Finishing ChromeDrive instance");
		driver.quit();
		logger.debug("ChromeDrive instance finalized");
	}
	
	@Test
	public void test1() {
		logger.debug("Getting web page");
		driver.get("https://br.search.yahoo.com/");
		WebElement searchField = driver.findElement(By.id("yschsp"));
		searchField.sendKeys("Selenium");
		searchField.submit();
	}
	
}
