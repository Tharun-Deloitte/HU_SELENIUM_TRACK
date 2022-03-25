package Assignment5_Test;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListenr implements ITestListener{
    public void onTestStart(ITestResult result) {
        System.out.println("Start of Test"+ result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Success of Test"+result.getName());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Failure of Test"+result.getName());
    }



}
