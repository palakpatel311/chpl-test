package stepDefinitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class overviewTest {

    public WebDriver driver;

    public overviewTest()
    {
        driver = hooks.driver;

    }


    @When("^User clicks on Overview page link in navigation menu$")
    public void user_clicks_on_Overview_page_link_in_navigation_menu() throws Throwable {

        driver.get("https://chpl.ahrqstg.org/#/resources/overview");

    }

    @Then("^Overview page loads successfully and verify title$")
    public void overview_page_loads_successfully_and_verify_title() throws Throwable {

        String actualTitle = driver.getTitle();
        System.out.println("page title is : "+actualTitle);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }


    @When("^User looks at ONC-ACB and ONC-ATL information table$")
    public void user_looks_at_ONC_ACB_and_ONC_ATL_information_table() throws Throwable {
        driver.get("https://chpl.ahrqstg.org/#/resources/overview");
        System.out.println("ONC-ACB and ONC-ATL Information");
    }

    @Then("^the table shows data from databse$")
    public void the_table_shows_data_from_databse() throws Throwable {
        driver.get("https://chpl.ahrqstg.org/#/resources/overview");
        //implicit wait
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);


        // Print and validate ACB  table data

        for(int numberOfRows=1; numberOfRows<=7; numberOfRows++)

            {

		for(int numberOfCol=1; numberOfCol <=4; numberOfCol++)

                    {

                        String sValue = driver.findElement(By.xpath ("//*[@id='mainContent']/div[2]/table[2]/tbody/tr["+numberOfRows+"]/td["+numberOfCol+"]")).getText();
                        System.out.println(sValue);

                        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                    }
            }

    }
}
