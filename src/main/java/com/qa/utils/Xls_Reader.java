package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xls_Reader {
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	public Xls_Reader(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// returns the row count in a sheet
	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return 0;
		else {
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum() + 1;
			return number;
		}

	}

	public String getCellData(String sheetName, String colName, int rowNum, String cellVal) {

		String cellValue = null;
		if (rowNum <= 0)
			return "";

		int index = workbook.getSheetIndex(sheetName);
		int col_Num = -1;
		if (index == -1)
			return "";

		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(rowNum);
		for (int i = 5; i <= 5; i++) {
			System.out.println("1st " + row.getCell(i).getStringCellValue() + "2nd" + cellVal.trim());
			cellValue = row.getCell(i).getStringCellValue();
			if (cellValue.trim().equals(cellVal.trim())) {
				System.out.println("Value Matched");
			}
			break;
		}
		System.out.println("cellValue" + cellValue);
		return cellValue;
	}

	public int getCellRowNum(String sheetName, String colName, String cellValue) {

		for (int i = 0; i <= getRowCount(sheetName); i++) {
			if (getCellData(sheetName, colName, i, cellValue).equalsIgnoreCase(cellValue)) {
				return i;
			}
		}
		return -1;

	}

	public String getCellDatarowNum(String sheetName, String colName, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";
			int index = workbook.getSheetIndex(sheetName);
			int col_Num = -1;
			if (index == -1)
				return "";
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum);
			for (int i = 5; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num = i;
			}
			if (col_Num == -1)
				return "";
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				return "";
			cell = row.getCell(col_Num);
			if (cell == null)
				return "";
			// System.out.println(cell.getCellType().name());
			Object cellValue = null;
			CellType cellType = cell.getCellTypeEnum();// CellType.forInt(cell.getCellType());
			if (cellType == CellType.STRING) {
				cellValue = cell.getStringCellValue();
			} else if (cellType == CellType.NUMERIC) {
				if (DateUtil.isCellDateFormatted(cell)) {
					cellValue = cell.getDateCellValue();
				} else {
					cellValue = cell.getNumericCellValue();
				}
			} else if (cellType == CellType.BOOLEAN) {
				cellValue = cell.getBooleanCellValue();
			} else if (cellType == CellType.FORMULA) {
				cellValue = cell.getCellFormula();
			} else if (cellType == CellType.BLANK) {
				cellValue = "";
			}
			return cellValue.toString();
		} catch (Exception e) {

			e.printStackTrace();
			return "row " + rowNum + " or column " + colName + " does not exist in xls";
		}
	}

	// returns the data from a cell
	public String getCellData(String sheetName, int colNum, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";
			int index = workbook.getSheetIndex(sheetName);
			if (index == -1)
				return "";
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				return "";
			cell = row.getCell(colNum);
			if (cell == null)
				return "";
			Object cellValue = null;
			CellType cellType = cell.getCellTypeEnum();

			if (cellType == CellType.STRING) {
				cellValue = cell.getStringCellValue();
			} else if (cellType == CellType.NUMERIC) {
				if (DateUtil.isCellDateFormatted(cell)) {
					cellValue = cell.getDateCellValue();
				} else {
					cellValue = cell.getNumericCellValue();
				}
			} else if (cellType == CellType.BOOLEAN) {
				cellValue = cell.getBooleanCellValue();
			} else if (cellType == CellType.FORMULA) {
				cellValue = cell.getCellFormula();
			} else if (cellType == CellType.BLANK) {
				cellValue = "";
			}
			return cellValue.toString();

		} catch (Exception e) {

			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist  in xls";
		}
	}

	public boolean setCellData(String sheetName, String colName, int rowNum, String data) {
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			if (rowNum <= 0)
				return false;
			int index = workbook.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return false;
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum = i;
			}
			if (colNum == -1)
				return false;
			sheet.autoSizeColumn(colNum);
			row = sheet.getRow(rowNum);
			if (row == null)
				row = sheet.createRow(rowNum);
			cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);
			// cell style
			CellStyle cs = workbook.createCellStyle();
			cs.setWrapText(true);
			cell.setCellStyle(cs);
			cell.setCellValue(data);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public String addSheet(String sheetname) {

		FileOutputStream fileOut;
		try {
			workbook.createSheet(sheetname);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sheetname;
	}

	// returns true if sheet is removed successfully else false if sheet does
	// not exist
	public boolean removeSheet(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return false;

		FileOutputStream fileOut;
		try {
			workbook.removeSheetAt(index);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// returns true if column is created successfully
	public boolean addColumn(String sheetName, String colName) {
		// System.out.println("**************addColumn*********************");

		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			int index = workbook.getSheetIndex(sheetName);
			if (index == -1)
				return false;

			XSSFCellStyle style = workbook.createCellStyle();
			// style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
			// style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

			sheet = workbook.getSheetAt(index);

			row = sheet.getRow(0);
			if (row == null)
				row = sheet.createRow(0);
			// cell = row.getCell();
			// if (cell == null)
			// System.out.println(row.getLastCellNum());

			if (row.getLastCellNum() == -1)
				cell = row.createCell(0);
			else
				cell = row.createCell(row.getLastCellNum());
			cell.setCellValue(colName);
			cell.setCellStyle(style);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	// removes a column and all the contents
	public boolean removeColumn(String sheetName, int colNum) {
		try {
			if (!isSheetExist(sheetName))
				return false;
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			XSSFCellStyle style = workbook.createCellStyle();
			// style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
			XSSFCreationHelper createHelper = workbook.getCreationHelper();
			// style.setFillPattern(XSSFCellStyle.NO_FILL);
			for (int i = 0; i < getRowCount(sheetName); i++) {
				row = sheet.getRow(i);
				if (row != null) {
					cell = row.getCell(colNum);
					if (cell != null) {
						cell.setCellStyle(style);
						row.removeCell(cell);
					}
				}
			}
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	// find whether sheets exists
	public boolean isSheetExist(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1) {
			index = workbook.getSheetIndex(sheetName.toUpperCase());
			if (index == -1)
				return false;
			else
				return true;
		} else
			return true;
	}

	// returns number of columns in a sheet
	public int getColumnCount(String sheetName) {
		// check if sheet exists
		if (!isSheetExist(sheetName))
			return -1;

		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);

		if (row == null)
			return -1;

		return row.getLastCellNum();

	}

	public int returnRowNumFromTC(String testCaseID) {
		String[] str = testCaseID.split("-");
		String strtcID = str[1];
		int rowNum = Integer.parseInt(strtcID);
		return rowNum;

	}

}
