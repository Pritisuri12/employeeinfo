package page.insert;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.base.BaseTestSteps;
import page.base.Constants;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class InsertTestSteps {

    BaseTestSteps base = new BaseTestSteps();

    public String create_button="bAdd";

    public String empFirstName="/html/body/div/div/div/form/fieldset/label[1]/input";
    public String empLastName="/html/body/div/div/div/form/fieldset/label[2]/input";
    public String empStartDate="/html/body/div/div/div/form/fieldset/label[3]/input";
    public String empEmailId="/html/body/div/div/div/form/fieldset/label[4]/input";

    public String add_button="main_button";
    public String fName;
    public String lName;
    public String nameText;


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
    public void i_inserted_first_name(String firstName) {
        base.getDriver().findElement(By.xpath(empFirstName)).sendKeys(firstName);
        fName = firstName;

    }
    @Given("^entered last name is \"([^\"]*)\"$")
    public void entered_last_name_is(String lastName) {
        base.getDriver().findElement(By.xpath(empLastName)).sendKeys(lastName);
        lName =lastName;

    }

    @Given("^entered start date \"([^\"]*)\"$")
    public void entered_start_date_is(String date) {
        base.getDriver().findElement(By.xpath(empStartDate)).sendKeys(date);

    }

    @Given("^entered email id \"([^\"]*)\"$")
    public void entered_email_id(String emailId){
        base.getDriver().findElement(By.xpath(empEmailId)).sendKeys(emailId);

    }

    @When("^I click on add button$")
    public void the_click_on_add_button() {
       // base.getDriver().submit();
        WebElement ClickButton = base.getDriver().findElement(By.cssSelector("body > div > div > div > form > fieldset > div > button:nth-child(2)"));
                ClickButton.click();


    }

    @Then("^the tooltip came shows$")
        public void the_tooltip_came_shows()
        {

        }

    @Then("^the new employee is added in the list$")
    public void the_new_employee_is_added_in_the_list()
    {
        base.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        List<WebElement> e  = base.getDriver().findElements(By.id("employee-list"));
        int itemCount = e.size();
        for(int l = 0; l < itemCount; l++)
        {
             System.out.println(e.get(l).getText());
           // Assert.assertEquals(nameText=fName+lName,e.get(l).getText());
        }
    }
    @After
    public void after() {
        base.getDriver().close();
    }

}

