package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;



public class ReadXlsxData {
	
	
	@DataProvider(name="search_testdata")
	public String[][] getdata(Method m) throws Exception, IOException {
		

		String excelsheetname=m.getName();
		System.out.println("Sheet name "+excelsheetname);
		File f=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testdata.xlsx");
		FileInputStream fis= new FileInputStream(f);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sheetname=wb.getSheet(excelsheetname);
		int totalRows= sheetname.getLastRowNum();
				
		Row rowcells=sheetname.getRow(0);
		int totalCols=rowcells.getLastCellNum();
		
		System.out.println("Total rows and columns in testdata --"+totalRows+" and "+totalCols);
		
		DataFormatter format= new DataFormatter();
		String testData[][]= new String[totalRows][totalCols];
		
		for(int i=1;i<=totalRows;i++) {
			for(int j=0;j<totalCols;j++) {
				testData[i-1][j]=format.formatCellValue(sheetname.getRow(i).getCell(j));
				System.out.println(testData[i-1][j]);
			}
		}
		
		return testData;
		
	}

}
