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
import pages.loginPage;
import java.time.Duration;
import java.util.List;

public class HeaderSectionTest {
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
    public void testTheHeaderSectionUI(){

        loginPageImported.loginToApplication("rahul","rahul@2021" );
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.search-empty-button")));
        String actlUrl= driver.getCurrentUrl();
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(actlUrl,"https://qamoviesapp.ccbp.tech/","emptyfields not displayed");



        WebElement btnEl = driver.findElement(By.cssSelector("img.website-logo"));
        //WebElement btnEl = driver.findElement(By.cssSelector("button.home-movie-play-button"));
        System.out.println(btnEl.isDisplayed());

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
    @Test(priority = 2)
    public void testTheHeaderSectionFunctionalities(){
        loginPageImported.loginToApplication("rahul","rahul@2021" );
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.search-empty-button")));
        //String actlUrl= driver.getCurrentUrl();
        //System.out.println(driver.getCurrentUrl());
        //Assert.assertEquals(actlUrl,"https://qamoviesapp.ccbp.tech/","emptyfields not displayed");*/

        WebElement homeEl = driver.findElement(By.xpath("//a[text()='Home']"));
        homeEl.click();

        WebElement pplrEl = driver.findElement(By.xpath("//a[text()='Popular']"));
        pplrEl.click();

        WebElement btnEl2 = driver.findElement(By.cssSelector("button.avatar-button"));
        btnEl2.click();

       /* WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.movie-icon-item")));
        driver.navigate().back();
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.movie-icon-item")));



        //WebElement btnEl = driver.findElement(By.cssSelector("button.home-movie-play-button"));
        //System.out.println(btnEl2.isDisplayed());
        btnEl2.click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.logout-button")));*/
    }
}
