package testCases;

import org.testng.annotations.Test;

import elementRepository.Linkdien;

public class LinkdienTestCases extends SampleBaseClass {
	Linkdien lp;

	@Test
	public void verifyEnterDetails() throws InterruptedException {
		lp = new Linkdien(driver);
		lp.enterEmailIds("sheejadas255@gmail.com");
		lp.enterPassword("asd@1233");
		lp.getPassword();
		lp.getUnHidePassword();

	}

}
