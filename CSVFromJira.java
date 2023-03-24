import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CSVFromJira {

    public static void csvFromJira() throws FileNotFoundException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.setHeadless(false);
        options.addArguments("--incognito");
//        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://jira.b2b-center.ru/secure/Dashboard.jspa");
//        Login
        WebElement webElementInputLogin = driver.findElement(By.xpath("//input[@id = 'login-form-username']"));
        webElementInputLogin.sendKeys(username());

        WebElement webElementInputPass = driver.findElement(By.xpath("//input[@id = 'login-form-password']"));
        webElementInputPass.sendKeys(password());


        WebElement webElementClickButtonEntrance = driver.findElement(By.xpath("//div[@class = 'buttons-container']/div[@class = 'buttons']/input"));
        webElementClickButtonEntrance.click();

//        Export
        WebElement webElementIssue = driver.findElement(By.xpath("//li/a[@href = '/issues/']"));
        webElementIssue.click();

        WebElement webElementIssuesNewtLink = driver.findElement(By.xpath("//li/a[@href = '/issues/?jql=' and @id = 'issues_new_search_link_lnk']"));
        webElementIssuesNewtLink.click();

        WebElement webElementFilterClick = driver.findElement(By.xpath("//a[@title = 'Баги по ddd']"));
        webElementFilterClick.click();

        WebElement webElementExportClickOpenTooltip = driver.findElement(By.xpath("//button[@class = 'aui-button aui-button-subtle header-views header-operations jira-aui-dropdown2-trigger']"));
        webElementExportClickOpenTooltip.click();

        WebElement webElementExportDownload = driver.findElement(By.xpath("//a[@id = 'currentCsvFields']"));
        webElementExportDownload.click();

        WebElement webElementClickDialogExport = driver.findElement(By.xpath("//button[@id = 'csv-export-dialog-export-button']"));
        webElementClickDialogExport.click();
    }


    public static String username() throws FileNotFoundException {
        File file = new File("Путь к своему файлу, в котором записан только логин");
        Scanner scanner = new Scanner(file);
        String username = scanner.nextLine();
        return username;
    }

    public static String password() throws FileNotFoundException {
        File file = new File("Путь к своему файлу, в котором записан только пароль");
        Scanner scanner = new Scanner(file);
        String pass = scanner.nextLine();
        return pass;
    }


}

