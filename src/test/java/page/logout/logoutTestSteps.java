package page.logout;

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

public class logoutTestSteps {

    BaseTestSteps base = new BaseTestSteps();
    @Before
    public void before() {
        base.setup();
    }

    @Given("^that I am logged in$")
    public void i_am_logged_in()
    {
        base.login();
    }

    @Given("^I am able to see the logout button$")
    public void i_am_able_to_see_the_logout_button() {
       base.getDriver().findElement(By.className("main-button"));
    }

    @When("^I click on logout button$")
    public void i_click_on_logout_button() {
        Actions action = new Actions(base.getDriver());
        WebElement we = base.getDriver().findElement(By.className("main-button"));
        action.moveToElement(we).build().perform();
    }

    @Then("^I am logged out$")
    public void i_am_logged_out() {
        String url= base.getDriver().getCurrentUrl();
        System.out.println(url);
        Assert.assertEquals(url,"http://cafetownsend-angular-rails.herokuapp.com/login");
    }

    @After
    public void after() {
        base.getDriver().close();
    }

}
