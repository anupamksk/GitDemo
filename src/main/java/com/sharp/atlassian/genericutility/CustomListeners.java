package com.sharp.atlassian.genericutility;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListeners extends BaseClass implements ITestListener {
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Failed test case");
		try {
			tssUtils.failed(result.getMethod().getMethodName(), driver);
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
	}

}
