package com.framework.readers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public  FileInputStream file;
	public  XSSFWorkbook workbook;
	public  XSSFSheet sheet;
	public  XSSFRow row;
	static XSSFCell cell;
	public String path;
	
	public ExcelReader(String path) throws FileNotFoundException {
		this.path =path;
		//file = new FileInputStream(System.getProperty("user.dir")+"/src/testData/TestData.xlsx");
	
	}
	/**
	 * Get that value form Excel file using rownum and colnum
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @return
	 * @throws IOException
	 */
	public String getCellData(String sheetName,int rowNum,int colNum) throws IOException{
		file = new FileInputStream(path);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		
		String output = cell.getStringCellValue();
		return output;
	}
	
	
	/**
	 * Set the data to Excel file in specific row and column
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @param data
	 * @throws IOException
	 */
	public void setCellData(String sheetName,int rowNum,int colNum,String data) throws IOException{
		
		file = new FileInputStream(path);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		
		if(row == null){
			row = sheet.createRow(rowNum);
			
		}
		cell = row.getCell(colNum);
		
		if(cell == null){
			cell = row.createCell(colNum);	
		}
		
		cell.setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream(path);
		workbook.write(fos);
		fos.close();
		
	}	
		


}
