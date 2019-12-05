package reader;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	@SuppressWarnings("resource")
	public static String[][] readData(String sheetName) throws IOException{
		String[][] inputData;
		
		String filePath = System.getProperty("user.dir")+"/TestData/";
		FileInputStream fis = new FileInputStream(filePath+"InputData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		int totalRows = sheet.getLastRowNum()-sheet.getFirstRowNum();
		int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();
		
		inputData = new String[totalRows][totalCols];
		//loop over row
		for(int i=0;i<totalRows;i++) {
			Row row = sheet.getRow(i+1);
			for(int j=0;j<totalCols;j++) {
				if(row.getCell(j)!=null) {
					inputData[i][j] = row.getCell(j).getStringCellValue();
				}
			}
		}
	
		return inputData;
		
	}

}
