import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class CSVFromJiraTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.setHeadless(false);
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://jira.b2b-center.ru/secure/Dashboard.jspa");
//        Login
        WebElement webElementInputLogin = driver.findElement(By.xpath("//input[@id = 'login-form-username']"));
        webElementInputLogin.sendKeys("r.volovik");

        WebElement webElementInputPass = driver.findElement(By.xpath("//input[@id = 'login-form-password']"));
        webElementInputPass.sendKeys("......."); // настроить позже шифрование пароля!!!


        WebElement webElementClickButtonEntrance = driver.findElement(By.xpath("//div[@class = 'buttons-container']/div[@class = 'buttons']/input"));
        webElementClickButtonEntrance.click();

//        Export
        WebElement webElementIssue = driver.findElement(By.xpath("//li/a[@href = '/issues/']"));
        webElementIssue.click();

        WebElement webElementIssuesCurrentLink = driver.findElement(By.xpath("//li/a[@href = '/issues/' and @id = 'jira.top.navigation.bar:issues_drop_current_lnk']"));
        webElementIssuesCurrentLink.click();

        WebElement webElementFilterClick = driver.findElement(By.xpath("//a[@title = 'Баги по ddd']"));
        webElementFilterClick.click();

        WebElement webElementExportClickOpenTooltip = driver.findElement(By.xpath("//button[@class = 'aui-button aui-button-subtle header-views header-operations jira-aui-dropdown2-trigger']"));
        webElementExportClickOpenTooltip.click();

        WebElement webElementExportDownload = driver.findElement(By.xpath("//a[@id = 'currentCsvFields']"));
        webElementExportDownload.click();

        WebElement webElementClickDialogExport = driver.findElement(By.xpath("//button[@id = 'csv-export-dialog-export-button']"));
        webElementClickDialogExport.click();

    }
}
