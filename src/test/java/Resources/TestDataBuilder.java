package Resources;

public class TestDataBuilder {
	
	
	public String AddBookPayload()
	{
				
		return "{\r\n\"name\":\"PublicA\",\r\n\"isbn\":\"myid\",\r\n\"aisle\":\"145417\",\r\n\"author\":\"JohnAA\"\r\n}";
		
	}
	
	public String DeletBookPayload(String id)
	{
		return "{\r\n\"ID\" : \""+id+"\"\r\n}"; 
	}

}
