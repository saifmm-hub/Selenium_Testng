package deel_automation.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import deel_automation.context.Constants;


public class TestProperties {

	/** The Constant props. */
	private static final Properties props = new Properties();

	/**
	 * Load all propertie.
	 */
	public static void loadAllPropertie() {
		try {
			FileInputStream Locator;
			Locator = new FileInputStream(Constants.PROPERTY_FILE_PATH);
			props.load(Locator);
		} catch (IOException e) {
			LoggerUtil.getLogger().fatal("Could not load properties : " + e.getMessage());
		}
	}

	/**
	 * Gets the property.

	 */
	public static String getProperty(String key) {
		return props.getProperty(key);
	}

	/**
	 * Put property.

	 */
	public static void putProperty(String key, String value) {
		props.put(key, value);
	}
}
