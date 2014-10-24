package testing;

import java.io.StringWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ALTO.IRC.IRCMeta;
import ALTO.IRC.InfoResourceCostMap;
import ALTO.base.CostType;
import ALTO.base.PIDName;
import ALTO.base.VersionTag;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class TestIRC {
	public static void main(String[] args) throws Exception {
		// create JsonParser object
		JsonParser jsonParser = new JsonFactory().createParser(Paths.get(
				"IRC.txt").toFile());

		// loop through the tokens
		InfoResourceCostMap irc = new InfoResourceCostMap();
		IRCMeta meta = new IRCMeta();
		irc.setMeta(meta);
		List<VersionTag> vtags = new ArrayList<VersionTag>();
		irc.getMeta().setDependentvtags(vtags);
		CostType costtype = new CostType();
		irc.getMeta().setCosttype(costtype);
		Map<PIDName, Map<PIDName, Number>> map = new HashMap<PIDName, Map<PIDName, Number>>();
		irc.setCostmap(map);
		parseJSON(jsonParser, irc, vtags, new Object());

		// print the IRC to check
		ObjectMapper om = new ObjectMapper();
		om.configure(SerializationFeature.INDENT_OUTPUT, true);
		StringWriter sw = new StringWriter();
		om.writeValue(sw, irc);
		System.out.println(sw.toString());
	}

	private static void parseJSON(JsonParser jsonParser,
			InfoResourceCostMap irc, List<VersionTag> vtags, Object temp)
			throws Exception {
		while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
			String name = jsonParser.getCurrentName();
			if ("meta".equals(name)) {
				jsonParser.nextToken();
				parseJSON(jsonParser, irc, vtags, temp);
			} else if ("dependent-vtags".equals(name)) {
				jsonParser.nextToken();
				while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
					VersionTag tag = new VersionTag();
					parseJSON(jsonParser, irc, vtags, tag);
					vtags.add(tag);
				}
			} else if ("resource-id".equals(name)) {
				jsonParser.nextToken();
				((VersionTag) temp).setResourceid(jsonParser.getText());
			} else if ("tag".equals(name)) {
				jsonParser.nextToken();
				((VersionTag) temp).setTag(jsonParser.getText());
			} else if ("cost-type".equals(name)) {
				jsonParser.nextToken();
				// nested object, recursive call
				parseJSON(jsonParser, irc, vtags, temp);
			} else if ("cost-mode".equals(name)) {
				jsonParser.nextToken();
				irc.getMeta().getCosttype().setCost_mode(jsonParser.getText());
			} else if ("cost-metric".equals(name)) {
				jsonParser.nextToken();
				irc.getMeta().getCosttype().setCostmetric(jsonParser.getText());
			} else if ("cost-map".equals(name)) {
				jsonParser.nextToken();
				while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
					Map<PIDName, Number> map = new HashMap<PIDName, Number>();
					String currentname = jsonParser.getCurrentName();
					jsonParser.nextToken();
					while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
						PIDName pid = new PIDName(jsonParser.getCurrentName());
						jsonParser.nextToken();
						int value = jsonParser.getIntValue();
						map.put(pid, value);
					}
					irc.getCostmap().put(new PIDName(currentname), map);
				}
			}
		}
	}
}
