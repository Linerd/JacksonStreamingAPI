package ALTO.base;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import ALTO.base.CostType;
import ALTO.base.VersionTag;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public abstract class Meta {
	@JsonProperty("cost-types")
	protected Map<String, CostType> cost_types;

	@JsonProperty("default-alto-network-map")
	protected String default_alto_network_map;

	protected VersionTag vtag;

	@JsonProperty("dependent-vtags")
	protected List<VersionTag> dependentvtags;

	@JsonProperty("cost-type")
	protected CostType costtype;
}
