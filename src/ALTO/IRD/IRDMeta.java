package ALTO.IRD;

import java.util.Map;

import ALTO.base.CostType;

public final class IRDMeta extends ALTO.base.Meta {

	public Map<String, CostType> getCost_types() {
		return super.cost_types;
	}

	public String getDefault_alto_network_map() {
		return super.default_alto_network_map;
	}

	public void setCost_types(Map<String, CostType> cost_types) {
		super.cost_types = cost_types;

	}

	public void setDefault_alto_network_map(String default_alto_network_map) {
		super.default_alto_network_map = default_alto_network_map;

	}
}
