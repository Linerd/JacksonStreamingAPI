package ALTO.IRC;

import java.util.Map;

import ALTO.base.PIDName;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InfoResourceCostMap {
	IRCMeta meta;

	@JsonProperty("cost-map")
	Map<PIDName, Map<PIDName, Number>> costmap;

	public IRCMeta getMeta() {
		return meta;
	}

	public void setMeta(IRCMeta meta) {
		this.meta = meta;
	}

	public Map<PIDName, Map<PIDName, Number>> getCostmap() {
		return costmap;
	}

	public void setCostmap(Map<PIDName, Map<PIDName, Number>> costmap) {
		this.costmap = costmap;
	}

}
