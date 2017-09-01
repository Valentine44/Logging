Feature: GmailTestSteps

Background:
Given 	user opens Google login form
And 	user submits "correct" email

Scenario: Mouse and keyboard actions

And 	user submits "correct" password
When 	user opens Gmail
And 	user composes a letter
And 	user sends a letter
And 	user navigates to "Sent Mail"
And 	user removes last sent letter
#Then 	message 'The message has been moved to the Trash.' is displayed
And 	user logs out

Scenario: JavaScript in Selenium Java test

And 	user submits "correct" password
When 	user opens Gmail
Then 	user is in Gmail Inbox
And 	user refreshes page
Then 	user is in Gmail Inbox
And 	user logs out

Scenario: Letter draft creation

And 	user submits "correct" password
When 	user opens Gmail
And 	user composes a letter
And 	user saves draft
And 	user navigates to "Drafts"
And 	user opens draft
And 	user sends draft
And 	user navigates to "Sent Mail"
Then 	letter just sent is in Sent Mail
And 	user logs out

Scenario: Incorrect password submission

And 	user submits "incorrect" password
Then 	message 'Wrong password. Try again.' is displayed
And 	user submits "correct" password
When 	user opens Gmail
Then 	user is in Gmail Inbox
And 	user logs out

Scenario: Letter window
And 	user submits "correct" password
When 	user opens Gmail
And 	user composes a letter
And 	user sends a letter
And 	user navigates to "Sent Mail"
And 	user searches letter
And 	user opens found letter
And 	user opens letter in new window
Then 	letter subject is correct
Then 	letter sender is correct
Then 	letter body is correct
And     user removes letter open in separate window
And     user closes letter window
Then    letter just sent is not in Sent Mail
And     user logs out

Scenario Outline: Parameterization usage
	And     user submits "correct" password
	When    user opens Gmail
	And     user navigates to "<page1>"
	And     user navigates to "<page2>"
	And     user logs out
Examples:
	|page1    |page2|
	|Sent Mail|Inbox|
	|Drafts   |Inbox|