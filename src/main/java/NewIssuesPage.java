import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Created by oliva on 25.04.2017.
 */
public  class NewIssuesPage {

    By createSummary = By.id("summary");
    By createButton = By.id("create-issue-submit");
    By createButtonMore = By.id("create-subtask");
    By buttonMore = By.id("opsbar-operations_more");
    By createnewSubtask = By.id("stqc_show");
    By subtaskLocator = By.linkText("Ostrovskaya PageObject LR14");
    By deleteButtonMore = By.id("delete-issue");
    By deleteButton = By.id("delete-issue-submit");

    private final WebDriver driver;

    public NewIssuesPage(WebDriver driver) {
        this.driver = driver;
    }


    public NewIssuesPage summaryIssues(String sumissues) throws InterruptedException {

        // create +
//        driver.findElement(createnewSubtask).click();
//        driver.findElement(createSummary).click();
//        driver.findElement(createSummary).sendKeys(sumissues);
//        driver.findElement(createButton).click();

        // create More(menu)
        driver.findElement(buttonMore).click();
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(createButtonMore).click();
        driver.findElement(createSummary).click();
        driver.findElement(createSummary).sendKeys(sumissues);
        driver.findElement(createButton).click();
        return this;
    }

    public NewIssuesPage moveSubtask() throws InterruptedException {

         Thread.sleep(3000);
         WebElement element = driver.findElement(subtaskLocator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        element.click();
        return this;
    }

    public NewIssuesPage clickMoreButton() {

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-250)", "");
        WebElement element= driver.findElement(buttonMore);
        element.click();
        return this;
    }

    public NewIssuesPage deleteSubtask() throws InterruptedException {
        driver.findElement(buttonMore).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(deleteButtonMore).click();
        driver.findElement(deleteButton).click();
        return this;
    }

}
