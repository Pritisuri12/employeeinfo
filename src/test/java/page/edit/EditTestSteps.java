package page.edit;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.base.BaseTestSteps;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EditTestSteps {
    public String firstElementOfList = "//*[@id=\"employee-list\"]/li[1]";
    public String empStartDate = "/html/body/div/div/div/form/fieldset/label[3]/input";
    public String editButtonId = "bEdit";
    public String empFirstName = "body > div > div > div > form > fieldset > label:nth-child(3) > input";
    public String empLastName="body > div > div > div > form > fieldset > label:nth-child(4) > input";
    public String updateButton = " main-button";
    private BaseTestSteps base = new BaseTestSteps();
    public String fName;
    public  String lName;

    @Before
    public void before() {
        base.setup();
    }

    @Given("^that I am logged in$")
    public void i_am_an_employee() {
        base.login();
        base.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Given("^click on the name of first employee$")
    public void i_select_first_employee() {
        base.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Actions action = new Actions(base.getDriver());
        action.moveToElement(base.getDriver().findElement(By.xpath(firstElementOfList))).click().build().perform();
    }

    @Given("^able to see the Edit button")
    public void able_to_see_the_edit_button() {
        base.getDriver().findElement(By.linkText("Edit"));
    }

    @Given("^click on edit button")
    public void click_on_edit_button() {
        WebElement ClickButton = base.getDriver().findElement(By.id(editButtonId));
        ClickButton.click();
    }

    @Given("^able to add sur name \"([^\"]*)\"$")
    public void able_to_add_sur_name_of_that_employee(String empName) {
        base.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        base.getDriver().findElements(By.cssSelector(empFirstName)).clear();
        base.getDriver().findElement(By.cssSelector(empFirstName)).sendKeys(empName);
        fName = empName;
        lName = base.getDriver().findElement(By.cssSelector(empLastName)).getText();
    }


    @Given("able to add new date \"([^\"]*)\"$")
    public void able_to_add_date(String date) {
        base.getDriver().findElement(By.xpath(empStartDate)).clear();
        base.getDriver().findElement(By.xpath(empStartDate)).sendKeys(date);
    }

    @When("^I click on update button")
    public void i_click_on_save_button() {
        WebElement ClickButton = base.getDriver().findElement(By.className(updateButton));
        ClickButton.click();
       // base.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Then("^information of employee is saved")
    public void information_of_employee_is_saved() {
        WebDriverWait wait=new WebDriverWait(base.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(base.getDriver().findElements(By.id("employee-list"))));
        //TODO:As the list grew, it is taking time to render the users
        //I had to add sleep to make sure the page is fully loaded before
        //I continue.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> e  = base.getDriver().findElements(By.id("employee-list"));
        boolean found =  false;
        String expectedName = fName + " " + lName;
        String[] name = e.get(0).getText().split("\n");
        for(int l = 0; l < name.length; l++)
        {
            if( expectedName.equals(name[l])){
                found = true;
                break;
            }
        }

        Assert.assertEquals(found, true);
    }


     @Then("^I will get warning message")
     public void i_will_get_warning_message() {
         base.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         String github = base.getDriver().findElement(By.xpath("/html/body/div/div/div/form/fieldset/label[1]/input")).getAttribute("title");

         //TODO:get the value of the "title" attribute of the github icon
        // String actualTooltip = github.getAttribute("title");
         //Assert the tooltip's value is as expected
         System.out.println(github);

     }

    @After
    public void after() {
        base.getDriver().close();
    }

}
