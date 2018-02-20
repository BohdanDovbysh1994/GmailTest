package utils;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener {
    private final static Logger LOGGER = Logger.getLogger(CustomListener.class);

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        LOGGER.info(String.format("Test %s init start", iTestContext.getName()));
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        LOGGER.info(String.format("Test %s finish", iTestContext.getName()));
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        LOGGER.info(String.format("I am onTestStartMethod %s start", getTestMethodName(iTestResult)));
        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(), "");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LOGGER.info(String.format("I am on TestSuccess method %s succeed", getTestMethodName(iTestResult)));
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LOGGER.info(String.format("I am in onTestFailure method %s failed" ,getTestMethodName(iTestResult)));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LOGGER.info(String.format("I am in on TestSkipped method %s skipped", getTestMethodName(iTestResult)));
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        LOGGER.info(String.format("Test failed but is in defined success ratio %s", getTestMethodName(iTestResult)));
    }
}
