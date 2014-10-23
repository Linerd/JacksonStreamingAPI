package ALTO.base;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VersionTag {

	@JsonProperty("resource-id")
	private String resourceid;

	final static short length = 64;
	static final String regex = ".[^a-zA-Z0-9\\-:@_\\.].";
	private String tag;

	public String getResourceid() {
		return resourceid;
	}

	public void setResourceid(String resourceid) throws Exception {
		if (resourceid.matches(regex)) {
			throw new Exception(
					"ResourceID format error, illegal character detected!");
		} else if (resourceid.length() > length) {
			throw new Exception("ResourceID format error, length exceed limit!");
		} else {
			this.resourceid = resourceid;
		}
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) throws Exception {
		if (tag.length() > length)
			throw new Exception("Tag format error, length exceed limit!");
		else {
			this.tag = tag;
		}
	}
}
