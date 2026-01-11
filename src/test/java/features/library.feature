Feature: Verify AddBook and DeleteBook
@AddBook @Regression
Scenario: Verify if book is being added Sucessufully to AddBook API
				Given AddBook Payload
				When User calls "addBookAPI" with "POST" http request
				Then API call got success with status code 200
				And "Msg" in response boday is "successfully added"
				And Verify Id created map to "JohnAA" using "getBookAPI"
@DeleteBook @Regression			
Scenario: Verify if delete payload functionality is working
				Given DeleteBook details
				When User calls "deleteBookAPI" with "POST" http request
				Then API call got success with status code 200
				And "msg" in response boday is "book is successfully deleted"
				