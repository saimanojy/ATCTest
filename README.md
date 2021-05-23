**# ATCTask**

**#Tools:**

• Framework used: Cucumber Framework

**#Points to be Noted before Run:**

• Place Chrome driver under drivers folder

• Suggested to trigger run from runner class in src\test\java

• Screenshots will be pasted in screenshots folder in YYYYMMDD-HHmmss-description.png format

• All input details will be fetched from input.xlsx file under src\test\resources

• Make sure to delete address added from second instance of triggering run else it would throw assertion error as address was already present.

 

**#Failure that are handled Which are to be reported in Real-Time:**

• when navigating from page to page a webPage saying URL blocked is being displayed, to handle that a logic is written in checkAssertEquals method in Utils.java class. To show entire flow I have handled that error but however this has to be reported in real time project.
	
• URL blocked is being displaying in a message box while clicking on Add To Cart in product page, this was handled in waitToBeClickable methods in Utils.java class. To show entire flow I have handled that error but however this has to be reported in real time project.

• URL blocked page when displayed after clicking confirm order leads to error page when URL blocked condition is handled. This was handled in checkAssertEquals methods in Utils.java Class


