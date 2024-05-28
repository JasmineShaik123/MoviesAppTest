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

public class TestTheHeaderSectionFunctionalities {private WebDriver driver;
    private loginPage loginPageImported;
    @Given("I am on Header Section page")
    public void iAmOnHeaderSectionPage(){
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
    @And("Test the navigation to the Home and Popular pages through elements in the header section")
    public void testTheNavigationToTheHomeAndPopularPagesThroughElementsInTheHeaderSection(){
        WebElement homeEl = driver.findElement(By.xpath("//a[text()='Home']"));
        homeEl.click();

        WebElement pplrEl = driver.findElement(By.xpath("//a[text()='Popular']"));
        pplrEl.click();
    }
    @And("Test the navigation to the account page through elements in the header section")
    public void testTheNavigationToTheAccountPageThroughElementsInTheHeaderSection(){
        WebElement btnEl2 = driver.findElement(By.cssSelector("button.avatar-button"));
        btnEl2.click();
    }
    @Then("Close the browser Window")
    public void closeTheBrowserwindow(){
        driver.quit();
    }
}
