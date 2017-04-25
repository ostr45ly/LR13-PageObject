import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class Selenium_Hillel {
    public static void main(String[] args) {

        JiraSite website;
        WebDriver driver;
        WebDriverWait wait;

//        @BeforeTest
//        public void before() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\oliva\\Documents\\geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);

        driver = new FirefoxDriver(capabilities);
        wait = new WebDriverWait( driver,30,500);

         website = new JiraSite(driver);

        //final WebElement paraElement = wait.withMessage("could not find the slowly loading text").util(ExpectedConditions.visibilityOfElementLocated(By.id("theText")));
        //assertEquals("Some slowly loading text.", paraElement.getText());
//      }

        //  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//          @Test(groups = {"functest", "login"})
//            public void login() {

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        website.loginPage().open();
        website.searchResultsPage().waitForSeachResults();
        website.loginPage().typeUsername("ostr45");
        website.loginPage().typePassword("ostr45");
        website.loginPage().clickOnLogin();

//           }

//        @Test(groups = {"functest", "create"})
//        public void login() {
        //   website.headerpage().clickCreate();
        //  website.newissuesPage().summaryIssues("PageObject LR13");
        //  website.newissuesPage().createIssues();
        //  website.searchResultsPage().waitForSeachResultsCreate();
//        }

//        @AfterTest
//        public void after() {
        if (driver != null)
            driver.close();
//        }



    }
}
