package testing;

public class TestEnum {
	private enum test {
		ipv4, ipv6;
	}

	public static void main(String[] args) {
		System.out.println(test.valueOf("ipv5").ordinal());
	}
}
