package ALTO.IRD;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class IRDResourceEntry {

	@JsonProperty("media-type")
	String media_type;

	String uri;
	String accepts;
	Map<String, Object> capabilities;
	List<String> uses;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getMedia_type() {
		return media_type;
	}

	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}

	public String getAccepts() {
		return accepts;
	}

	public void setAccepts(String accepts) {
		this.accepts = accepts;
	}

	public List<String> getUses() {
		return uses;
	}

	public void setUses(List<String> uses) {
		this.uses = uses;
	}

	public Map<String, Object> getCapabilities() {
		return capabilities;
	}

	public void setCapabilities(Map<String, Object> capabilities) {
		this.capabilities = capabilities;
	}
}
