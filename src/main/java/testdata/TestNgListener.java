package testdata;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNgListener implements ITestListener {
    private final Logger LOGGER = Logger.getLogger(TestNgListener.class);
    @Override
    public void onTestStart(ITestResult iTestResult) {
        LOGGER.info(String.format("Test %s start", iTestResult.getName()));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LOGGER.info(String.format("Test %s success", iTestResult.getName()));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LOGGER.info(String.format("Test %s failure", iTestResult.getName()));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LOGGER.info(String.format("Test %s skipped", iTestResult.getName()));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        LOGGER.info(String.format("Test %s gailed but with success percentage", iTestResult.getName()));
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        LOGGER.info(String.format("Test %s init start", iTestContext.getName()));
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        LOGGER.info(String.format("Test %s finish", iTestContext.getName()));
    }
}
