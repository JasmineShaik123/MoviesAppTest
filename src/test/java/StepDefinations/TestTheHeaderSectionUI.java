package StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.loginPage;

import java.time.Duration;

public class TestTheHeaderSectionUI {private WebDriver driver;
    private loginPage loginPageImported;
    @Given("I am on Header Section Page")
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

    @And("Test whether the Website logo is displayed or not")
    public void testWhetherTheWebsiteLogoIsDisplayedOrNot(){
        WebElement btnEl = driver.findElement(By.cssSelector("img.website-logo"));
        //WebElement btnEl = driver.findElement(By.cssSelector("button.home-movie-play-button"));
        System.out.println(btnEl.isDisplayed());
    }
    @And("Test the Navbar elements")
    public void testTheNavbarElements(){
        WebElement homeEl = driver.findElement(By.xpath("//a[text()='Home']"));
        //WebElement btnEl = driver.findElement(By.cssSelector("button.home-movie-play-button"));
        System.out.println(homeEl.isDisplayed());

        WebElement pplrEl = driver.findElement(By.xpath("//a[text()='Popular']"));
        //WebElement btnEl = driver.findElement(By.cssSelector("button.home-movie-play-button"));
        System.out.println(pplrEl.isDisplayed());

        WebElement btnnEl = driver.findElement(By.cssSelector("button.search-empty-button"));
        //WebElement btnEl = driver.findElement(By.cssSelector("button.home-movie-play-button"));
        System.out.println(btnnEl.isDisplayed());

        WebElement btnEl1 = driver.findElement(By.cssSelector("button.search-empty-button"));
        //WebElement btnEl = driver.findElement(By.cssSelector("button.home-movie-play-button"));
        System.out.println(btnEl1.isDisplayed());

        WebElement btnEl2 = driver.findElement(By.cssSelector("button.avatar-button"));
        //WebElement btnEl = driver.findElement(By.cssSelector("button.home-movie-play-button"));
        System.out.println(btnEl2.isDisplayed());
    }
    @Then("Close the browser window.")
    public void closeTheBrowserWindow(){
        driver.quit();
    }
}

