package com.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseClass;

public class DataProv1 extends BaseClass{

	@DataProvider(name="testdata")
public String[][] excelData() throws IOException {
		
		File f=new File("D:\\\\class screenshots\\\\Data1.xlsx");
		FileInputStream file=new FileInputStream(f);
		
		Workbook w=new XSSFWorkbook(file);
		Sheet sheet = w.getSheet("Sheet2");
		Row row = sheet.getRow(0);//to get only the row interface method(row.getPhysicalNumberOfCells) we wont use 'row' reference variable 
		String data[][]= new String[sheet.getPhysicalNumberOfRows()][row.getPhysicalNumberOfCells()];
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row2=sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row2.getCell(j);
				DataFormatter d=new DataFormatter();//to covert any type cell value into string
				String cellvalue = d.formatCellValue(cell);
				data[i][j]=cellvalue;
			}
		}	
	return data;
	}	
@Test(dataProvider="testdata")
private void tc1(String email, String password) {
	
	browserLaunch("Chrome");
	maxWindow();
	implicityWait();
	launchUrl("https://www.facebook.com/login/");
	WebElement username = findingElement("id","email" );
	sendText(username, email);
	WebElement pass = findingElement("name","pass");
	sendText(pass, password);
	WebElement login = findingElement("id", "loginbutton");
	btnClick(login);
}
}
