package reports;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Set;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import constants.FrameworkConstants;
import utilities.DateUtils;

/**
 * This class defines the Extent report initialization, setup and report
 * creation methods
 */
public class ExtentReport {

	private static ExtentReports extentReport;
	private static String formattedCurrentDate;
	private static String excelResultFile;

	private ExtentReport() {
	}

	/**
	 * The method to initialize the extent report
	 *
	 * @throws IOException
	 */
	public static void initReports() throws IOException {
		if (Objects.isNull(extentReport)) {
			formattedCurrentDate = DateUtils.getSimpleFormatCurrentDate();
			String reportPathString = FrameworkConstants.getResultsFolderPath() + formattedCurrentDate;
			File file = new File(reportPathString);
			file.mkdir();
			extentReport = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(
					reportPathString + "/" + formattedCurrentDate + ".html");
			extentReport.attachReporter(spark);
			spark.loadXMLConfig(new File(FrameworkConstants.getExtentConfigFilePath()));
		}
	}

	/**
	 * The method to flush the report generated for test execution
	 */
	public static void flushReports() {
		if (Objects.nonNull(extentReport)) {
			extentReport.flush();
		}
	}

	/**
	 * The method to initialize the test and get the test case data
	 *
	 * @param testCaseName the name of the test
	 */
	public static void createTest(String testCaseName) {
		ExtentManager.setExtentTest(extentReport.createTest(testCaseName));
	}

	public static void writeResultsToExcel(ITestContext context) throws IOException {
		excelResultFile = FrameworkConstants.getResultsFolderPath() + formattedCurrentDate + "/" + formattedCurrentDate
				+ ".xlsx";

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Test Results");
		XSSFRow headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("Sr. No.");
		headerRow.createCell(1).setCellValue("Test Case Name");
		headerRow.createCell(2).setCellValue("Status");

		Set<ITestResult> passTests = context.getPassedTests().getAllResults();
		Set<ITestResult> failTests = context.getFailedTests().getAllResults();
		Set<ITestResult> skipTests = context.getSkippedTests().getAllResults();

		int rowNum = 1;

		for (ITestResult result : passTests) {
			addResultsToExcel(result, "PASS", rowNum++, sheet);
		}

		for (ITestResult result : failTests) {
			addResultsToExcel(result, "FAIL", rowNum++, sheet);
		}

		for (ITestResult result : skipTests) {
			addResultsToExcel(result, "SKIPP", rowNum++, sheet);
		}

		FileOutputStream fos = new FileOutputStream(excelResultFile);
		workbook.write(fos);
		workbook.close();
	}

	private static void addResultsToExcel(ITestResult result, String status, int rowNum, XSSFSheet sheet) {
		XSSFRow row = sheet.createRow(rowNum);
		row.createCell(0).setCellValue(rowNum);
		row.createCell(1).setCellValue(result.getMethod().getMethodName());
		row.createCell(2).setCellValue(status);
	}
}
