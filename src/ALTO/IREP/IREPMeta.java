package ALTO.IREP;

import java.util.List;

import ALTO.base.VersionTag;

public final class IREPMeta extends ALTO.base.Meta {
	public void setDependentvtags(List<VersionTag> dependentvtags) {
		this.dependentvtags = dependentvtags;
	}

	public List<VersionTag> getDependentvtags() {
		return this.dependentvtags;
	}
}
