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

public class Deelslist extends BaseClass{
	
		public static void Invalidsearchdeels(String Keyword) throws Throwable
		{
			parenttest = extent.createTest("Search Deels Suite");
			childtest = parenttest.createNode("Verify validation while passing invalid deel names");
			Reporter.log("Verify validation while passing invalid deel names", true);
			WebElement DashboardDeeL = getwebElement("DeeLChat.Deelslist.DashboardDeeL");
			explicitwaitvisible(d, DashboardDeeL);
			DashboardDeeL.click();
			WebElement Search = getwebElement("DeeLChat.Deelslist.Search");
			Search.clear();
			Search.sendKeys(Keyword);
			childtest.log(Status.PASS, MarkupHelper.createLabel("Entering invalid search keyword : "+Keyword, ExtentColor.BLUE));
			d.executeScript("seetest:client.deviceAction(\"Enter\")");
			
			WebElement Invalidsearchresult = getwebElement("DeeLChat.Deelslist.Invalidsearchresult");
			explicitwaitvisible(d, Invalidsearchresult);
			try {
				if(Invalidsearchresult.isDisplayed()){
					String validationText = Invalidsearchresult.getText().trim();
					Assert.assertEquals(validationText, Validation.invalid_search_result);
					System.out.println("Actual Value" + validationText + " " + " Expected value"
							+ Validation.invalid_search_result);
					Reporter.log("Actual Value: " + validationText + " " + " Expected value: "
							+ Validation.invalid_search_result, true);
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
				
				DashboardDeeL.click();
		}
		
		public static void Validprefixsearchdeels(String Keyword) throws Throwable
		{
			childtest = parenttest.createNode("Verify search results appeared for prefix keywords");
			Reporter.log("Verify search results appeared for prefix keywords", true);
			
			WebElement DashboardDeeL = getwebElement("DeeLChat.Deelslist.DashboardDeeL");
			explicitwaitvisible(d, DashboardDeeL);
			DashboardDeeL.click();
			
			WebElement Search = getwebElement("DeeLChat.Deelslist.Search");
			Search.clear();
			Search.sendKeys(Keyword);
			childtest.log(Status.PASS, MarkupHelper.createLabel("Entering valid search keyword (Prefix) : "+Keyword, ExtentColor.BLUE));
		
			WebElement Optionclick = getwebElement("DeelChat.Deelslist.Optionclick");
			explicitwaitvisible(d, Optionclick);
			Optionclick.click();
			
			WebElement title = getwebElement("DeelChat.Deelslist.Title");
			try {
				if (title.isDisplayed()){
					explicitwaitvisible(d, title);
				
						if(title.isDisplayed()){
							String validationText = title.getText();
							Assert.assertEquals(validationText, Validation.validtitle);
							System.out.println("Actual Value : " + validationText + " " + " Expected value : "
									+ Validation.validtitle);
							Reporter.log("Actual Value : " + validationText + " " + " Expected value : "
									+ Validation.validtitle, true);
						}
						else {
							System.out.println("Element not found");
						}
					}
			}
			catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
				String alert = getScreenshot(d, "alert");
				childtest.info("Verify search results appeared for prefix keywords",
						MediaEntityBuilder.createScreenCaptureFromBase64String(alert).build());
				
				WebElement BackArrow = getwebElement("DeeLChat.Deelslist.Backarrow");
				explicitwaitvisible(d, BackArrow);
				BackArrow.click();
		}
		
		public static void Validsuffixsearchdeels(String Keyword) throws Throwable
		{
			childtest = parenttest.createNode("Verify search results appeared for suffix keywords");
			Reporter.log("Verify search results appeared for suffix keywords", true);
			
			WebElement DashboardDeeL = getwebElement("DeeLChat.Deelslist.DashboardDeeL");
			explicitwaitvisible(d, DashboardDeeL);
			DashboardDeeL.click();
			
			WebElement Search = getwebElement("DeeLChat.Deelslist.Search");
			Search.clear();
			Search.sendKeys(Keyword);
			childtest.log(Status.PASS, MarkupHelper.createLabel("Entering valid search keyword (Suffix) : "+Keyword, ExtentColor.BLUE));
		
			WebElement Optionclick = getwebElement("DeelChat.Deelslist.Optionclick");
			explicitwaitvisible(d, Optionclick);
			Optionclick.click();
			
			WebElement title = getwebElement("DeelChat.Deelslist.Title");
			try {
				if (title.isDisplayed()){
					explicitwaitvisible(d, title);
				
						if(title.isDisplayed()){
							String validationText = title.getText();
							Assert.assertEquals(validationText, Validation.validtitle);
							System.out.println("Actual Value : " + validationText + " " + " Expected value : "
									+ Validation.validtitle);
							Reporter.log("Actual Value : " + validationText + " " + " Expected value : "
									+ Validation.validtitle, true);
						}
						else {
							System.out.println("Element not found");
						}
					}
			}
			catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
				String alert = getScreenshot(d, "alert");
				childtest.info("Verify search results appeared for suffix keywords",
						MediaEntityBuilder.createScreenCaptureFromBase64String(alert).build());
				
				WebElement BackArrow = getwebElement("DeeLChat.Deelslist.Backarrow");
				explicitwaitvisible(d, BackArrow);
				BackArrow.click();
				
		}
		
		public static void Validmiddlesearchdeels(String Keyword) throws Throwable
		{
			
			childtest = parenttest.createNode("Verify search results appeared for middle keywords");
			Reporter.log("Verify search results appeared for middle keywords", true);
			
			WebElement DashboardDeeL = getwebElement("DeeLChat.Deelslist.DashboardDeeL");
			explicitwaitvisible(d, DashboardDeeL);
			DashboardDeeL.click();
			
			WebElement Search = getwebElement("DeeLChat.Deelslist.Search");
			Search.clear();
			Search.sendKeys(Keyword);
			childtest.log(Status.PASS, MarkupHelper.createLabel("Entering valid search keyword (Middle) : "+Keyword, ExtentColor.BLUE));
		
			WebElement Optionclick = getwebElement("DeelChat.Deelslist.Optionclick");
			explicitwaitvisible(d, Optionclick);
			Optionclick.click();
			
			WebElement title = getwebElement("DeelChat.Deelslist.Title");
			try {
				if (title.isDisplayed()){
					explicitwaitvisible(d, title);
				
						if(title.isDisplayed()){
							String validationText = title.getText();
							Assert.assertEquals(validationText, Validation.validtitle);
							System.out.println("Actual Value : " + validationText + " " + " Expected value : "
									+ Validation.validtitle);
							Reporter.log("Actual Value : " + validationText + " " + " Expected value : "
									+ Validation.validtitle, true);
						}
						else {
							System.out.println("Element not found");
						}
					}
			}
			catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
				String alert = getScreenshot(d, "alert");
				childtest.info("Verify search results appeared for middle keywords",
						MediaEntityBuilder.createScreenCaptureFromBase64String(alert).build());
				
				WebElement BackArrow = getwebElement("DeeLChat.Deelslist.Backarrow");
				explicitwaitvisible(d, BackArrow);
				BackArrow.click();
		}
}

