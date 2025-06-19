package deel_automation.factory;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;

import deel_automation.context.WebDriverContext;
import deel_automation.pages.BasePage;

/**
 * A factory for creating Pageinstances objects.
 */
public class PageinstancesFactory {

	/**
	 * Gets the single instance of PageinstancesFactory.

	 */
	public static <T extends BasePage > T getInstance(Class<T> type) {
		try {
			return type.getConstructor(WebDriver.class).newInstance(WebDriverContext.getDriver());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}
}
