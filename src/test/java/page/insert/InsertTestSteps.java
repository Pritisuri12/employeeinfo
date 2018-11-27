package page.insert;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.base.BaseTestSteps;
import page.base.Constants;

public class InsertTestSteps {

    BaseTestSteps base = new BaseTestSteps();

    public String create_button="bAdd";

    public String empFirstName="/html/body/div/div/div/form/fieldset/label[1]/input";
    public String empLastName="/html/body/div/div/div/form/fieldset/label[2]/input";
    public String empStartDate="/html/body/div/div/div/form/fieldset/label[3]/input";
    public String empEmailId="/html/body/div/div/div/form/fieldset/label[4]/input";

    public String add_button="main_button";


    @Before
    public void before() {
        base.setup();
    }


    @Given("^that I am logged in$")
    public void i_am_logged_in() {
        base.login();
    }

    @Given("^I am able to see the create button$")
    public void i_am_to_see_the_create_button() {
        base.getDriver().findElement(By.linkText("Create"));

    }

    @Given("^I click on the create button$")
    public void i_click_on_the_create_button() {
        WebElement ClickButton = base.getDriver().findElement(By.id(create_button));
        ClickButton.click();

    }

    @Given("^I inserted first name \"([^\"]*)\"$")
    public void i_inserted_first_name(String empName) {
        base.getDriver().findElement(By.xpath(empFirstName)).sendKeys(empName);


    }
    @Given("^entered last name is \"([^\"]*)\"$")
    public void entered_last_name_is(String lastName) {
        base.getDriver().findElement(By.xpath(empLastName)).sendKeys(lastName);

    }

    @Given("^entered start date \"([^\"]*)\"$")
    public void entered_start_date_is(String date) {
        base.getDriver().findElement(By.xpath(empStartDate)).sendKeys(date);

    }

    @Given("^entered email id \"([^\"]*)\"$")
    public void entered_email_id(String emailId){
        base.getDriver().findElement(By.xpath(empEmailId)).sendKeys(emailId);

    }

    @Then("^the click on add button$")
    public void the_click_on_add_button() {
        WebElement ClickButton = base.getDriver().findElement(By.className(add_button));
        ClickButton.click();


    }
}

