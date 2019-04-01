package com.cyranosystems.qa.web.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Data_Provider {
	
	XSSFWorkbook wb;
	
	public Excel_Data_Provider() {
		
		File src = new File("./Test Data/ExcelData.xlsx");
		
		try {
			
			FileInputStream fis = new FileInputStream(src);
			
			wb = new XSSFWorkbook(fis);
			
		} catch (Exception e) {
			
			System.out.println("Cannot Read Excel Data"+e.getMessage());
		}
		
	}
	
	public String getStringData(String sheetName, int row, int column) {
		
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		
	}
	
	public String getStringData(int sheetIndex, int row, int column) {
		
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	
	}
	
	public double getNumericData(String sheetName, int row, int column) {
		
		double d =  wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
		String s=Double.toString(d);  
		return d;  
		
	}
	
	public double getNumericData(int sheetIndex, int row, int column) {
		
		double d =  wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getNumericCellValue();
		String s=String.valueOf(d);
		return d;  
	}
	
}
