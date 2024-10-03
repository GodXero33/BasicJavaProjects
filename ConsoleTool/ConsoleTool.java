/**
 * Hi there! It's Sathish Shan here.
 * I've created this class to help those who are just starting to learn Java, 
 * as most beginners use the command line for their work. I thought it would be 
 * nice to make a class like this to assist them, including myself. Feel free 
 * to edit the code as you wish.
 * 
 * The ConsoleTool class provides methods for managing text and background colors 
 * in the command line using ANSI escape codes (https://en.wikipedia.org/wiki/ANSI_escape_code).
 * 
 * Happy journey in Java! Thank you! 😊
 */

class ConsoleTool {
	// Create basic color arrays and name keys.
	private String[] textColorCodes = { "\u001B[30m", "\u001B[31m", "\u001B[32m", "\u001B[33m", "\u001B[34m", "\u001B[35m", "\u001B[36m", "\u001B[37m" };
	private String[] bgColorCodes = { "\u001B[40m", "\u001B[41m", "\u001B[42m", "\u001B[43m", "\u001B[44m", "\u001B[45m", "\u001B[46m", "\u001B[47m" };
	private String[] colorNames = { "black", "red", "green", "yellow", "blue", "purple", "cyan", "white" };

	/*
	 * Clears the command line.
	 */
	public void clear () {
		try {
			final String os = System.getProperty("os.name");

			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get command line color String with RGB input.
	 * @param r - Red color channel.
	 * @param g - Green color channel.
	 * @param b - Blue color channel.
	 * @param type - Wether color is background color or text color. `true` means text color.
	 * @return the String that represent command line color.
	 */
	private String getColorFromRGB (int r, int g, int b, boolean type) {
		if (r > 255 || r < 0 || g > 255 || g < 0 || b > 255 || b < 0) return "";

		return "\033[" + (type ? "3" : "4") + "8;2;" + r + ";" + g + ";" + b + "m";
	}

	/**
	 * Find the index of a color from `colorNames` array.
	 * @param color - The color that wants to find.
	 * @return the finded index of the color. If color is not in the array returns -1.
	 */
	private int findColor (String color) {
		color = color.toLowerCase();

		final int n = colorNames.length;
		int colorIndex = -1;

		for (int i = 0; i < n; i++) {
			if (colorNames[i].equals(color)) {
				colorIndex = i;
				break;
			}
		}

		return colorIndex;
	}

	/**
	 * Return text color when basic color name is given.
	 * @param color - The color name.
	 * @return the String that represent command line text color.
	 */
	public String getTextColor (String color) {
		int colorIndex = this.findColor(color);

		if (colorIndex != -1) return textColorCodes[colorIndex];

		return "";
	}

	/**
	 * Return text color when red, green and blue color channels are given.
	 * @param r - Red color channel where 0 <= r <= 255
	 * @param g - Green color channel where 0 <= r <= 255
	 * @param b - Blue color channel where 0 <= r <= 255
	 * @return the String that represent command line text color.
	 */
	public String getTextColor (int r, int g, int b) {
		return this.getColorFromRGB(r, g, b, true);
	}

	/**
	 * Change text color of the command line when basic color name is given.
	 * @param color - The color name.
	 */
	public void textColor (String color) {
		int colorIndex = this.findColor(color);

		if (colorIndex != -1) System.out.print(textColorCodes[colorIndex]);
	}

	/**
	 * Change text color when red, green and blue color channels are given.
	 * @param r - Red color channel where 0 <= r <= 255
	 * @param g - Green color channel where 0 <= r <= 255
	 * @param b - Blue color channel where 0 <= r <= 255
	 */
	public void textColor (int r, int g, int b) {
		System.out.print(this.getColorFromRGB(r, g, b, true));
	}

	/**
	 * Return background color when basic color name is given.
	 * @param color - The color name.
	 * @return the String that represent command line background color.
	 */
	public String getBgColor (String color) {
		int colorIndex = this.findColor(color);

		if (colorIndex != -1) return bgColorCodes[colorIndex];

		return "";
	}

	/**
	 * Return background color when red, green and blue color channels are given.
	 * @param r - Red color channel where 0 <= r <= 255
	 * @param g - Green color channel where 0 <= r <= 255
	 * @param b - Blue color channel where 0 <= r <= 255
	 * @return the String that represent command line background color.
	 */
	public String getBgColor (int r, int g, int b) {
		return this.getColorFromRGB(r, g, b, false);
	}

	/**
	 * Change background color of the command line when basic color name is given.
	 * @param color - The color name.
	 */
	public void bgColor (String color) {
		int colorIndex = this.findColor(color);

		if (colorIndex != -1) System.out.print(bgColorCodes[colorIndex]);
	}

	/**
	 * Change background color when red, green and blue color channels are given.
	 * @param r - Red color channel where 0 <= r <= 255
	 * @param g - Green color channel where 0 <= r <= 255
	 * @param b - Blue color channel where 0 <= r <= 255
	 */
	public void bgColor (int r, int g, int b) {
		System.out.print(this.getColorFromRGB(r, g, b, false));
	}

	/**
	 * @return the color reset String value of command line.
	 */
	public String getReset () {
		return "\u001B[0m\u001B[49m";
	}

	/**
	 * Reset previously added color in command line.
	 */
	public void reset () {
		System.out.print("\u001B[0m\u001B[49m");
	}

	/**
	 * @return the text bolding String value of command line.
	 */
	public String getBold () {
		return "\u001B[1m";
	}

	/**
	 * Sets the text to bold.
	 */
	public void setBold () {
		System.out.print("\u001B[1m");
	}

	/**
	 * @return the text italicking String value of command line.
	 */
	public String getItalic () {
		return "\u001B[3m";
	}

	/**
	 * Sets the text to italic.
	 */
	public void setItalic () {
		System.out.print("\u001B[3m");
	}

	/**
	 * @return the text underlining String value of command line.
	 */
	public String getUnderline () {
		return "\u001B[4m";
	}

	/**
	 * Sets the text to underline.
	 */
	public void setUnderline () {
		System.out.print("\u001B[4m");
	}

	/**
	 * @return the text blinking String value of command line.
	 */
	public String getBlink () {
		return "\u001B[5m";
	}

	/**
	 * Sets the text to blink.
	 */
	public void setBlink () {
		System.out.print("\u001B[5m");
	}

	/**
	 * Lists all available text and background colors.
	 */
	public void listColors () {
		System.out.println("Available Text Colors:");

		for (String color : colorNames) {
			System.out.println(color);
		}

		System.out.println("Available Background Colors:");

		for (String color : colorNames) {
			System.out.println(color);
		}
	}
}
