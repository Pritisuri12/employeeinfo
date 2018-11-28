package page.base;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTestSteps {
    public WebDriver getDriver() {
        return driver;
    }

    protected WebDriver driver;

    public void setup() {
        System.setProperty("webdriver.chrome.driver", getClass().getClassLoader().getResource("driver/mac/chromedriver").getPath());
        driver = new ChromeDriver();
        driver.get(Constants.baseUrl);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }

    public void login() {
        driver.navigate().to(Constants.baseUrl);
        driver.findElement(By.xpath(Constants.username_xpath)).sendKeys(Constants.username);
        driver.findElement(By.xpath(Constants.password_xpath)).sendKeys(Constants.password);
        WebElement ClickButton = driver.findElement(By.xpath(Constants.login_button));
        ClickButton.click();
    }

    public void teardown() {
       if (driver!=null){
           driver.close();
           driver.quit();
           driver = null;
       }
    }

}
