package ALTO.IRN;

import java.util.List;
import java.util.Map;

import ALTO.base.AddressType;
import ALTO.base.PIDName;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InfoResourceNetworkMap {
	IRNMeta meta;
	@JsonProperty("network-map")
	Map<PIDName, Map<AddressType, List<String>>> networkmap;

	public IRNMeta getMeta() {
		return meta;
	}

	public Map<PIDName, Map<AddressType, List<String>>> getNetworkmap() {
		return networkmap;
	}

	public void setMeta(IRNMeta meta) {
		this.meta = meta;
	}

	public void setNetworkmap(
			Map<PIDName, Map<AddressType, List<String>>> networkmap) {
		this.networkmap = networkmap;
	}

}
