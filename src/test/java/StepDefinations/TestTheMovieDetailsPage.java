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

public class TestTheMovieDetailsPage {private WebDriver driver;
private loginPage loginPageImported;
    @Given("I am on movie details page")
    public void iAmOnMovieDetailsPage(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\chromedriver-win32 (5)\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPageImported = new loginPage(driver);
        loginPageImported.loginToApplication("rahul","rahul@2021" );
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.search-empty-button")));
        String actlUrl= driver.getCurrentUrl();
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(actlUrl,"https://qamoviesapp.ccbp.tech/","emptyfields not displayed");

    }
    @And("In the Home Page click on any Movie and test all the UI elements present in it")
    public void inTheHomePageClickOnAnyMovieAndTestAllTheUIElementsPresentInIt(){
        WebElement h1El = driver.findElement(By.className("home-movie-heading"));
        System.out.println(h1El.getText());
        WebElement imgEl = driver.findElement(By.cssSelector("img.poster"));
        System.out.println(imgEl.isDisplayed());
        WebElement btnEl = driver.findElement(By.xpath("//button[text()='Play']"));
        System.out.println(btnEl.isDisplayed());
    }
    @And("In the Popular Page click on any Movie and test all the UI elements present in it")
    public void inThePopularPageClickOnAnyMovieAndTestAllTheUIElementsPresentInIt(){
        WebElement pplrEl = driver.findElement(By.xpath("//a[text()='Popular']"));
        pplrEl.click();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.movie-image")));

        WebElement pEl = driver.findElement(By.xpath("//p[text()='Contact Us']"));
        System.out.println(pEl.isDisplayed());

        List<WebElement> listEl = driver.findElements(By.cssSelector("li.movie-icon-item"));
        for(WebElement item:listEl){
            System.out.println(item.isDisplayed());
        }
        System.out.println(listEl.size());
    }

    @Then("Close the Movie Details browser window")
    public void CloseTheMovieDetailsBrowserWindow(){
        driver.quit();
    }
}
