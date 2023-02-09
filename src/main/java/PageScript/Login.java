package PageScript;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Properties.Validation;
import TestBase.BaseClass;
import Excel.ExcelRead;

public class Login extends BaseClass {

	public void LoginRequiredfields() throws Exception
	{
//		WebElement rightarrow = getwebElement("DeeLChat.OnboardingScreen.RightArrow");
//		rightarrow.click();
//		rightarrow.click();
//		rightarrow.click();
//		rightarrow.click();
		parenttest = extent.createTest("Login Suite");
		childtest = parenttest.createNode("Verify Login Required Fields");
		System.out.println("DeeLChat Application launched successfully");
		Reporter.log("Verify Required Fields of Login Page", true);
		WebElement LoginButton = getwebElement("DeeLChat.Login.LoginButton");
		explicitwaitclickable(d, LoginButton);
		LoginButton.click();
		Reporter.log("Submit button is clicked", true);

		WebElement EmailPasswordRequired = getwebElement("DeeLChat.Login.EmailPasswordRequired");
		
		explicitwaitvisible(d, EmailPasswordRequired);
		try 
		{
			if (EmailPasswordRequired.isDisplayed()) 
			{
				String validationemailpassword = EmailPasswordRequired.getText().trim();
				System.out.println(validationemailpassword);
				Assert.assertEquals(validationemailpassword, Validation.emailpassword_required);
				System.out.println("Actual Value : " + validationemailpassword + "Expected value : " + Validation.emailpassword_required);
			} 
			else 
			{
				System.out.println("Element not found");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw e;
		}
		String success = getScreenshot(d, "Requiredfiled");
		childtest.info("Login Required Fields",MediaEntityBuilder.createScreenCaptureFromBase64String(success).build());
	}

	public static void Logininvalidemail(String invalidemail) throws Exception
	{
		childtest = parenttest.createNode("Verify Login with invalid email");
		Reporter.log("Verify Login with invalid email", true);
		WebElement email = getwebElement("DeeLChat.Login.Email");
		email.clear();
		email.sendKeys(invalidemail);
		childtest.log(Status.PASS, MarkupHelper.createLabel("Entering the username : "+invalidemail, ExtentColor.BLUE));
		
		WebElement LoginButton = getwebElement("DeeLChat.Login.LoginButton");
		LoginButton.click();
		Reporter.log("LoginButton button is clicked", true);
		
		WebElement actualemailerror = getwebElement("DeeLChat.Login.InvalidEmail");
		explicitwaitvisible(d, actualemailerror);
		try {
			if(actualemailerror.isDisplayed()){
				String validationText = actualemailerror.getText().trim();
				Assert.assertEquals(validationText, Validation.invalidemail);
				System.out.println("Actual Value" + validationText + " " + " Expected value"
						+ Validation.invalidemail);
				Reporter.log("Actual Value: " + validationText + " " + " Expected value: "
						+ Validation.invalidemail, true);
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
			childtest.info("Email format validation",
					MediaEntityBuilder.createScreenCaptureFromBase64String(alert).build());
	}
	
	public static void Logininvalidpassword(String validemail, String invalidpassword) throws Throwable
	{
		childtest = parenttest.createNode("Verify Login with invalid password");
		Reporter.log("Verify Login with invalid password", true);
		WebElement email = getwebElement("DeeLChat.Login.Email");
		childtest.log(Status.PASS, MarkupHelper.createLabel("Entering the Email : "+validemail, ExtentColor.BLUE));
		email.clear();
		email.sendKeys(validemail);
		
		WebElement password = getwebElement("DeeLChat.Login.Password");
		childtest.log(Status.PASS, MarkupHelper.createLabel("Entering the password : "+invalidpassword, ExtentColor.BLUE));
		password.clear();
		password.sendKeys(invalidpassword);
				
		WebElement LoginButton = getwebElement("DeeLChat.Login.LoginButton");
		LoginButton.click();
		Reporter.log("Login Button button is clicked", true);
		
		WebElement actualpassworderror = getwebElement("DeeLChat.Login.InvalidPassword");
		explicitwaitvisible(d, actualpassworderror);
		try {
			if(actualpassworderror.isDisplayed()){
				String validationText = actualpassworderror.getText().trim();
				Assert.assertEquals(validationText, Validation.invalidpassword);
				System.out.println("Actual Value" + validationText + " " + " Expected value"
						+ Validation.invalidpassword);
				Reporter.log("Actual Value: " + validationText + " " + " Expected value: "
						+ Validation.invalidpassword, true);
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
			childtest.info("Invalid password validation",
					MediaEntityBuilder.createScreenCaptureFromBase64String(alert).build());
	}
	public static void LoginValidCredential(String vaild_email, String valid_password) throws Throwable
	{
		childtest = parenttest.createNode("Verify Login with valid credentials");
		Reporter.log("Verify Login with valid credentials", true);
		WebElement email = getwebElement("DeeLChat.Login.Email");
		childtest.log(Status.PASS, MarkupHelper.createLabel("Entering the Email : "+vaild_email, ExtentColor.BLUE));
		email.clear();
		email.sendKeys(vaild_email);
		
		WebElement password = getwebElement("DeeLChat.Login.Password");
		childtest.log(Status.PASS, MarkupHelper.createLabel("Entering the password : "+valid_password, ExtentColor.BLUE));
		password.clear();
		password.sendKeys(valid_password);
				
		WebElement LoginButton = getwebElement("DeeLChat.Login.LoginButton");
		LoginButton.click();
		Reporter.log("Login Button button is clicked", true);
		
		WebElement validlogin = getwebElement("DeeLChat.Login.SuccessfulLoginCheck");
		explicitwaitvisible(d, validlogin);
		try {
			if(validlogin.isDisplayed()){
				String validationText = validlogin.getText().trim();
				Assert.assertEquals(validationText, Validation.successlogin);
				System.out.println("Actual Value" + validationText + " " + " Expected value"
						+ Validation.successlogin);
				Reporter.log("Actual Value: " + validationText + " " + " Expected value: "
						+ Validation.successlogin, true);
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
			childtest.info("Login with valid credentials",
					MediaEntityBuilder.createScreenCaptureFromBase64String(alert).build());
	}
}
