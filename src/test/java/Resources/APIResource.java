package Resources;

//Enum is special class in Java which has collection of constants or methods
public enum APIResource {
	addBookAPI("/Library/Addbook.php"),
	getBookAPI("/Library/GetBook.php"),
	deleteBookAPI("/Library/DeleteBook.php");
	
	// Fields to hold properties for each constant
	private String Resources;
	
	// Constructor to initialize properties
	APIResource(String Resources)
	{
		this.Resources=Resources;
	}
	
	// Getter methods
	public String getResource()
	{
		return Resources;
	}

}
