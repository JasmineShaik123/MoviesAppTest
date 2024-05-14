import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import pages.loginPage;

public class HomePageTest {
    public WebDriver driver;
    loginPage loginPageImported;
    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\chromedriver-win32 (5)\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPageImported = new loginPage(driver);

        /*WebElement userEl = driver.findElement(By.id("usernameInput"));
        WebElement psswrdEl = driver.findElement(By.id("passwordInput"));
        WebElement btnEl = driver.findElement(By.className("login-button"));

        userEl.sendKeys("rahul");
        psswrdEl.sendKeys("rahul@2021");
        btnEl.click();
        */
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test(priority=1)
    public void HomePageTest(){

        loginPageImported.loginToApplication("rahul","rahul@2021" );
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.search-empty-button")));
        String actlUrl= driver.getCurrentUrl();
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(actlUrl,"https://qamoviesapp.ccbp.tech/","emptyfields not displayed");

        List<WebElement> hdngEl = driver.findElements(By.tagName("h1"));
        for(WebElement item:hdngEl){
            String hdngMsg =item.getText();
            System.out.println(hdngMsg);
        }

        WebElement btnEl = driver.findElement(By.xpath("//button[text()='Play']"));
        //WebElement btnEl = driver.findElement(By.cssSelector("button.home-movie-play-button"));
        System.out.println(btnEl.isDisplayed());

        List<WebElement> listEl = driver.findElements(By.cssSelector("div.slick-slide"));
        for(WebElement item:listEl){

            System.out.println(item.isDisplayed());
        }

        WebElement cntctEl = driver.findElement(By.cssSelector("p.contact-us-paragraph"));
        System.out.println(cntctEl.isDisplayed());
    }
}
