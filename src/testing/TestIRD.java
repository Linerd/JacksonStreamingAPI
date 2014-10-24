package testing;

import java.io.StringWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ALTO.IRD.IRDMeta;
import ALTO.IRD.IRDResourceEntry;
import ALTO.IRD.InfoResourceDirectory;
import ALTO.base.CostType;
import ALTO.base.ResourceID;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class TestIRD {
	public static void main(String[] args) throws Exception {
		// create JsonParser object
		JsonParser jsonParser = new JsonFactory().createParser(Paths.get(
				"IRD.txt").toFile());

		// loop through the tokens
		InfoResourceDirectory ird = new InfoResourceDirectory();
		IRDMeta meta = new IRDMeta();
		ird.setMeta(meta);
		Map<String, CostType> costtypes = new HashMap<String, CostType>();
		ird.getMeta().setCost_types(costtypes);
		Map<ResourceID, IRDResourceEntry> map = new HashMap<ResourceID, IRDResourceEntry>();
		ird.setResources(map);
		parseJSON(jsonParser, ird, new Object());

		// print the IRC to check
		ObjectMapper om = new ObjectMapper();
		om.configure(SerializationFeature.INDENT_OUTPUT, true);
		StringWriter sw = new StringWriter();
		om.writeValue(sw, ird);
		System.out.println(sw.toString());
	}

	private static void parseJSON(JsonParser jsonParser,
			InfoResourceDirectory ird, Object temp) throws Exception {
		while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
			String name = jsonParser.getCurrentName();
//			System.out.println("Object: " + name);
//			Thread.sleep(1000);
			if ("meta".equals(name)) {
				jsonParser.nextToken();
				parseJSON(jsonParser, ird, temp);
			} else if ("cost-types".equals(name)) {
				jsonParser.nextToken();
				parseJSON(jsonParser, ird, temp);
				// Thread.sleep(10000);
			} else if (("num-routing").equals(name) || ("num-hop").equals(name)
					|| ("ord-routing").equals(name) || ("ord-hop").equals(name)) {
				jsonParser.nextToken();
				CostType costtype = new CostType();
				while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
					String currentname = jsonParser.getCurrentName();
//					System.out.println(currentname);
					jsonParser.nextToken();
					if ("cost-mode".equals(currentname)) {
						costtype.setCost_mode(jsonParser.getText());
					} else if ("cost-metric".equals(currentname)) {
						costtype.setCostmetric(jsonParser.getText());
					} else if ("description".equals(currentname)) {
						costtype.setDescription(jsonParser.getText());
					}
				}
				ird.getMeta().getCost_types().put(name, costtype);
			} else if ("default-alto-network-map".equals(name)) {
				jsonParser.nextToken();
				ird.getMeta().setDefault_alto_network_map(jsonParser.getText());
			} else if ("resources".equals(name)) {
				jsonParser.nextToken();
				while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
					String key = jsonParser.getCurrentName();
//					System.out.println("resource: " + key);
					jsonParser.nextToken();
					IRDResourceEntry entry = new IRDResourceEntry();
					parseJSON(jsonParser, ird, entry);
					ird.getResources().put(new ResourceID(key), entry);
				}
			} else if ("capabilities".equals(name)) {
				while(jsonParser.nextToken()!=JsonToken.END_OBJECT){
				}
			} else if ("uri".equals(name)) {
				jsonParser.nextToken();
				((IRDResourceEntry) temp).setUri(jsonParser.getText());
			} else if ("media-type".equals(name)) {
				jsonParser.nextToken();
				((IRDResourceEntry) temp).setMedia_type(jsonParser.getText());
			} else if ("uses".equals(name)) {
				List<String> list = new ArrayList<String>();
				while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
					list.add(jsonParser.getText());
				}
				((IRDResourceEntry) temp).setUses(list);
			} else if ("accepts".equals(name)) {
				jsonParser.nextTextValue();
				((IRDResourceEntry) temp).setAccepts(jsonParser.getText());
			}
		}
	}
}
/*
else if ("capabilities".equals(name)) {
				jsonParser.nextToken();
				Map<String, Object> map = new HashMap<String, Object>();
				while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
					String key = jsonParser.getCurrentName();
					System.out.println("cap: " + key);
					jsonParser.nextToken();
					Object value = jsonParser....;
					System.out.println("capvalue: " + value);
					map.put(key, value);
				}
				((IRDResourceEntry) temp).setCapabilities(map);
*/



