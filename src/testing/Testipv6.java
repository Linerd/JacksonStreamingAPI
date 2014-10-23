package testing;

import com.googlecode.ipv6.*;

public class Testipv6 {
	public static void main(String[] args) {
		IPv6Address ipv6address = IPv6Address
				.fromString("0000:0000:0000:1:0000:0000:0000:1");
		System.out.println(ipv6address.toString());
	}
}
