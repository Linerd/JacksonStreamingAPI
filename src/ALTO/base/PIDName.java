package ALTO.base;

public class PIDName {

	String pid_name;
	static final String regex = ".[^a-zA-Z0-9\\-:@_\\.].";
	static final short length = 64;

	public PIDName(String pid_name) throws Exception {
		if (pid_name.matches(regex)) {
			throw new Exception(
					"PID_Name format error, illegal character detected!");
		} else if (pid_name.length() > length) {
			throw new Exception("PID_Name format error, length exceed limit!");
		} else {
			this.pid_name = pid_name;
		}
	}

	public String getPid_name() {
		return pid_name;
	}

	public void setPid_name(String pid_name) throws Exception {
		if (pid_name.matches(regex)) {
			throw new Exception(
					"PID_Name format error, illegal character detected!");
		} else if (pid_name.length() > length) {
			throw new Exception("PID_Name format error, length exceed limit!");
		} else {
			this.pid_name = pid_name;
		}
	}

	@Override
	public String toString() {
		return pid_name;
	}
}
