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

public class TestTheSearchFunctionality {private WebDriver driver;
private loginPage loginPageImported;
    @Given("I am on Search Functionality Page")
    public void iAmOnSearchFunctionalityPage(){
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
    @And("Test the Search functionality by searching with some movie names and the count of movies displayed")
    public void testTheSearchFunctionalityBySearchingWithSomeMovieNamesAndTheCountOfMoviesDisplayed(){
        WebElement pplrEl = driver.findElement(By.xpath("//a[text()='Popular']"));
        pplrEl.click();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.movie-image")));
        WebElement srchBtn=driver.findElement(By.cssSelector("button.search-empty-button"));
        srchBtn.click();
        WebElement inptSrch = driver.findElement(By.cssSelector("input#search"));
        inptSrch.sendKeys("Venom");
        //WebElement item = listEl.get(i);
        WebElement srchBtn2 = driver.findElement(By.cssSelector("button.search-button"));
        srchBtn2.click();
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.movie-image")));
        //int count=0;
        List<WebElement> listEl = driver.findElements(By.cssSelector("li.movie-icon-item"));
        System.out.println(listEl.size());



        inptSrch.clear();
        inptSrch.sendKeys("luca");
        srchBtn2.click();

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.movie-image")));
        List<WebElement> listE2 = driver.findElements(By.cssSelector("li.movie-icon-item"));
        System.out.println(listE2.size());

        inptSrch.clear();
        inptSrch.sendKeys("avatar");
        srchBtn2.click();

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.movie-image")));
        List<WebElement> listE3 = driver.findElements(By.cssSelector("li.movie-icon-item"));
        System.out.println(listE3.size());
    }

    @Then("Close the Search Functionality browser window")
    public void closeTheSearchFunctionalityBrowserWindow(){
        driver.quit();
    }
}
