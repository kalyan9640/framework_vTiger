package task;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromMultipleColumn {

	public static void main(String[] args) throws Throwable {

		Workbook wb = WorkbookFactory.create(new FileInputStream("./testData/Book2.xlsx"));
		Sheet sh = wb.getSheet("data");

		for (int i = 1; i <= sh.getLastRowNum(); i++) {
			if (sh.getRow(i).getCell(0).toString().equals("TC_02")) {
				for (int j = 1; j < sh.getRow(i).getLastCellNum(); j++) {
					System.out.print(sh.getRow(i).getCell(j).toString() + "\t");
				}
			}

		}

	}
}
