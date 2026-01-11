package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	@Before("@DeleteBook")
	public void BeforeScenario() throws IOException
	{
		stepDefination n=new stepDefination();
		if(stepDefination.id==null)
		{
			n.add_book_payload();
			n.user_calls_with_http_request("addBookAPI", "POST");
			n.verify_id_created_map_to_using("JohnAA", "getBookAPI");
		}
	}

}
