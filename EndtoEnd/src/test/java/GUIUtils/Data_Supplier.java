package GUIUtils;
// Author -Diwakar
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestNGMethod;
import org.testng.annotations.DataProvider;

public class Data_Supplier {

	@DataProvider(name="Data")
	public Object[][]datasupplier(ITestNGMethod testContext ) throws IOException
	{
		
		File file=new File("./TestData/TestData.xlsx");
		FileInputStream fis=new FileInputStream(file);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet = null;
		 sheet=wb.getSheet(testContext.getMethodName());
		 wb.close();
		
		int rowsCount=sheet.getLastRowNum();
		int colCount=sheet.getRow(0).getLastCellNum();
		
		Object [][]obj=new Object[rowsCount][1];

		for (int i=0;i<rowsCount;i++)
		{
			Map<Object,Object> datamap=new HashMap<Object, Object>();
			for(int j=0;j<colCount;j++)
			{
				datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());
				obj[i][0]=datamap;
			}
			
		}
			
		return obj;
	}
	
}
