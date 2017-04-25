import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by oliva on 25.04.2017.
 */
public class NewIssuesPage {

    By createSummary = By.id("summary");
    By createButton = By.id("create-issue-submit");

    private final WebDriver driver;
    //private final HeaderPage headermenu;


    public NewIssuesPage(WebDriver driver) {
        this.driver = driver;
    }


    public NewIssuesPage summaryIssues(String sumissues) {
      //  HeaderPage  headermenu = new HeaderPage(drive);
      //  headermenu.clickCreate();
        driver.findElement(createSummary).clear();
        driver.findElement(createSummary).sendKeys(sumissues);
        return this;
    }

    public NewIssuesPage createIssues() {
        driver.findElement(createButton).click();
        return this;
    }

}
