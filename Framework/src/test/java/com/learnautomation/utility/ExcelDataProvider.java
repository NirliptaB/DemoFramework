package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;
	public ExcelDataProvider()
	{
		File src = new File(".\\TestData\\TestData.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			
			 wb = new XSSFWorkbook(fis);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to read excel File" +e.getMessage());
		}
	}
	
	public String getStringData(String sheetname,int row,int column)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNumericData(String sheetname,int row,int column)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
	}
}
