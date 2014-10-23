package ALTO.base;

public class ResourceID {
	String resourceID;
	static final String regex = ".[^a-zA-Z0-9\\-:@_\\.].";
	static final short length = 64;

	public ResourceID(String resourceID) throws Exception {
		if (resourceID.matches(regex)) {
			throw new Exception(
					"ResourceID format error, illegal character detected!");
		} else if (resourceID.length() > length) {
			throw new Exception("ResourceID format error, length exceed limit!");
		} else {
			this.resourceID = resourceID;
		}
	}

	@Override
	public String toString() {
		return resourceID;
	}

	public void setResourceID(String resourceID) throws Exception {
		if (resourceID.matches(regex)) {
			throw new Exception(
					"ResourceID format error, illegal character detected!");
		} else if (resourceID.length() > length) {
			throw new Exception("ResourceID format error, length exceed limit!");
		} else {
			this.resourceID = resourceID;
		}
	}

	public String getResourceID() {
		return resourceID;
	}
}
