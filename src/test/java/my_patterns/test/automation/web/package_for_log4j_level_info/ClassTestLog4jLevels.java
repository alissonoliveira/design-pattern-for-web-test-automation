package my_patterns.test.automation.web.package_for_log4j_level_info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

/**
 * This Class save your logs in {directory}/test-output/logs/output.log
 */
public class ClassTestLog4jLevels {
	private Logger logger = LogManager.getLogger(getClass());
	
	@Test
	public void test1() {
		logger.debug("printing debug");
	}
	
	@Test
	public void test2() {
		logger.info("printing info");
	}
	
	@Test
	public void test3() {
		logger.warn("printing warn");
	}
	
	@Test
	public void test4() {
		logger.error("printing error");
	}
	
	@Test
	public void test5() {
		logger.fatal("printing fatal");
	}
}
