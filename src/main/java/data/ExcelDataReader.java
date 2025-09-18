package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	File file;
	FileInputStream fileInputStream;

	public ExcelDataReader(String filePath, String sheetName) throws IOException {
		fileInputStream = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(sheetName);
	}

	/**
	 * The method to get the excel file cell value
	 *
	 * @param rowNum the row number
	 * @param colNum the column number
	 * @return the cell value as String
	 */
	public String getCellData(int rowNum, int colNum) {
		return sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
	}

	/**
	 * The method to get the row count of the sheet
	 *
	 * @return the excel file row count
	 */
	public int getRowCount() {
		return sheet.getPhysicalNumberOfRows();
	}

	/**
	 * The method to get the column count of the sheet
	 *
	 * @return the excel file column count
	 */
	public int getColCount() {
		return sheet.getRow(0).getPhysicalNumberOfCells();
	}

	/**
	 * The method to get the row number based on unique column value
	 * 
	 * @param columnName  the column name
	 * @param uniqueValue the unique row value for given column
	 * @return the row number
	 */
	public int getRowNumByValue(String columnName, String uniqueValue) {
		int colIndex = getColumnIndex(columnName);

		for (int i = 1; i < getRowCount(); i++) { // start from row 1 (skip header)
			String cellValue = getCellData(i, colIndex);
			if (cellValue.equalsIgnoreCase(uniqueValue)) {
				return i;
			}
		}
		return -1; // if not found
	}

	// 🔹
	/**
	 * The method to get cell value using unique row + column name
	 * 
	 * @param uniqueColumnName the unique column name
	 * @param uniqueValue      the unique row value
	 * @param targetColumnName the target column for cell data
	 * @return the cell data in string format
	 */
	public String getCellDataByUniqueValue(String uniqueColumnName, String uniqueValue, String targetColumnName) {
		int rowNum = getRowNumByValue(uniqueColumnName, uniqueValue);
		if (rowNum == -1)
			return "";

		int targetCol = getColumnIndex(targetColumnName);
		return getCellData(rowNum, targetCol);
	}

	/**
	 * The method to find column index by column header name
	 * 
	 * @param columnName the column name
	 * @return the column index value
	 */
	private int getColumnIndex(String columnName) {
//		XSSFRow headerRow = sheet.getRow(0);
		XSSFRow headerRow = sheet.getRow(1);
		for (int j = 0; j < headerRow.getLastCellNum(); j++) {
			String colName = getCellData(0, j);
			if (colName.equalsIgnoreCase(columnName)) {
				return j;
			}
		}
		return -1; // if not found
	}
}
