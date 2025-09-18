package framework;

import java.io.File;

public class FrameworkConstants {

	private static final String ROOT_PATH = System.getProperty("user.dir");

	private static final int IMPLICIT_WAIT = 10;

	private static final int EXPLICIT_WAIT = 20;

	private static final String RESULTS_FOLDER_PATH = ROOT_PATH + File.separator + "results" + File.separator;

	private static final String CONFIG_FILE_PATH = ROOT_PATH + File.separator + "results" + File.separator;

	/**
	 * The method to return the root path of the project folder
	 * 
	 * @return the root folder path string
	 */
	public static String getRootPath() {
		return ROOT_PATH;
	}

	/**
	 * The method to return the implicit wait value
	 * 
	 * @return the implicit wait value
	 */
	public static int getImplicitWait() {
		return IMPLICIT_WAIT;
	}

	/**
	 * The method to return the explicit wait value
	 * 
	 * @return the explicit wait value
	 */
	public static int getExplicitWait() {
		return EXPLICIT_WAIT;
	}

	/**
	 * The method to return the results folder path
	 * 
	 * @return the results folder path string
	 */
	public static String getResultsFolderPath() {
		return RESULTS_FOLDER_PATH;
	}

	/**
	 * The method to return the config file path
	 * 
	 * @return the config file path string
	 */
	public static String getConfigFilePath() {
		return CONFIG_FILE_PATH;
	}
}
