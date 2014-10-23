package ALTO.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.googlecode.ipv6.IPv6Address;

public class EndpointAddress {

	final static String regexipv4 = "(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
	@JsonIgnore
	AddressType type;

	String endpointaddress;

	public EndpointAddress(String endpointaddress) {
		if (endpointaddress.matches(regexipv4)) {
			this.endpointaddress = endpointaddress;
			this.type = AddressType.ipv4;
		} else {
			endpointaddress = IPv6Address.fromString(endpointaddress)
					.toString();
			this.type = AddressType.ipv6;
		}
	}

	public String getEndpointaddress() {
		return endpointaddress;
	}

	public void setEndpointaddress(String endpointaddress) {
		if (endpointaddress.matches(regexipv4)) {
			this.endpointaddress = endpointaddress;
			this.type = AddressType.ipv4;
		} else {
			endpointaddress = IPv6Address.fromString(endpointaddress)
					.toString();
			this.type = AddressType.ipv6;
		}
	}

	public String getType() {
		return type.name();
	}

	public void setType(AddressType type) {
		this.type = type;
	}

	public static boolean validify(String address, String type) {
		EndpointAddress addr = new EndpointAddress(address);
		return addr.getType().equals(type);
	}

	@Override
	public String toString() {
		return endpointaddress;
	}

}
