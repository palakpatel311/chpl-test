package gov.healthit.chpl.aqa.stepDefinitions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	private static XSSFSheet excelWSheet;
	private static XSSFWorkbook excelWBook;
	private static XSSFCell cell;
	public static List<String> list;
	public static String path = "", sheetName = "";

	public ExcelUtil(String path, String sheet) {

		ExcelUtil.path = path;
		ExcelUtil.sheetName = sheet;
		// list = new ArrayList<>();
	}

	public static void main(String[] args) throws Exception {

		//path = "C:\\Users\\aiyer\\eclipse-workspace\\chpl-test\\src\\test\\resources\\ChplApi.xlsx";
		//sheetName = "Sheet1";

		ExcelUtil.setExcelFile();

		/*
		 * for (int i = 0; i < 6; i++) { list.add(e1.getCellData(i, 0)); }
		 * 
		 * System.out.println(list.toString());
		 */
	}

	/*
	 * This method is to set the File path and to open the Excel file.
	 *  Pass Excel Path and Sheet name as Arguments to this method
	 */

	public static void setExcelFile() throws Exception {

		try {

			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(path);

			// Access the Excel workbook
			excelWBook = new XSSFWorkbook(ExcelFile);
			// Access the Excel Sheet
			excelWSheet = excelWBook.getSheet(sheetName);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static List getAllCellData() throws Exception {
		
		List<String> tempList = new ArrayList<>();
		for(int row = 0 ; row<excelWSheet.getLastRowNum()+1 ; row++) {
			String api = getCellData(row,0);
			tempList.add(api);
		}
		System.out.println("APi from page Excel is " + tempList);

		return tempList;
	}

	/*
	 * This method is to read the test data from the Excel cell 
	 * Passing parameters as Row number and Column number
	 */

	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {
			// Access a particular cell in a sheet
			cell = excelWSheet.getRow(RowNum).getCell(ColNum);

			String CellData = cell.getStringCellValue();

			return CellData;

		} catch (Exception e) {

			return null;
		}
	}

}
