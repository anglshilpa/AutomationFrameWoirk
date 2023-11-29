package vt.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	 /**
     * this method will read data from xcel sheet based on row n cell
     * @param sheetName
     * @param rowNum
     * @param cellNum
     * @return
     * @throws Throwable
     */
	 public String readDataFromExcel(String sheetName, int rowNum, int cellNum) throws Throwable
	 {
		 FileInputStream fin=new FileInputStream(IPathConstant.excelFilePath);
		 Workbook workbook = WorkbookFactory.create(fin);
		  Sheet sheet = workbook.getSheet(sheetName);
		   Row row = sheet.getRow(rowNum);
		   Cell cell = row.getCell(cellNum);
		    String value = cell.getStringCellValue();
		    workbook.close();
		    return value;
	 }
	 /**
	  * this method will give u the total number of rows utilized
	  * @param sheetName
	  * @return
	  * @throws Throwable
	  */
	 public int getRowcount(String sheetName) throws Throwable
	 {
		 FileInputStream fin=new FileInputStream(IPathConstant.excelFilePath);
		 Workbook workbook = WorkbookFactory.create(fin);
		 Sheet sheet = workbook.getSheet(sheetName);
		 int rowCount = sheet.getLastRowNum();
		 return rowCount;
	 }
	 /**
	  * this method is generic for adding or writing the content to the excelsheet
	  * @param sheetName
	  * @param rowNum
	  * @param cellNum
	  * @param value
	  * @throws Throwable
	  */
	 public void writeDataIntoExcel(String sheetName, int rowNum, int cellNum, String value) throws Throwable
	 {
		 FileInputStream fin=new FileInputStream(IPathConstant.excelFilePath);
		 Workbook workbook = WorkbookFactory.create(fin);
		 Cell cell = workbook.getSheet(sheetName).createRow(rowNum).createCell(cellNum);
		 cell.setCellValue(value);
		 FileOutputStream fos=new FileOutputStream(IPathConstant.excelFilePath);
		 workbook.write(fos);
		 System.out.println("data Added");
		 workbook.close();
	 }
	 
	 
	 public Object[][] readMultipleData(String SheetName) throws Throwable
	 {
		  FileInputStream fin=new FileInputStream(IPathConstant.excelFilePath);
		  Workbook workbook=WorkbookFactory.create(fin);
		  Sheet sheet = workbook.getSheet(SheetName);
		  int lastRow = sheet.getLastRowNum();
		  int lastCell=sheet.getRow(0).getLastCellNum();
		  
		  Object [][] data=new Object[lastRow][lastCell];
		  for(int i=1; i<lastRow; i++)
		   {
			 for(int j=1; j<lastCell; j++)
			  {
				data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				
			  }
			  }
			  return data;
	 }
	 
	 public Object[][] readDataToCreateMultipleData(String SheeetName) throws Throwable
	 {
		 FileInputStream fin=new FileInputStream(IPathConstant.excelFilePath);
		 Workbook workook=WorkbookFactory.create(fin);
		 Sheet sheet = workook.getSheet(SheeetName);
		 int lastRow = sheet.getLastRowNum();
		 int lastCell=sheet.getRow(0).getLastCellNum();
		 
		 Object[][] data=new Object[lastRow][lastCell];
		 for(int i=1; i<lastRow; i++)
		 {
			 for(int j=1; j<lastCell; j++)
			 {
				 data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			 }
		 }
		 return data;
	 }
	 
	 

}
