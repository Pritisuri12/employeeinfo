package page.edit;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import page.base.BaseTestSteps;
import page.base.Constants;

public class EditTestSteps {
    public String first_element_of_list = "//*[@id=\"employee-list\"]/li[1]";
    public String empStartDate = "/html/body/div/div/div/form/fieldset/label[3]/input";
    public String edit_button_id = "bEdit";
    public String empFirstName = "/html/body/div/div/div/form/fieldset/label[1]/input";
    public String update_button = " main-button";
    BaseTestSteps base = new BaseTestSteps();

    @Before
    public void before() {
        base.setup();
    }

    @Given("^that I am logged in$")
    public void i_am_an_employee() {
        base.login();
    }

    @Given("^click on the name of first employee$")
    public void i_select_first_employee() {
        Actions action = new Actions(base.getDriver());
        action.moveToElement(base.getDriver().findElement(By.xpath(first_element_of_list))).click().build().perform();
    }

    @Given("^able to see the Edit button")
    public void able_to_see_the_edit_button() {
        base.getDriver().findElement(By.linkText("Edit"));
    }

    @Given("^click on edit button")
    public void click_on_edit_button() {
        WebElement ClickButton = base.getDriver().findElement(By.id(edit_button_id));
        ClickButton.click();
    }

    @Given("^able to add sur name \"([^\"]*)\"$")
    public void able_to_add_sar_name_of_that_employee(String empName) {
        base.getDriver().findElement(By.xpath(empFirstName)).sendKeys(empName);
    }

    @Given("able to add date \"([^\"]*)\"$")
    public void able_to_add_date(String date) {
        base.getDriver().findElement(By.xpath(empStartDate)).sendKeys(date);
    }

    @When("^I click on update button")
    public void i_click_on_save_button() {
        WebElement ClickButton = base.getDriver().findElement(By.className(update_button));
        ClickButton.click();
    }

    @Then("^information of employee is saved")
    public void information_of_employee_is_saved() {

    }

  /* @After
   // public void after() {
    //    driver.quit();
    */

    // @Then("^I will get warning message")
    // public void i_will_get_warning_message() {

    //}
}
