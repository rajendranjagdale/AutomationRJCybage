package testdata;

import java.util.Arrays;
import java.util.List;

/**
 * The class to provide the test data for test execution
 */

public class Data {

	/**
	 * The method to get the list of link names on Home page
	 * @return the list of link names
	 */
	public static List<String> getHomePageLinks() {
		String linkNames = "A/B Testing;Add/Remove Elements;Basic Auth;Broken Images;Challenging DOM;Checkboxes;Context Menu;Digest Authentication;Disappearing Elements;Drag and Drop;Dropdown;Dynamic Content;Dynamic Controls;Dynamic Loading;Entry Ad;Exit Intent;File Download;File Upload;Floating Menu;Forgot Password;Form Authentication;Frames;Geolocation;Horizontal Slider;Hovers;Infinite Scroll;Inputs;JQuery UI Menus;JavaScript Alerts;JavaScript onload event error;Key Presses;Large & Deep DOM;Multiple Windows;Nested Frames;Notification Messages;Redirect Link;Secure File Download;Shadow DOM;Shifting Content;Slow Resources;Sortable Data Tables;Status Codes;Typos;WYSIWYG Editor;Elemental Selenium";
		List<String> homePageLinks = Arrays.asList(linkNames.split(";"));
		return homePageLinks;
	}
}
