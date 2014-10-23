package testing;

public class TestRegex {
	static String regex = ".[^a-zA-Z0-9\\-:@_\\.].";

	public static void main(String[] args) {
		String testString = "a  ";
		if (testString.matches(regex)) {
			System.out.println(true);

		} else {
			System.out.println(false);
		}
	}
}
