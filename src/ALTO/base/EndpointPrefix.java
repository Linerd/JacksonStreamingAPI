package ALTO.base;

public class EndpointPrefix {

	String endpointprefix;

	public EndpointPrefix(String endpointprefix) throws Exception {
		String[] args = endpointprefix.split("/");
		if (args.length > 2) {
			throw new Exception("EndpointPrefix error, illegal format!");
		} else {
			EndpointAddress addr = new EndpointAddress(args[0]);
			int num = Integer.parseInt(args[1]);
			if (addr.getType() == "ipv4" && (num >= 0 && num < 32)) {
				this.endpointprefix = endpointprefix;
			} else if (addr.getType() == "ipv6" && (num >= 0 && num < 128)) {
				this.endpointprefix = endpointprefix;
			}
		}
	}

	public String getEndpointprefix() {
		return endpointprefix;
	}

	public void setEndpointprefix(String endpointprefix) throws Exception {
		String[] args = endpointprefix.split("/");
		if (args.length > 2) {
			throw new Exception("EndpointPrefix error, illegal format!");
		} else {
			EndpointAddress addr = new EndpointAddress(args[0]);
			int num = Integer.parseInt(args[1]);
			if (addr.getType() == "ipv4" && (num > 0 && num < 24)) {
				this.endpointprefix = endpointprefix;
			} else if (addr.getType() == "ipv6" && (num > 0 && num < 32)) {
				this.endpointprefix = endpointprefix;
			}
		}
	}

	@Override
	public String toString() {
		return endpointprefix;
	}

}
