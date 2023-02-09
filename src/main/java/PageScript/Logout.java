package PageScript;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.MediaEntityBuilder;

import Properties.Validation;
import TestBase.BaseClass;

public class Logout extends BaseClass{
	
	public static void Logoutvisiblility() throws Throwable
	{
		parenttest = extent.createTest("Logout Suite");
		childtest = parenttest.createNode("Verify logout is appeared in the application");
		Reporter.log("Verify logout is appeared in the application", true);
		
		swiperighttoleft();
		
		WebElement Logoutbutton = getwebElement("DeeLChat.Logout.Logoutbutton");
		explicitwaitvisible(d, Logoutbutton);
		
		try {
			if(Logoutbutton.isDisplayed()){
				String validationText = Logoutbutton.getText().trim();
				Assert.assertEquals(Validation.logouttext, validationText);
				System.out.println("Actual Value : " + validationText + " " + " Expected value : "
						+ Validation.logouttext);
				Reporter.log("Actual Value : " + validationText + " " + " Expected value : "
						+ Validation.logouttext, true);
			}
			else {
			System.out.println("Element not found");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
			String alert = getScreenshot(d, "alert");
			childtest.info("Verify logout is appeared in the application",
					MediaEntityBuilder.createScreenCaptureFromBase64String(alert).build());
			
			swipeleftoright();
	}
	
	public static void popupno() throws Throwable
	{
		childtest = parenttest.createNode("Verify application is not logged out while clicking 'NO'");
		Reporter.log("Verify application is not logged out while clicking 'NO'", true);
		
		swiperighttoleft();
		
		WebElement Logoutbutton = getwebElement("DeeLChat.Logout.Logoutbutton");
		explicitwaitvisible(d, Logoutbutton);
		Logoutbutton.click();
		
		WebElement Popupno = getwebElement("DeeLChat.Logout.Popupno");
		explicitwaitvisible(d, Popupno);
		Popupno.click();
		
		try {
			if(Logoutbutton.isDisplayed()){
				String validationText = Logoutbutton.getText().trim();
				Assert.assertEquals(Validation.logoutpopupno, validationText);
				System.out.println("Actual Value : " + validationText + " " + " Expected value : "
						+ Validation.logoutpopupno);
				Reporter.log("Actual Value : " + validationText + " " + " Expected value : "
						+ Validation.logoutpopupno, true);
			}
			else {
			System.out.println("Element not found");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
			String alert = getScreenshot(d, "alert");
			childtest.info("Verify application is not logged out while clicking 'NO'",
					MediaEntityBuilder.createScreenCaptureFromBase64String(alert).build());
			
			swipeleftoright();
	}
	
	public void popupquestionvalidation() throws Throwable
	{
		childtest = parenttest.createNode("Verify logout texts is appeared in the logout popup");
		Reporter.log("Verify logout texts is appeared in the logout popup", true);
		
		swiperighttoleft();
		
		WebElement Logoutbutton = getwebElement("DeeLChat.Logout.Logoutbutton");
		explicitwaitvisible(d, Logoutbutton);
		Logoutbutton.click();
		
		WebElement Popupquestion = getwebElement("DeeLChat.Logout.Popupquestion");
		explicitwaitvisible(d, Popupquestion);
		
		try {
			if(Popupquestion.isDisplayed()){
				String validationText = Popupquestion.getText().trim();
				Assert.assertEquals(Validation.logoutpopupquestion, validationText);
				System.out.println("Actual Value : " + validationText + " " + " Expected value : "
						+ Validation.logoutpopupquestion);
				Reporter.log("Actual Value : " + validationText + " " + " Expected value : "
						+ Validation.logoutpopupquestion, true);
			}
			else {
			System.out.println("Element not found");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
			String alert = getScreenshot(d, "alert");
			childtest.info("Verify logout is appeared in the application",
					MediaEntityBuilder.createScreenCaptureFromBase64String(alert).build());
			
			WebElement Popupno = getwebElement("DeeLChat.Logout.Popupno");
			explicitwaitvisible(d, Popupno);
			Popupno.click();
			
			swipeleftoright();
	}
	
	public void popupyes() throws Throwable
	{
		childtest = parenttest.createNode("Verify application is logged out while clicking 'YES'");
		Reporter.log("Verify application is logged out while clicking 'YES'", true);
		
		swiperighttoleft();
		
		WebElement Logoutbutton = getwebElement("DeeLChat.Logout.Logoutbutton");
		explicitwaitvisible(d, Logoutbutton);
		Logoutbutton.click();
		
		WebElement Popupyes = getwebElement("DeeLChat.Logout.Popupyes");
		Popupyes.click();
		
		WebElement Loginbutton = getwebElement("DeeLChat.Login.LoginButton");
		explicitwaitvisible(d, Loginbutton);
		
		try {
			if(Loginbutton.isDisplayed()){
				String validationText = Loginbutton.getText().trim();
				Assert.assertEquals(Validation.logoutpopupyes, validationText);
				System.out.println("Actual Value : " + validationText + " " + " Expected value : "
						+ Validation.logoutpopupyes);
				Reporter.log("Actual Value : " + validationText + " " + " Expected value : "
						+ Validation.logoutpopupyes, true);
			}
			else {
			System.out.println("Element not found");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
			String alert = getScreenshot(d, "alert");
			childtest.info("Verify application is logged out while clicking 'YES'",
					MediaEntityBuilder.createScreenCaptureFromBase64String(alert).build());
	}

}
