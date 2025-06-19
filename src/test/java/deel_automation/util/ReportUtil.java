package deel_automation.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.relevantcodes.extentreports.LogStatus;

import deel_automation.context.WebDriverContext;
import deel_automation.report.ExtentReportManager;

public class ReportUtil {

	/**
	 * Adds the screen shot.
	 *
	 */
	public static void addScreenShot(String message) {
		String base64Image = "data:image/png;base64,"
				+ ((TakesScreenshot) WebDriverContext.getDriver()).getScreenshotAs(OutputType.BASE64);
		ExtentReportManager.getCurrentTest().log(LogStatus.INFO, message,
				ExtentReportManager.getCurrentTest().addBase64ScreenShot(base64Image));
	}

	/**
	 * Adds the screen shot.
	 *
	 */
	public static void addScreenShot(LogStatus status, String message) {
		String base64Image = "data:image/png;base64,"
				+ ((TakesScreenshot) WebDriverContext.getDriver()).getScreenshotAs(OutputType.BASE64);
		ExtentReportManager.getCurrentTest().log(status, message,
				ExtentReportManager.getCurrentTest().addBase64ScreenShot(base64Image));
	}

	public static void logMessage(String message, String details) {
		ExtentReportManager.getCurrentTest().log(LogStatus.INFO, message, details);
	}

	public static void logMessage(LogStatus status, String message, String details) {
		ExtentReportManager.getCurrentTest().log(status, message, details);
	}
	
	public static void addStepScreenshot(String stepDescription) {
        try {
            String base64Image = "data:image/png;base64,"
                    + ((TakesScreenshot) WebDriverContext.getDriver()).getScreenshotAs(OutputType.BASE64);
            
            ExtentReportManager.getCurrentTest().log(
                LogStatus.INFO, 
                "STEP: " + stepDescription,
                ExtentReportManager.getCurrentTest().addBase64ScreenShot(base64Image)
            );
        } catch (Exception e) {
            logMessage(LogStatus.WARNING, "Failed to capture step screenshot", e.getMessage());
        }
    }
}
