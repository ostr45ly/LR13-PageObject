import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by oliva on 14.05.2017.
 */
public class DragAndDrop {

    private final WebDriver driver;

    public DragAndDrop(WebDriver driver) {
        this.driver = driver;
    }

    public DragAndDrop DragBox (){
        driver.get("http://soft.it-hillel.com.ua:8080/secure/RapidBoard.jspa?projectKey=QAAUT&rapidView=13");
        WebElement source = driver.findElement(By.xpath("//*[@id=\"ghx-pool\"]/div[5]/ul/li[3]/div/div/div[4]/div[1]/div/div[2]/span"));
        String code = "var fireOnThis = arguments[0];"
                + "var evObj = document.createEvent('MouseEvents');"
                + "evObj.initEvent( 'mouseover', true, true );"
                + "fireOnThis.dispatchEvent(evObj);";
        ((JavascriptExecutor)driver).executeScript(code, source);
        Actions actions = new Actions(driver);
        actions.moveToElement(source);
        actions.perform();
        Actions builder = new Actions(driver);
        builder.dragAndDropBy(source, 100, 0).perform();
        return this;
    }

}
