import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.WebDriverException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class Selenium_Hillel {
    public static void main(String[] args) throws InterruptedException {

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


//          @Test(groups = {"functest", "login"})
//            public void login() {

          website.loginPage().open("http://soft.it-hillel.com.ua:8080/login.jsp");
          driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
          website.searchResultsPage().waitForSeachResults();
          website.loginPage().typeUsername("ostr45");
          website.loginPage().typePassword("ostr45");
          website.loginPage().clickOnLogin();

//           }

//        @Test(groups = {"functest", "create"})
//        public void login() {
        //  website.headerpage().clickCreate();
      //  website.loginPage().open("http://soft.it-hillel.com.ua:8080/browse/QAAUT-60");

        website.headerpage().findSearch();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        website.headerpage().searchTask("QAAUT-60");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         website.newissuesPage().summaryIssues("Ostrovskaya PageObject LR13");
        website.newissuesPage().createIssues();

//        }

//        @AfterTest
//        public void after() {
        if (driver != null)
            driver.close();
//        }



    }


}
