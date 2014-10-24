package ALTO.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class CostType {
	private enum CostModeValue {
		numerical, ordinal;
	}

	@JsonProperty("cost-mode")
	CostModeValue cost_mode;

	static final String regex = ".[^a-zA-Z0-9\\-:_\\.].";
	static final short length = 32;
	@JsonProperty("cost-metric")
	String cost_metric;

	String description;

	public String getCost_metric() {
		return cost_metric;
	}

	public void setCostmetric(String costmetric) throws Exception {
		if (costmetric.matches(regex)) {
			throw new Exception(
					"CostMetric format error, illegal character detected!");
		} else if (costmetric.length() > length) {
			throw new Exception("CostMetric format error, length exceed limit!");
		} else {
			this.cost_metric = costmetric;
		}
	}

	public String getCost_mode() {
		return cost_mode.name();
	}

	public void setCost_mode(String cost_mode) {
		CostModeValue value = CostModeValue.valueOf(CostModeValue.class,
				cost_mode);
		this.cost_mode = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
