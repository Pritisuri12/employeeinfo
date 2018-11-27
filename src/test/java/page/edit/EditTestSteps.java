package page.edit;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import page.base.BaseTestSteps;
import page.base.Constants;

public class EditTestSteps {
    BaseTestSteps base = new BaseTestSteps();
    public String first_element_of_list = "//*[@id=\"employee-list\"]/li[1]";

    public String edit_button="";
    public String empFirstName="/html/body/div/div/div/form/fieldset/label[1]/input";

    public  String save_button=" ";


    @Before
    public void before() {
        base.setup();
    }


    @Given("^that I am login as employee$")
    public void i_am_an_employee() {
        base.getDriver().navigate().to(Constants.baseUrl);
    }
    @Given("^click on the name of first employee$")
    public void i_select_first_employee() {
        Actions action = new Actions(base.getDriver());
        action.moveToElement(base.getDriver().findElement(By.xpath(first_element_of_list))).click().build().perform();
        String nameText= base.getDriver().findElement(By.xpath(first_element_of_list)).getText();
        //System.out.println(c1);

    }


    @Given("^able to see the Edit button")
    public void able_to_see_the_edit_button() {
        base.getDriver().findElement(By.linkText("Edit"));

    }

    @Given("^click on edit button")
    public void click_on_edit_button()
    {
        WebElement ClickButton = base.getDriver().findElement(By.id(edit_button));
        ClickButton.click();
    }
    @When("^able to add sar name of that employee\"([^\"]*)\"$")
    public void able_to_add_sar_name_of_that_employee(String empName)
    {
        base.getDriver().findElement(By.xpath(empFirstName)).sendKeys(empName);
    }
    @When("^I click on save button")
    public void i_click_on_save_button()
    {
        WebElement ClickButton = base.getDriver().findElement(By.id(save_button));
        ClickButton.click();
    }
    @Then("^information of employee is saved")
    public void information_of_employee_is_saved()
    {
       // base.getDriver().findElements(By.ByName);
        //Assert.assertEquals();
    }
}
