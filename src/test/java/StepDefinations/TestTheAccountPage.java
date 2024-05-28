package StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.loginPage;

import java.time.Duration;
import java.util.List;

public class TestTheAccountPage {private WebDriver driver;
private loginPage loginPageImported;
    @Given("I am on Account Page")
    public void iAmOnAccountPage(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\LENOVO\\Downloads\\chromedriver-win32 (5)\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPageImported = new loginPage(driver);
        loginPageImported.loginToApplication("rahul","rahul@2021" );
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.search-empty-button")));
        String actlUrl= driver.getCurrentUrl();
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(actlUrl,"https://qamoviesapp.ccbp.tech/","emptyfields not displayed");
    }
    @And("Test all the UI elements present on the web page")
    public void testAllTheUIElementsPresentOnTheWebPage(){
        WebElement imgEl= driver.findElement(By.cssSelector("button.avatar-button"));
        imgEl.click();

        WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.logout-button")));

        WebElement h1El = driver.findElement(By.tagName("h1"));
        System.out.println(h1El.getText());

        WebElement pEl = driver.findElement(By.xpath("//p[text()='Member ship']"));
        System.out.println(pEl.getText());

        List<WebElement> listEl = driver.findElements(By.cssSelector("div.membership-details-container p"));
        //WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(10));
        //wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.logout-button")));
        for(WebElement item:listEl){
            System.out.println(item.getText());
        }
    }
    @And("Test the Logout functionality")
    public void testTheLogoutFunctionality(){
        WebElement btnEl = driver.findElement(By.cssSelector("button.logout-button"));
        btnEl.click();
        String actlUrl1=driver.getCurrentUrl();

        Assert.assertEquals(actlUrl1,"https://qamoviesapp.ccbp.tech/login","login page not displayed");
    }
    @Then("Close the Account Page browser window")
    public void closeTheAccountPageBrowserWindow(){
        driver.quit();
    }
}
