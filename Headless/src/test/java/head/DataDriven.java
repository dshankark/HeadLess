package head;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;


public class DataDriven {
	
	private static Logger logs=LogManager.getLogger(Logger.class.getName());

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis= new FileInputStream("C:\\Users\\Shankar Kumar\\Data.xlsx");
	//	FileOutputStream fos = new FileOutputStream("C:\\Users\\Shankar Kumar\\Data.xlsx");
		

		@SuppressWarnings("resource")
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		
		
		
		      int sheetcount=workbook.getNumberOfSheets();
		      
		      
		      for(int i=0;i<sheetcount;i++) {
		    	  
		    	  System.out.println(workbook.getSheetName(i));
		  //  	if(workbook.getSheetName(i).equalsIgnoreCase("sheet1")){
		    	
		    		XSSFSheet sheet= workbook.getSheetAt(i);
		
		    		Iterator<Row> row   =sheet.iterator();
		    		
		    		
		    		
		    		int r=0;
		    		while(row.hasNext()) {
		    		
                        Row firstrow=row.next();
			    		
			    		Iterator<Cell> celli= firstrow.cellIterator();
		    		
		    		
		    		int a=0;
		    		
		    		while (celli.hasNext()){
		    		Cell Value=celli.next();
		    		if(Value.getCellTypeEnum()==CellType.STRING) {
		    		if(Value.getStringCellValue().equalsIgnoreCase("Firstce")) {
		    			System.out.println(Value.getStringCellValue());
		    			celli.next();
		    					    		}
		    		
		    		System.out.println(Value.getStringCellValue());
		    		}
		    		else {
		    			System.out.println(NumberToTextConverter.toText(Value.getNumericCellValue()));
		    		}
		    		
		    		a++;
		    		
		    				    	}
		    	     
		    	//	row.next();
		    	//	System.out.println(r);
		    		r++;
		    		
		    		
		      }
		    		
		    		

	}  }
	}
//}



