package testing;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import ALTO.IREP.InfoResourceEndpointProperties;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class TestIREP {
	public static void main(String[] args) throws IOException {
		byte[] jsondata = Files.readAllBytes(Paths.get("IREP.txt"));
		ObjectMapper om = new ObjectMapper();
		InfoResourceEndpointProperties response = om.readValue(jsondata,
				InfoResourceEndpointProperties.class);
		om.configure(SerializationFeature.INDENT_OUTPUT, true);
		StringWriter sw = new StringWriter();
		om.writeValue(sw, response);
		System.out.println(sw.toString());
	}
}
