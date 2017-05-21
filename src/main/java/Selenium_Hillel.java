import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.WebDriverException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class Selenium_Hillel {
    public static void main(String[] args) throws InterruptedException {

        JiraSite website;
        WebDriver driver;
        WebDriverWait wait;

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\oliva\\Documents\\geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);

        driver = new FirefoxDriver(capabilities);
        wait = new WebDriverWait( driver,30,500);
         website = new JiraSite(driver);

         //  LOGIN
          website.loginPage().open("http://soft.it-hillel.com.ua:8080/login.jsp");
          driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
          website.searchResultsPage().waitForSeachResults();
          website.loginPage().typeUsername("ostr45");
          website.loginPage().typePassword("ostr45");
          website.loginPage().clickOnLogin();
          driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

         // create SUB-TASK
          website.headerpage().searchTask("QAAUT-309");
          driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
          website.newissuesPage().summaryIssues("Ostrovskaya PageObject LR14");

          // delete SUB-TASK
          website.newissuesPage().moveSubtask();
          driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
          website.newissuesPage().clickMoreButton();
          website.newissuesPage().deleteSubtask();


        //  driver.get("http://soft.it-hillel.com.ua:8080/secure/RapidBoard.jspa?projectKey=QAAUT&rapidView=13");
        //  website.dragAndDrop().DragBox();

        //}

        //  @Test
        // public void testDragDrop() {

        //  driver.get(" http://soft.it-hillel.com.ua:8080/secure/RapidBoard.jspa?projectKey=QAAUT&rapidView=13");
        // WebElement source = driver.findElement(By.xpath("//*[@id='ghx-pool']/div[5]/ul/li[3]/div/div/div[3]/div[1]/div/div[2]/span"));
        //  WebElement target = driver.findElement(By.xpath("//*[@id='ghx-pool']/div[5]/ul/li[2]/div/div/div[3]/div[1]/div/div[2]/span"));
        //  Actions builder = new Actions(driver);
        //     builder.dragAndDrop(source, target).perform();
//        try
//        {
//            assertEquals("Dropped!", target.getText());
//        } catch (Error e) {
        //          verificationErrors.append(e.toString());
//        }
        //   }

        if (driver != null)
            driver.close();

    }


}
