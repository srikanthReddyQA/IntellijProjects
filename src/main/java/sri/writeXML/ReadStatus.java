package sri.writeXML;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadStatus {

	public static XSSFWorkbook wrkbk;
	public static XSSFSheet sht;
	public static int tcfoundrow;


	//Constructor to intialize the "Excel Workbook"
	


		public  ReadStatus(String path)
			
		{
			File f=new File(path);
			
			try
			{
			FileInputStream fis=new FileInputStream(f);
			
			wrkbk=new XSSFWorkbook(fis);
			}
			catch(Exception e)
			{
				System.out.println(e);				
			}			
			
		}
		
		//Function to store all the test cases which are marked as "Yes
		
		public static List<String> storeTestcaseNeedToExecute(String sheet)
		{
			List<String> lst=new ArrayList<String>();
			
			int rowcnt=wrkbk.getSheet(sheet).getLastRowNum();
			
			sht=wrkbk.getSheet(sheet);
			
			for(int i=1;i<=rowcnt;i++)
			{
				String Testcase=sht.getRow(i).getCell(0).getStringCellValue().trim();
				
				String Exec=sht.getRow(i).getCell(2).getStringCellValue().toUpperCase().trim();
				
				
				if(Exec.equals("YES"))
				{
					lst.add(Testcase);		
					
				}
				
				
			}
			
				return lst;
				
				
			
		}
		
		
		//Function to search currenttestcase in business Flow sheet
		
		public  int searchTestCase(String Testcase,String sheetname)
		{
			tcfoundrow=0;
			int rowcnt=rowCount( sheetname);
			
			for(int i=1;i<=rowcnt;i++)
			{
				String crnttcname=sht.getRow(i).getCell(0).getStringCellValue();
				
				if(crnttcname.equalsIgnoreCase(Testcase))
				{
					
					tcfoundrow= i;	
					
					break;
					
				}
				
				
			}
			return tcfoundrow;
			
		}


		//Function to Row Count for any sheet
		
		public  int rowCount(String sheetname)
		{
			
			 sht=wrkbk.getSheet(sheetname);
			
			return sht.getLastRowNum();
		}
		
		//Function to Col Count for a specific row
		
		public  int colCount(String sheetname,int row)
		{
			
			 sht=wrkbk.getSheet(sheetname);
			
			return sht.getRow(row).getLastCellNum();
		}
		
		
		
		
}
