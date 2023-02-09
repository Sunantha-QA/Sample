package PageScript;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Properties.Validation;
import TestBase.BaseClass;
import io.appium.java_client.android.AndroidElement;

public class Retmerlist extends BaseClass{
	
	SoftAssert s = new SoftAssert();
	public void Titlevalidation() throws Throwable
	{
		parenttest = extent.createTest("List of items in the deel Suite");
		childtest = parenttest.createNode("Verify selected deel name is appeared in the title");
		Reporter.log("Verify selected deel name is appeared in the title", true);
	
		WebElement DashboardDeeL = getwebElement("DeeLChat.Deelslist.DashboardDeeL");
		explicitwaitvisible(d, DashboardDeeL);
		DashboardDeeL.click();
		
		WebElement Search = getwebElement("DeeLChat.Deelslist.Search");
		Search.clear();
		Search.sendKeys(data.ReadExcelData(0, 0, "Deel search"));
		childtest.log(Status.PASS, MarkupHelper.createLabel("Entering valid search keyword : "+data.ReadExcelData(0, 0, "Deel search"), ExtentColor.BLUE));
		
		WebElement Optionclick = getwebElement("DeelChat.Deelslist.Optionclick");
		explicitwaitvisible(d, Optionclick);
		Optionclick.click();
		
		WebElement Title = getwebElement("DeeLChat.Retmerlist.Title");
		explicitwaitvisible(d, Title);
		
		try {
				String validationText = Title.getText();
				System.out.println("Actual Value : " + validationText + " " + " Expected value : "
						+ Validation.deelitemtitle);
				Reporter.log("Actual Value : " + validationText + " Expected value : "
						+ Validation.deelitemtitle, true);
				Assert.assertEquals(validationText, Validation.deelitemtitle);
		}
		catch (AssertionError e) {
			childtest.log(Status.FAIL, MarkupHelper.createLabel("error in assert", ExtentColor.BLUE));
		}
		
		String alert = getScreenshot(d, "alert");
		childtest.info("Verify selected deel name is appeared in the title",
				MediaEntityBuilder.createScreenCaptureFromBase64String(alert).build());
		
		WebElement BackArrow = getwebElement("DeeLChat.Deelslist.Backarrow");
		explicitwaitclickable(d, BackArrow);
		BackArrow.click();
	}
	
	public void retmercount() throws Throwable
	{
		childtest = parenttest.createNode("Count of retmers against deel");
		Reporter.log("Count of retmers against deel", true);
		
		WebElement DashboardDeeL = getwebElement("DeeLChat.Deelslist.DashboardDeeL");
		explicitwaitvisible(d, DashboardDeeL);
		DashboardDeeL.click();
		
		WebElement Search = getwebElement("DeeLChat.Deelslist.Search");
		Search.clear();
		Search.sendKeys(data.ReadExcelData(0, 0, "Deel search"));
		childtest.log(Status.PASS, MarkupHelper.createLabel("Entering valid search keyword : "+data.ReadExcelData(0, 0, "Deel search"), ExtentColor.BLUE));
		
		WebElement Option = getwebElement("DeelChat.Deelslist.Retmerscount");
		explicitwaitvisible(d, Option);
		
		try {
				String validationText = Option.getText();
				String actualText = data.excel_row_count("Retmer search")+Validation.retmercount;
				
				System.out.println("Actual Value : " + validationText + " " + " Expected value : "
						+ actualText);
				Reporter.log("Actual Value : " + validationText + " " + " Expected value : "
						+ actualText, true);
				Assert.assertEquals(validationText, actualText);
		}
		catch (AssertionError e) {
			childtest.log(Status.FAIL, MarkupHelper.createLabel("No of retmers count against a deel is incorrect",ExtentColor.BLUE));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		System.out.println("8999999999999989999999999999");
		String alert = getScreenshot(d, "alert");
		childtest.info("Count of retmers against deel",
				MediaEntityBuilder.createScreenCaptureFromBase64String(alert).build());
	}
	
	public void retmerlistvalidation() throws Throwable
	{
		childtest = parenttest.createNode("Verify search results appeared keywords");
		Reporter.log("Verify search results appeared keywords", true);
	
		WebElement DashboardDeeL = getwebElement("DeeLChat.Deelslist.DashboardDeeL");
		explicitwaitvisible(d, DashboardDeeL);	
		DashboardDeeL.click();
		
		WebElement Search = getwebElement("DeeLChat.Deelslist.Search");
		Search.clear();
		Search.sendKeys(data.ReadExcelData(0, 0, "Deel search"));
		childtest.log(Status.PASS, MarkupHelper.createLabel("Entering valid search keyword : "+data.ReadExcelData(0, 0, "Deel search"), ExtentColor.BLUE));
		
		WebElement Optionclick = getwebElement("DeelChat.Deelslist.Optionclick");
		explicitwaitvisible(d, Optionclick);
		Optionclick.click();
		
		try {
			List<AndroidElement> retmers = getwebElements("DeeLChat.Retmerlist.Retmerscount");
			for(int i =0; i<data.excel_row_count("Retmer search");i++)
			{
				explicitwaitvisible(d, retmers.get(i));
					String validationText = retmers.get(i).getText();;
					Assert.assertEquals(validationText, data.ReadExcelData(i, 0, "Retmer search"));
					System.out.println("Actual Value : " + validationText + " " + " Expected value : "
							+ data.ReadExcelData(i, 0, "Retmer search"));
					Reporter.log("Actual Value : " + validationText + " Expected value : "
							+ data.ReadExcelData(i, 0, "Retmer search"), true);
				}
			}
		catch (AssertionError e) {
			childtest.log(Status.FAIL, MarkupHelper.createLabel("List of retmer matches with expected results",ExtentColor.BLUE));
		}
		
		String alert = getScreenshot(d, "alert");
		childtest.info("Verify search results appeared keywords",
				MediaEntityBuilder.createScreenCaptureFromBase64String(alert).build());
		
		WebElement BackArrow = getwebElement("DeeLChat.Deelslist.Backarrow");
		explicitwaitvisible(d, BackArrow);
		BackArrow.click();
	}

}
