package Assignment5_Test;

import Assignment5.login;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Base {
    public WebDriver initialize(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public void login_initialize(WebDriver driver){
        login l=new login(driver);
        l.get_details();
        l.username();
        l.setPassword();
        l.click();
    }
    ExtentReports extent;
    public ExtentReports ReportGenerator()
    {
        String path=System.getProperty("user.dir")+"\\Reports\\Report.html";
        ExtentSparkReporter reporter=new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Details");
        reporter.config().setDocumentTitle("Test Results");

        extent=new ExtentReports();
        extent.attachReporter(reporter);
        return extent;
    }
}
