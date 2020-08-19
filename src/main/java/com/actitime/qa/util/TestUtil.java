package com.actitime.qa.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	public static int noOfValues(String sheetName) throws InvalidFormatException, IOException {
		FileInputStream fis = new FileInputStream(".//UserList.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		return sh.getLastRowNum();
	}
	public static String readDataFromExcel(String sheetName, int rowNum, int cellNum) throws InvalidFormatException, IOException {
		FileInputStream fis = new FileInputStream(".//UserList.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		//row number starts from 0
		Row r = sh.getRow(rowNum);
		//cell number starts from 0
		Cell c = r.getCell(cellNum);
		String cellValue = c.toString();
		//System.out.println(cellValue);
		return cellValue;
	}
}
