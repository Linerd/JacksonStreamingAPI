package ALTO.base;

public class TypedEndpointAddress {
	String typedendpointaddress;

	public TypedEndpointAddress(String typedendpointaddress) throws Exception {
		String[] args = typedendpointaddress.split(":");
		if (args.length > 2) {
			throw new Exception("TypedEndpointAddress error, illegal format!");
		}
		if (EndpointAddress.validify(args[1], args[0])) {
			this.typedendpointaddress = args[0] + ":" + args[1];
		} else {
			throw new Exception("TypedEndpointAddress error, illegal format!");
		}
	}

	public String getTypedendpointaddress() {
		return typedendpointaddress;
	}

	public void setTypedendpointaddress(String typedendpointaddress)
			throws Exception {
		String[] args = typedendpointaddress.split(":");
		if (args.length > 2) {
			throw new Exception("TypedEndpointAddress error, illegal format!");
		}
		if (EndpointAddress.validify(args[1], args[0])) {
			this.typedendpointaddress = args[0] + ":" + args[1];
		} else {
			throw new Exception("TypedEndpointAddress error, illegal format!");
		}
	}

	@Override
	public String toString() {
		return typedendpointaddress;
	}
}
