package testCases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class Retry implements IRetryAnalyzer// interface
{
	int counter = 0;
	int retryLimit = 2;

	@Override
	public boolean retry(ITestResult result) {
		if (counter < retryLimit) {
			counter++;
			return true;
		}
		return false;

	}

}
