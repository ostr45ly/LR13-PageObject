import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by oliva on 25.04.2017.
 */
public  class NewIssuesPage {

    By createSummary = By.id("summary");
    By createButton = By.id("subtask-create-details-submit");
    By createnewSubtask = By.id("stqc_show");

    private final WebDriver driver;

    public NewIssuesPage(WebDriver driver) {
        this.driver = driver;
    }


    public NewIssuesPage summaryIssues(String sumissues) {


        driver.findElement(createnewSubtask).click();
        driver.findElement(createSummary).click();
        driver.findElement(createSummary).clear();
        driver.findElement(createSummary).sendKeys(sumissues);
        return this;
    }

    public NewIssuesPage createIssues() {
        driver.findElement(createButton).click();
        return this;
    }

}
