package testing;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import ALTO.IRD.InfoResourceDirectory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class TestIRD {
	public static void main(String[] args) throws IOException {
		byte[] jsondata = Files.readAllBytes(Paths.get("IRD.txt"));
		ObjectMapper om = new ObjectMapper();
		InfoResourceDirectory response = om.readValue(jsondata,
				InfoResourceDirectory.class);
		om.configure(SerializationFeature.INDENT_OUTPUT, true);
		StringWriter sw = new StringWriter();
		om.writeValue(sw, response);
		System.out.println(sw.toString());
	}
}
