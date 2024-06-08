package task;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromPropAndExcelAndWriteToExcel {
	public static void main(String[] args) throws Throwable{
	Properties p=new Properties();
	p.load(new FileInputStream("./TestData/prop.properties"));
	Workbook wb=WorkbookFactory.create(new FileInputStream("./TestData/Book2.xlsx"));
	//from properties to excel
	for (int j = 0; j < p.keySet().size(); j++) {
		wb.getSheet("Sheet2").createRow(j).createCell(0).setCellValue(p.getProperty("key"+(j+1)));
	}
	//from sheet1 to sheet2
	for (int j = 0; j <=wb.getSheet("Sheet1").getLastRowNum(); j++) {
		wb.getSheet("Sheet2").createRow(p.size()+j).createCell(0).setCellValue(wb.getSheet("Sheet1").getRow(j).getCell(0).toString());
	}
	// Write in to physical file
	wb.write(new FileOutputStream("./TestData/Book2.xlsx"));
	wb.close();
	}
}
