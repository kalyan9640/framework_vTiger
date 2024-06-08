package com.vTiger.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * contains resuable methods of excel file
 * @author Pavan Kalyan
 */

public class ExcelUtility {
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws Throwable {
	FileInputStream fis=new FileInputStream("./TestData/vTigerTestData.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();

	return data;
	}
	
	public int getRowCount(String sheetName)throws Throwable {
		FileInputStream fis=new FileInputStream("./TestData/vTigerTestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int rowCount=wb.getSheet(sheetName).getLastRowNum();
		return rowCount;
	}
	
	public void setDataIntoExcel(String sheetName, int rowNum, int cellNum, String data) throws Throwable {
		FileInputStream fis=new FileInputStream("./TestData/vTigerTestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(data);
		FileOutputStream fout=new FileOutputStream("./TestData/vTigerTestData.xlsx");
		wb.write(fout);
		wb.close();
		
}
}