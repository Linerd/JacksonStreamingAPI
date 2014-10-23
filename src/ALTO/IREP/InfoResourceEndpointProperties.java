package ALTO.IREP;

import java.util.Map;

import ALTO.base.TypedEndpointAddress;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InfoResourceEndpointProperties {
	IREPMeta meta;
	@JsonProperty("endpoint-properties")
	Map<TypedEndpointAddress, Map<String, String>> endpointproperties;

	public IREPMeta getMeta() {
		return meta;
	}

	public void setMeta(IREPMeta meta) {
		this.meta = meta;
	}

	public Map<TypedEndpointAddress, Map<String, String>> getEndpointproperties() {
		return endpointproperties;
	}

	public void setEndpointproperties(
			Map<TypedEndpointAddress, Map<String, String>> endpointproperties) {
		this.endpointproperties = endpointproperties;
	}

}
