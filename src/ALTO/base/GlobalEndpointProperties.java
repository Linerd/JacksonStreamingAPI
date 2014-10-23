package ALTO.base;

public class GlobalEndpointProperties {
	String globalendpointproperties;
	static final String regex = ".[^a-zA-Z0-9\\-:_].";
	static final short length = 32;

	public GlobalEndpointProperties(String globalendpointproperties)
			throws Exception {
		if (globalendpointproperties.matches(regex)) {
			throw new Exception(
					"GlobalEndpointProperties format error, illegal character detected!");
		} else if (globalendpointproperties.length() > length) {
			throw new Exception(
					"GlobalEndpointProperties format error, length exceed limit!");
		} else {
			this.globalendpointproperties = globalendpointproperties;
		}
	}

	public String getGlobalendpointproperties() {
		return globalendpointproperties;
	}

	public void setGlobalendpointproperties(String globalendpointproperties) {
		this.globalendpointproperties = globalendpointproperties;
	}

}
