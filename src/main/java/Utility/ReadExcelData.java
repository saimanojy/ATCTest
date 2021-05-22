package Utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.*;

public class ReadExcelData {
	public static HashMap<String, String> storeValues = new HashMap<String, String>();

	// reads Excel data and returns HashMap of values
	public static List<HashMap<String, String>> readExcelDatafromFile(String filePath, String sheetName) {
		// creating Java List to store Hashmaps
		List<HashMap<String, String>> excelData = new ArrayList<HashMap<String, String>>();

		try {
			FileInputStream fs = new FileInputStream(filePath);
			XSSFWorkbook wb = new XSSFWorkbook(fs);
			XSSFSheet sheet = wb.getSheet("Sheet1");
			// header row as key
			Row HeaderRow = sheet.getRow(0);
			for (int r = 1; r < sheet.getPhysicalNumberOfRows(); r++) {
				Row CurrentRow = sheet.getRow(r);
				// each row of data is stored in new hashmap
				HashMap<String, String> currentRowMap = new HashMap<String, String>();
				// System.out.println(CurrentRow.getPhysicalNumberOfCells());
				for (int c = 0; c < CurrentRow.getPhysicalNumberOfCells(); c++) {
					Cell CurrentCell = CurrentRow.getCell(c, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					currentRowMap.put(HeaderRow.getCell(c).getStringCellValue(), CurrentCell.getStringCellValue());
				}
				excelData.add(currentRowMap);
			}
			wb.close();
			fs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return excelData;
	}
}
