package com.goeuro.tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * @author moosman
 *
 */

public class WebServiceTestRunner {

	public static void main(String[] args) {
		Result webserviceCityConsumerTest = JUnitCore.runClasses(WebServiceCityConsumerTest.class);
		for (Failure failure : webserviceCityConsumerTest.getFailures()) {
			System.out.println("webserviceCityConsumerTest : "+failure.toString());
		}
		System.out.println("webserviceCityConsumerTest : "+webserviceCityConsumerTest.wasSuccessful());
	      
		Result fileExportTest = JUnitCore.runClasses(FileExportTest.class);
		for (Failure failure : fileExportTest.getFailures()) {
			System.out.println("fileExportTest : "+failure.toString());
		}
		System.out.println("fileExportTest : "+fileExportTest.wasSuccessful());  
	      
	   }

}
