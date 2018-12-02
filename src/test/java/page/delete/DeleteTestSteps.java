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
import page.base.BaseTestSteps;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DeleteTestSteps {

    BaseTestSteps base = new BaseTestSteps();
    public String firstElementOfList = "//*[@id=\"employee-list\"]/li[1]";

    public String deleteButton="bDelete";

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
        action.moveToElement(base.getDriver().findElement(By.xpath(firstElementOfList))).click().build().perform();
           nameText= base.getDriver().findElement(By.xpath(firstElementOfList)).getText();

    }

    @Given("^able to see the delete button$")
    public void able_to_see_the_delete_button() {
        base.getDriver().findElement(By.linkText("Delete"));

    }

    @When("^I click on delete button$")
    public void i_click_on_delete_button() {
        WebElement ClickButton = base.getDriver().findElement(By.id(deleteButton));
        ClickButton.click();

    }

    @Then("^it shows warning message$")
    public void it_shows_warning_message(){
        base.getDriver().switchTo().alert();

    }

    @Then("^delete request can cancelled by click the cancel$")
    public void delete_request_can_cancelled_click_the_cancel(){
        base.getDriver().switchTo().alert().dismiss();
        base.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            Assert.assertEquals(nameText,base.getDriver().findElement(By.xpath(firstElementOfList)).getText());
        }


    @Then("^accept the alert and detail is deleted from the list$")
    public void the_name_and_detail_is_deleted_from_the_list() {
        base.getDriver().switchTo().alert().accept();
        List<WebElement> e  = base.getDriver().findElements(By.id("employee-list"));
        int itemCount = e.size();
        for(int l = 0; l < itemCount; l++)
        {
            Assert.assertNotEquals(nameText,e.get(l).getText());
        }
        
        
    }
    @After
    public void after() {
        base.getDriver().close();
    }

}

