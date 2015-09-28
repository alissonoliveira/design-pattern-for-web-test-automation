package my_patterns.test.automation.web;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DriverFactory {

	public static ChromeDriverService service;
	private static Logger logger = LogManager.getLogger(DriverFactory.class);

	@AfterSuite
	public static void afterSuit() {
		logger.info("Finishing the ChromeDriverService");
		service.stop();
		logger.info("ChromeDriverService finished");
	}

	public static WebDriver producesDrive() throws IOException {
		if (service == null) {
			logger.info("Starting the ChromeDriverService");
			service = new ChromeDriverService.Builder().usingDriverExecutable(new File("resources/chromedriver.exe"))
					          .usingAnyFreePort().build();
			service.start();
			logger.info("ChromeDriverService Started");
		}
		return new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
	}
}
