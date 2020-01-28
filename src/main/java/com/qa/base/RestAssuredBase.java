package com.qa.base;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredBase extends PreAndTest {

	public static String currentDir = System.getProperty("user.dir");
	private Properties prop = null;

	public static RequestSpecification req;

	public RequestSpecification requestSpecification() throws IOException {
		if (req == null) {
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
			req = new RequestSpecBuilder().setBaseUri(getPropValue("baseUrl"))
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();
			return req;
		}
		return req;
	}

	public String getPropValue(String key) throws IOException {
		InputStream is = null;
		try {
			this.prop = new Properties();
			is = RestAssuredBase.class.getClassLoader().getResourceAsStream("config.properties");
			prop.load(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}

	public void writeFile(String resourceAPI, String Req, Response Res, String fileName) {
		String PATH = currentDir + File.separator + "reports\\";
		String directoryName = PATH.concat(resourceAPI);
		String resp = Res.asString();
		File directory = new File(directoryName);
		if (!directory.exists()) {
			directory.mkdir();
		}
		if (Req != null && !Req.isEmpty()) {
			File reqfile = new File(directoryName + "/" + fileName + "_Req.json");
			write2File(reqfile, Req);
		}

		if (resp != null && !resp.isEmpty()) {
			File resfile = new File(directoryName + "/" + fileName + "_Res.json");
			write2File(resfile, resp);
		}
	}

	public void write2File(File file, String value) {
		try {
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(value);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}


}