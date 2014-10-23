package testing;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import ALTO.IRN.InfoResourceNetworkMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class TestIRN {
	public static void main(String[] args) throws IOException {
		byte[] jsondata = Files.readAllBytes(Paths.get("IRN.txt"));
		ObjectMapper om = new ObjectMapper();
		InfoResourceNetworkMap response = om.readValue(jsondata,
				InfoResourceNetworkMap.class);
		om.configure(SerializationFeature.INDENT_OUTPUT, true);
		StringWriter sw = new StringWriter();
		om.writeValue(sw, response);
		System.out.println(sw.toString());
		// System.out.println(response.getMeta().getCost_types().getClass());
	}
}
