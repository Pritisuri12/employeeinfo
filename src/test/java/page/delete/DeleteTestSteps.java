package page.delete;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import page.base.BaseTestSteps;

import java.util.List;

public class DeleteTestSteps {

    BaseTestSteps base = new BaseTestSteps();
    public String first_element_of_list = "//*[@id=\"employee-list\"]/li[1]";

    public String delete_button="bDelete";

    public String nameText;

    @Before
    public void before() {
        base.setup();
    }

    @Given("^that I am logged in$")
    public void i_am_logged_in()
    {
        base.login();
    }

    @Given("^I select first employee$")
    public void i_select_first_employee() {
        Actions action = new Actions(base.getDriver());
        action.moveToElement(base.getDriver().findElement(By.xpath(first_element_of_list))).click().build().perform();
           nameText= base.getDriver().findElement(By.xpath(first_element_of_list)).getText();

    }

    @Given("^able to see the delete button$")
    public void able_to_see_the_delete_button() {
        base.getDriver().findElement(By.linkText("Delete"));

    }

    @When("^I click on delete button$")
    public void i_click_on_delete_button() {
        WebElement ClickButton = base.getDriver().findElement(By.id(delete_button));
        ClickButton.click();

    }

    @Then("^it shows warning message$")
    public void it_shows_warning_message(){
        base.getDriver().switchTo().alert().accept();

    }

    @Then("^delete request can cancelled by click the cancel$")
    public void delete_request_can_cancelled_click_the_cancel(){
        base.getDriver().switchTo().alert().dismiss();
    }

    @Then("^the employee name and detail is deleted from the list$")
    public void the_name_and_detail_is_deleted_from_the_list() {

        List<WebElement> e  = base.getDriver().findElements(By.id("employee-list"));
        int itemCount = e.size();
        for(int l = 0; l < itemCount; l++)
        {
            System.out.println(e.get(l).getText());
            Assert.assertNotEquals(nameText,e.get(l).getText());
        }
        
        
    }
    @After
    public void after() {
        base.getDriver().close();
    }

}

