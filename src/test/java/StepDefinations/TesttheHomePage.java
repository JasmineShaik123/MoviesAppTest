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
import java.util.List;

public class TesttheHomePage {private WebDriver driver;
    private loginPage loginPageImported;
    @Given("I entered Home Page")
    public void iEnteredHomePage(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\LENOVO\\Downloads\\chromedriver-win32 (5)\\chromedriver-win32\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPageImported = new loginPage(driver);
        loginPageImported.loginToApplication("rahul","rahul@2021" );
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String expctdUrl ="https://qamoviesapp.ccbp.tech/";

        //btnEl.click();
        //loginPageImported.loginToApplication("rahul","rahul@2021" );
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.search-empty-button")));
        String actlUrl= driver.getCurrentUrl();
        System.out.println(actlUrl);
        Assert.assertEquals(actlUrl,expctdUrl,"emptyfields not displayed");
        driver.navigate().refresh();
    }
    @And("Test the heading texts of each section")
    public void testTheHeadingTextsOfEachSection(){
        List<WebElement> hdngEl = driver.findElements(By.tagName("h1"));
        for(WebElement item:hdngEl){
            String hdngMsg =item.getText();
            System.out.println(hdngMsg);
        }
    }
    @And("Test whether the play button is displayed or not")
    public void testWhetherThePlayButtonIsDisplayedOrNot(){
        WebElement btnEl = driver.findElement(By.xpath("//button[text()='Play']"));
        //WebElement btnEl = driver.findElement(By.cssSelector("button.home-movie-play-button"));
        System.out.println(btnEl.isDisplayed());
    }
    @And("Test whether the Movies are displayed, in the corresponding movies sections")
    public void testWhetherTheMoviesAreDisplayedInTheCorrespondingMoviesSections(){
        List<WebElement> listEl = driver.findElements(By.cssSelector("div.slick-slide"));
        for(WebElement item:listEl){

            System.out.println(item.isDisplayed());
        }
    }
    @And("Test the Contact Us Section")
    public void testTheContactUsSection(){
        WebElement cntctEl = driver.findElement(By.cssSelector("p.contact-us-paragraph"));
        System.out.println(cntctEl.isDisplayed());
    }
    @Then("Close the browser window")
    public void CloseTheBrowserWindow(){
        driver.quit();
    }

}
