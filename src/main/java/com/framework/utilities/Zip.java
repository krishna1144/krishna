package com.framework.utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip
{
    
	public static void zipFiles(){
		
		byte[] buffer = new byte[1024];

    	try{

    		FileInputStream in = new FileInputStream(System.getProperty("user.dir")+"/test-output/emailable-report.html");	
    		FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"/automationReports.zip");
    		ZipOutputStream zos = new ZipOutputStream(fos);
    	
    		ZipEntry ze= new ZipEntry("emailable-report.html");
    		zos.putNextEntry(ze);
    		
    		int len;
    		while ((len = in.read(buffer)) > 0) {
    			zos.write(buffer, 0, len);
    		}

    		in.close();
    		zos.closeEntry();

    		//remember close it
    		zos.close();

    		System.out.println("Done");

    	}catch(IOException ex){
    	   ex.printStackTrace();
    	}
    }	
		
		
	
}