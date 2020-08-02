package com.Urbanladder.base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandle  {
	

	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	public ExcelHandle(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			try {
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public String DataFormatter(Cell cell) {
		DataFormatter formatter = new DataFormatter();
		return formatter.formatCellValue(cell);
	}

	public boolean setCellData(String sheetname, String[][] data) {
		try {
			
			
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			int index = workbook.getSheetIndex(sheetname);
			sheet = workbook.getSheetAt(index);
			for (int i = 0; i < 3; i++)
			{
				row= sheet.getRow(i+1);
				if(row==null)
					row= sheet.createRow(i+1);
				for (int j = 0;  j < data[i].length; j++) {
					System.out.println(data[i][j]);
					sheet.autoSizeColumn(j);
					cell = row.getCell(j);
					if (cell == null)
						cell = row.createCell(j);
					CellStyle cs = workbook.createCellStyle();
					cs.setWrapText(true);
					cell.setCellValue(data[i][j]);
				}

				System.out.println();
			}
			
			fOut = new FileOutputStream(path);
			workbook.write(fOut);
			fOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	

	
	public boolean createColumn(String sheetname, String colname) {
		try {
			int index = workbook.getSheetIndex(sheetname);
			if (index == -1)
				return false;
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			if (row == null)
				row = sheet.createRow(0);

			int colnum = getColumnCount(sheetname);
			if (colnum == -1)
				cell= row.createCell(0);

			else
				cell = row.createCell(colnum);

			CellStyle cs = workbook.createCellStyle();
			cs.setWrapText(true);
			cs.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
			cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell.setCellValue(colname.toUpperCase());
			cell.setCellStyle(cs);

			fOut = new FileOutputStream(path);
			workbook.write(fOut);
			fOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	

	public boolean isSheetExist(String sheetname) {
		int index = workbook.getSheetIndex(sheetname);
		if (index == -1) {
			sheet = workbook.getSheetAt(index);
			if (index == -1)
				return false;
			else
				return true;
		} else
			return true;
	}

	public int getColumnCount(String sheetname) {
		if (!isSheetExist(sheetname))
			return -1;
		row = sheet.getRow(0);
		if (row == null)
			return -1;

		return row.getLastCellNum();

	}

}
