package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
public static WebDriver driver;
	
	WebElement element;

	// 1
	public void browserLaunch(String browserName) {
		switch (browserName) {
		case "Chrome":
			driver = new ChromeDriver();
			break;
		case "Firefox":
			driver = new FirefoxDriver();
			break;
		case "Edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid browser name");
			break;
		}
	}

	// 2
	public void maxWindow() {
		driver.manage().window().maximize();
	}

	// 3
	public void launchUrl(String url) {
		driver.get(url);

	}

	// 4
	public String urlTitle() {
		String title = driver.getTitle();
		return title;
	}

	// 5
	public String urlCurrentPage() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	// 6
	public void closeWindow() {
		driver.close();
	}

	// 7
	public void quitWindow() {
		driver.quit();
	}

	// 8
	public WebElement findingElement(String locatorName, String locatorValue) {
		switch (locatorName) {
		case "id":
			element = driver.findElement(By.id(locatorValue));
			break;
		case "name":
			element = driver.findElement(By.name(locatorValue));
			break;
		case "xpath":
			element = driver.findElement(By.xpath(locatorValue));
			break;
		default:
			System.out.println("invalid locator");

			return element;
		}
		return element;
	}

	// 9
	public void btnClick(WebElement element) {
		element.click();
	}

	// 10
	public void sendText(WebElement element,String text) {
		element.sendKeys(text);
	}

	// 11 to read the data from excel
	public String excelRead(String excelLocation, String sheetName, int rowIndex, int cellIndex) throws IOException {
		String value = "";
		File f = new File(excelLocation);
		FileInputStream file = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(file);
		Sheet sheet = w.getSheet(sheetName);
		int noofRows = sheet.getPhysicalNumberOfRows();

		Row row = sheet.getRow(rowIndex);
		int noofCells = row.getPhysicalNumberOfCells();
		
		Cell cell = row.getCell(cellIndex);// to read username from xl

		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			value = cell.getStringCellValue();
			// value=cell.getStringCellValue();
			break;

		case BOOLEAN:
			boolean b = cell.getBooleanCellValue();
			// to change the datatype in string representation
			value = String.valueOf(b);
			break;

		case NUMERIC:

			// date
			if (DateUtil.isCellDateFormatted(cell)) {

				// to get the date and it will be in some format not regular
				Date date = cell.getDateCellValue();
				// to convert to regular or simple format
				SimpleDateFormat d = new SimpleDateFormat("dd-MMM-yyyy");
				// "dd-MMM-yyyy" or dd-MM-yy
				value = d.format(date);
				// System.out.println(format);
			}

			// number or decimal
			else {
				double ncv = cell.getNumericCellValue();
				// if decimal means round it off using this
				long round = Math.round(ncv);// 10.12 or 12
				if (round == ncv) //
				{
					value = String.valueOf(round);

				} else {
					value = String.valueOf(ncv);
				}
			}
			break;
		}
		return value;
	}
	
	
	
	//12 Dropdown select
	public void SelectBy(WebElement element,String type,String value) {
		Select select=new Select(element);
		if (type.equalsIgnoreCase("index")) {
			select.selectByIndex(Integer.parseInt(value));
		}
		else if (type.equalsIgnoreCase("value")) {
			select.selectByValue(value);
		}
		else if (type.equalsIgnoreCase("text")) {
			select.selectByVisibleText(value);
		}
	}
	public void implicityWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		

	}
	//13  2d data
public String[][] excelData(String excelLocation, String sheetName) throws IOException {
		
		File f=new File(excelLocation);
		FileInputStream file=new FileInputStream(f);
		
		Workbook w=new XSSFWorkbook(file);
		Sheet sheet = w.getSheet(sheetName);
		Row row = sheet.getRow(0);
		String data[][]= new String[sheet.getPhysicalNumberOfRows()][row.getPhysicalNumberOfCells()];
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row2=sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row2.getCell(j);
				DataFormatter d=new DataFormatter();
				String cellvalue = d.formatCellValue(cell);
				data[i][j]=cellvalue;
			}
		}	
	return data;
	}	

}
