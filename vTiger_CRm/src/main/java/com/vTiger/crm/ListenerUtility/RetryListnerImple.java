package com.vTiger.crm.ListenerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListnerImple implements IRetryAnalyzer{

	int count=0;
	int limit=2;
	@Override
	public boolean retry(ITestResult result) {
		if (count<limit) {
			count++;
			return true;
		}
		return false;
	}

}