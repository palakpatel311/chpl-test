package gov.healthit.chpl.aqa.stepDefinitions;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Class ExcelUtil Utility class.
 */
public final class ExcelUtil {
    private static XSSFSheet excelWSheet;
    private static XSSFWorkbook excelWBook;
    private static XSSFCell cell;

    /**
     * String path points to the location of the ChplApi.xlsx, includes all the APIs based on the categories.
     */
    private static String path = System.getProperty("user.dir") + "\\src\\test\\resources\\ChplApi.xlsx";
    private ExcelUtil(final String sheetName) {
        System.out.println("Name of the sheet File is " + sheetName);
    }

    /**
     * Read the APIs from excel.
     * @param args String array
     */
    public static void main(final String[] args) {
        String sheetName = "Sheet1";
        ExcelUtil.setExcelFile(sheetName);
    }

    /**
     * Set the File path and open the Excel sheet.
     *  @param sheetName as Arguments to this method
     */
    public static void setExcelFile(final String sheetName) {
        try {
            FileInputStream excelFile = new FileInputStream(path);
            excelWBook = new XSSFWorkbook(excelFile);
            excelWSheet = excelWBook.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Getting the list of APIs from the excel.
     * @return API list
     */
    public static List<String> getAllCellData() {
        List<String> tempList = new ArrayList<>();
        for (int row = 0; row < excelWSheet.getLastRowNum() + 1; row++) {
            String api = getCellData(row, 0);
            tempList.add(api);
        }
        return tempList;
    }

    /**
     * Read data from the Excel cell.
     * @param rowNum defines the row number
     * @param colNum defines the column number
     * @return data
     */
    public static String getCellData(final int rowNum, final int colNum) {
        try {
            cell = excelWSheet.getRow(rowNum).getCell(colNum);
            String cellData = cell.getStringCellValue();
            return cellData;
        } catch (Exception e) {
            return null;
        }
    }
}
