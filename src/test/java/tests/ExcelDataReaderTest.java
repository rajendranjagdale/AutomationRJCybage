package tests;

import java.io.IOException;

import org.testng.annotations.Test;
import data.ExcelDataReader;

public class ExcelDataReaderTest extends BaseTest {

	@Test(priority = 1, groups = { "Smoke" }, description = "The method to test the excel file data validation.")
	public void testExcelData() throws IOException {
		String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\TestData.xlsx";
		ExcelDataReader excel = new ExcelDataReader(filePath, "Employee");

		// Example: find salary of employee with Name = "Smith"
		String salary = excel.getCellDataByUniqueValue("Name", "Smith", "Salary");
		System.out.println("Smith's Salary: " + salary);

		// Example: find email of employee with ID = "103"
		String email = excel.getCellDataByUniqueValue("ID", "103", "Email");
		System.out.println("Alice's Email: " + email);
	}

}
