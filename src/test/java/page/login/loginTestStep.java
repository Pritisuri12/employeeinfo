package page.login;

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

import java.util.concurrent.TimeUnit;

public class loginTestStep {

    BaseTestSteps base = new BaseTestSteps();

    @Before
    public void before() {
        base.setup();
    }

    @Given("^that I want to login as employee$")
    public void i_want_to_login_an_employee() {
        base.getDriver().navigate().to(Constants.baseUrl);
    }

    @When("^I enter the user name \"([^\"]*)\"$")
    public void i_enter_the_user_name(String username) {
        base.getDriver().findElement(By.xpath(Constants.username_xpath)).sendKeys(username);
    }

    @When("^password value \"([^\"]*)\"$")
    public void password_value(String password) {
        base.getDriver().findElement(By.xpath(Constants.password_xpath)).sendKeys(password);
    }

    @When("^click on login button$")
    public void click_on_click_button() {
        WebElement ClickButton = base.getDriver().findElement(By.xpath(Constants.login_button));
        ClickButton.click();
    }

    @Then("^I should be able to login$")
    public void i_should_be_able_to_login() {
        String title = base.getDriver().getTitle();
        Assert.assertEquals(title, "CafeTownsend-AngularJS-Rails");
    }

    @Then("^I should get warning message$")
    public void i_should_get_warning_message() {
        WebDriverWait wait=new WebDriverWait(base.getDriver(), 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login-form > fieldset > p.error-message.ng-binding")));
        String errorMessage = base.getDriver().findElement(By.cssSelector("#login-form > fieldset > p.error-message.ng-binding")).getText();
        Assert.assertEquals("Invalid username or password!", errorMessage);
    }

    @After
    public void after() {
        base.getDriver().close();
    }


}