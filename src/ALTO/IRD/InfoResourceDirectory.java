package ALTO.IRD;

import java.util.LinkedHashMap;
import java.util.Map;

import ALTO.base.ResourceID;

public class InfoResourceDirectory {

	IRDMeta meta;
	Map<ResourceID, IRDResourceEntry> resources = new LinkedHashMap<ResourceID, IRDResourceEntry>();

	public IRDMeta getMeta() {
		return meta;
	}

	public void setMeta(IRDMeta meta) {
		this.meta = meta;
	}

	public Map<ResourceID, IRDResourceEntry> getResources() {
		return resources;
	}

	public void setResources(Map<ResourceID, IRDResourceEntry> resources) {
		this.resources = resources;
	}
}
