package ALTO.IRC;

import java.util.List;

import ALTO.base.CostType;
import ALTO.base.VersionTag;

public final class IRCMeta extends ALTO.base.Meta {
	public void setDependentvtags(List<VersionTag> dependentvtags) {
		this.dependentvtags = dependentvtags;
	}

	public void setCosttype(CostType costtype) {
		this.costtype = costtype;
	}

	public List<VersionTag> getDependentvtags() {
		return super.dependentvtags;
	}

	public CostType getCosttype() {
		return super.costtype;
	}
}
