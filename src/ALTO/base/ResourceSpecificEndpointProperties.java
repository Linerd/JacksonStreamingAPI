package ALTO.base;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ResourceSpecificEndpointProperties {
	@JsonIgnore
	ResourceID resourceid;
	@JsonIgnore
	GlobalEndpointProperties globalendpointproperties;

	String resourcespecificendpointproperties;

	public String getResourcespecificendpointproperties() {
		return resourcespecificendpointproperties;
	}

	public void setResourcespecificendpointproperties(
			String resourcespecificendpointproperties) throws Exception {
		String[] property = resourcespecificendpointproperties.split(".");
		if (property.length > 2) {
			throw new Exception(
					"ResourceSpecificEndpointProperties error, format error!");
		}
		resourceid = new ResourceID(property[0]);
		globalendpointproperties = new GlobalEndpointProperties(property[1]);
		this.resourcespecificendpointproperties = resourcespecificendpointproperties;
	}
}
