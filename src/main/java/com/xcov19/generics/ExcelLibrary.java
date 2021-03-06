package com.xcov19.generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibrary implements AutoConstants
{
	public String cellValue(String sheet, int row, int cell) throws IOException
	{
		FileInputStream file = new FileInputStream(excel_path);
		XSSFWorkbook xw = new XSSFWorkbook(file);
		String cellVal = xw.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return cellVal;
		
	}
}
