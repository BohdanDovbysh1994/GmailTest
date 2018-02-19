package utils;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            //Set HTML reporting file location
            extent = new ExtentReports("src\\test\\ExtentReportResults.html", true);
        }
        return extent;
    }
}
