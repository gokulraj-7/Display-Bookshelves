package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadUtils {

	public static String[] FileData() throws IOException

	{

		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\Testdata\\Testdata.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);

		String[] val = new String[8];

		XSSFSheet sheet = workbook.getSheetAt(0);

		XSSFRow row = sheet.getRow(0);

		for (int c = 0; c < 8; c++) {

			DataFormatter format = new DataFormatter();
			XSSFCell cell = row.getCell(c);
			val[c] = format.formatCellValue(cell);
		}

		workbook.close();
		file.close();
		return val;

	}

}