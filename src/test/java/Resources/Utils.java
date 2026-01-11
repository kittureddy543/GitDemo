package Resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification Bookreq;
	
	public RequestSpecification requestSpecification() throws IOException
	{		
		if(Bookreq==null)
		{
		PrintStream log=new PrintStream(new FileOutputStream("log.txt"));	
		Bookreq=new RequestSpecBuilder().setBaseUri(globalValue("baseUrl"))
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		return Bookreq;
		}
		return Bookreq;
	}
	
	public String globalValue(String key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fir=new FileInputStream("C:\\Users\\RT\\eclipse-workspace\\BDDCucumber\\src\\test\\java\\Resources\\global.properties");
		prop.load(fir);		
		return prop.getProperty(key);
	}

	public String getJsonPath(Response response, String key)
	{
		String AddBookResp=response.asString();
		JsonPath js=new JsonPath(AddBookResp);
		return js.get(key).toString();
	}
}
