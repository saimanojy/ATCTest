**# ATCTask**

URL: http://automationpractice.com/index.php

Sign up into the application

Automation Steps:

1. Login into the application
2. Navigate to 'My Addresses' and add a new address
3. Fill all the informations(not only the mandatory)
4. Click 'Save'
5. Navigate to 'Women' --> Summer dresses
6. The Items would be in 'Grid view'. Change it to 'List View'.
7. Click on the first item to view.
8. Increase the quantity to 5
9. Change the size to 'L'
10.Select any colour. 
11.Add to cart
12.Click 'Continue shopping' and repeat the same for the other 2 items as well under the summer dresses.
13. Proceed to checkout and complete the payment
14. Move to your profile and check 'order history and details'
15. Capture screenshot of the order history
16. Sign out from the application


**#Tools:**

• Framework used: Cucumber Framework

**#Points to be Noted before Run:**

• Place Chrome driver under drivers folder (do create "drivers" folder and place it under project level)

• Suggested to trigger run from runner class in src\test\java

• Screenshots will be pasted in screenshots folder in YYYYMMDD-HHmmss-description.png format

• All input details will be fetched from input.xlsx file under src\test\resources

• Make sure to delete address added from second instance of triggering run else it would throw assertion error as address was already present.

 

**#Failure that are handled but has to be reported in Real-Time:**

• when navigating from page to page a webPage saying URL blocked is being displayed, to handle that a logic is written in checkAssertEquals method in Utils.java class. To show entire flow I have handled that error but however this has to be reported in real time project.
	
• URL blocked is being displaying in a message box while clicking on Add To Cart in product page, this was handled in waitToBeClickable methods in Utils.java class. To show entire flow I have handled that error but however this has to be reported in real time project.

• URL blocked page when displayed after clicking confirm order leads to error page when URL blocked condition is handled. This was handled in checkAssertEquals methods in Utils.java Class

All the above 3 error screenshots can be referred from screenshots folder.
