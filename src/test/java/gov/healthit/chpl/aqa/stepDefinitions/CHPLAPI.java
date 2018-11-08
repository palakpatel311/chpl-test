/* package gov.healthit.chpl.aqa.stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.healthit.chpl.aqa.pageObjects.ChplApiPage;


/**
 * Class CHPLAPI definition.
 */
/*public class CHPLAPI {
	private WebDriver driver;
	private static final int TIMEOUT = 30;
	private String url = System.getProperty("url");
	ChplApiPage ApiObj;

	/**
	 * Constructor creates new driver.
	 */
/*	public CHPLAPI() {
		driver = Hooks.getDriver();
		System.out.print("Name of the URL is " + url);
		if (StringUtils.isEmpty(url)) {
			url = "http://localhost:3000/";
		}
	}

	@Given("^User is on CHPL API page$")
	public void user_is_on_CHPL_API_page() throws Throwable {
		System.out.println(" URL " + url);
		driver.get(url + "#/resources/chpl_api");
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(ChplApiPage.mainContent(driver)));
	}

	@Then("^CHPL API page title should be \"([^\"]*)\"$")
	public void chpl_API_page_title_should_be(String title) throws Throwable {
		String chplAPITitle = driver.getTitle();
		Assert.assertEquals(chplAPITitle, title);
	}

	@When("^User clicks on Product-Controller link$")
	public void user_clicks_on_Product_Controller_link() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(ChplApiPage.mainContent(driver)));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//*[text()='product-controller']")).click();
	}

	@Then("^list of \"([^\"]*)\" should be displayed$")
	public void list_of_Product_Controller_operations_should_be_displayed(String str) throws Throwable {
		// Getting data from excel file

				// System.out.println("MEthooodddddd Caaalllleeedddddd!!!!!!");

				int productListCounter = driver.findElements(By.xpath("//span[@class='description pull-right ng-binding']"))
						.size();
				//String path = "C:\\Users\\aiyer\\eclipse-workspace\\chpl-test\\src\\test\\resources\\ChplApi.xlsx", sheetName = str;
				
				String path = "C:\\test\\ChplApi.xlsx", sheetName = str;
				new ExcelUtil(path, sheetName);
				ExcelUtil.setExcelFile();
				

			

				/*System.out.println("List of Excel data");
				System.out.println(excelList.toString());*/

				// Getting and matching data from the API with the excel contents
	/*			List<String> apiListFromPage = new ArrayList<>();
				
				/*			//Getting api list from the Page
				for (int i = 0; i < productListCounter; i++) {
					// Calling the method in the ChplApiPage
					String api = ChplApiPage.productController(driver, i).getText();
					apiListFromPage.add(api);
					
				}	
				System.out.println("APi from page list is " + apiListFromPage);
				
				List<String> apiLstExl = new ArrayList<>();
				
				//Getting api list from the excel into the list
				apiLstExl = ExcelUtil.getAllCellData();
				
				//Checking if the api from the excel  present on the webpage
				for (String api: apiLstExl) {
					System.out.println("API to check is " + api);
					assertEquals(apiListFromPage.contains(api), true); 
				}
				
				
				
	}

	@When("^User clicks on Scheduler-Controller link$")
	public void user_clicks_on_Scheduler_Controller_link() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(ChplApiPage.mainContent(driver)));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//*[text()='scheduler-controller']")).click();
	}

	@Then("^list of Scheduler-Controller operations should be displayed$")
	public void list_of_Scheduler_Controller_operations_should_be_displayed() throws Throwable {
		// Getting data from excel file

		// System.out.println("MEthooodddddd Caaalllleeedddddd!!!!!!");

		int productListCounter = driver.findElements(By.xpath("//span[@class='description pull-right ng-binding']"))
				.size();
		String path = "C:\\Users\\aiyer\\eclipse-workspace\\chpl-test\\src\\test\\resources\\ChplApi.xlsx", sheetName = "Scheduler-Controller";

		new ExcelUtil(path, sheetName);
		ExcelUtil.setExcelFile();

		List<String> excelList = new ArrayList<String>();

		for (int i = 0; i < 6; i++) {
			excelList.add(ExcelUtil.getCellData(i, 0));
		}

		/*System.out.println("List of Excel data");
		System.out.println(excelList.toString());*/

		// Getting and matching data from the API with the excel contents

				/*		for (int i = 0; i < productListCounter; i++) {

			// Calling the method in the ChplApiPage
			String api = ChplApiPage.schedulerController(driver, i).getText();

			// System.out.println(i +" : " +api);

			assertEquals(excelList.contains(api), true);
		}

	  
	}

	/*	@When("^User clicks on Collections-Controller link$")
	public void user_clicks_on_Collections_Controller_link() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(ChplApiPage.mainContent(driver)));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//*[text()='collections-controller']")).click();
	}

	@Then("^list of Collections-Controller operations should be displayed$")
	public void list_of_Collections_Controller_operations_should_be_displayed() throws Throwable {
		// Getting data from excel file

		// System.out.println("MEthooodddddd Caaalllleeedddddd!!!!!!");

		int productListCounter = driver.findElements(By.xpath("//span[@class='description pull-right ng-binding']"))
				.size();
		String path = "C:\\Users\\aiyer\\eclipse-workspace\\chpl-test\\src\\test\\resources\\ChplApi.xlsx", sheetName = "Collections-Controller";

		new ExcelUtil(path, sheetName);
		ExcelUtil.setExcelFile();

		List<String> excelList = new ArrayList<String>();

		for (int i = 0; i < 2; i++) {
			excelList.add(ExcelUtil.getCellData(i, 0));
		}
		/*System.out.println("List of Excel data");
		System.out.println(excelList.toString());*/

		// Getting and matching data from the API with the excel contents
				/*		for (int i = 0; i < productListCounter; i++) {

			// Calling the method in the ChplApiPage
			String api = ChplApiPage.collectionsController(driver, i).getText();

			// System.out.println(i +" : " +api);

			assertEquals(excelList.contains(api), true);
		}
	}

	@When("^User clicks on API-Key-Controller link$")
	public void user_clicks_on_API_Key_Controller_link() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(ChplApiPage.mainContent(driver)));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//*[text()='api-key-controller']")).click();
	}

	@Then("^list of API-Key-Controller operations should be displayed$")
	public void list_of_API_Key_Controller_operations_should_be_displayed() throws Throwable {
			// Getting data from excel file

			// System.out.println("MEthooodddddd Caaalllleeedddddd!!!!!!");

			int productListCounter = driver.findElements(By.xpath("//span[@class='description pull-right ng-binding']"))
					.size();
			String path = "C:\\Users\\aiyer\\eclipse-workspace\\chpl-test\\src\\test\\resources\\ChplApi.xlsx", sheetName = "Api-Key-Controller";

			new ExcelUtil(path, sheetName);
			ExcelUtil.setExcelFile();

			List<String> excelList = new ArrayList<String>();

			for (int i = 0; i < 9; i++) {
				excelList.add(ExcelUtil.getCellData(i, 0));
			}
			/*System.out.println("List of Excel data");
			System.out.println(excelList.toString());*/

			// Getting and matching data from the API with the excel contents
				/*			for (int i = 0; i < productListCounter; i++) {

				// Calling the method in the ChplApiPage
				String api = ChplApiPage.ApiKeyController(driver, i).getText();

				//System.out.println(i +" : " +api);

				assertEquals(excelList.contains(api), true);
			}			
		}
	@When("^User clicks on Status-Controller link$")
	public void user_clicks_on_Status_Controller_link() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(ChplApiPage.mainContent(driver)));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		js.executeScript("window.scrollBy(0,700)");
		driver.findElement(By.xpath("//*[text()='status-controller']")).click();
	}

	@Then("^list of Status-Controller operations should be displayed$")
	public void list_of_Status_Controller_operations_should_be_displayed() throws Throwable {
		// Getting data from excel file

		System.out.println("MEthooodddddd Caaalllleeedddddd!!!!!!");

		int productListCounter = driver.findElements(By.xpath("//span[@class='description pull-right ng-binding']"))
				.size();
		String path = "C:\\Users\\aiyer\\eclipse-workspace\\chpl-test\\src\\test\\resources\\ChplApi.xlsx", sheetName = "Status-Controller";

		new ExcelUtil(path, sheetName);
		ExcelUtil.setExcelFile();

		List<String> excelList = new ArrayList<String>();

		for (int i = 0; i < 3; i++) {
			excelList.add(ExcelUtil.getCellData(i, 0));
		}
		//System.out.println("List of Excel data");
		//System.out.println(excelList.toString());

		// Getting and matching data from the API with the excel contents
		for (int i = 0; i < productListCounter; i++) {

			// Calling the method in the ChplApiPage
			String api = ChplApiPage.StatusController(driver, i).getText();

			System.out.println(i +" : " +api);

			assertEquals(excelList.contains(api), true);
		}

	  }
	
}
*/
