package com.framework.utilities;

import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

public class ReportsListners implements IReporter {
	
	

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

		System.out.println("Execution Completed and starting zipping results");
		Zip.zipFiles();
		SMTPUtility.sendEmailReport();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
