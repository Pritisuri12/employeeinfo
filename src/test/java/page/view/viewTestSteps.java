package page.view;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import page.base.BaseTestSteps;

public class viewTestSteps {

    public String first_element_of_list = "//*[@id=\"employee-list\"]/li[1]";
    BaseTestSteps base = new BaseTestSteps();

    @Before
    public void before() {
        base.setup();
    }

    @Given("^that I am logged in$")
    public void i_am_logged_in() {
        base.login();
    }

    @When("^I double click on the employee name$")
    public void i_double_click_on_employee_name() {
        Actions action = new Actions(base.getDriver());
        action.moveToElement(base.getDriver().findElement(By.xpath(first_element_of_list))).doubleClick().build().perform();

    }

    @Then("^I should be able to see detailed information$")
    public void i_should_be_able_to_see_detailed_information() {
        String url = base.getDriver().getTitle();
        System.out.println(url);

        //Assert.assertEquals(url,"http://cafetownsend-angular-rails.herokuapp.com/employees/30192/edit);");

    }


    private void closeBrowser() {
    }

    @After
    public void after() {
        base.getDriver().close();
    }
}
