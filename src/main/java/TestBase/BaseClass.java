package TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Utils.TestUtils;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BaseClass extends TestUtils {
	static public String rel_path=System.getProperty("user.dir");
	static ExtentHtmlReporter htmlreporter;
	public static ExtentSparkReporter htmlReports;
	public static ExtentReports extent;
	public static ExtentTest parenttest;
	public static ExtentTest childtest;
	public static ExtentTest grandchildtest;
	public static Properties Properties = new Properties();
	public static File f;
	public static FileInputStream FI;
	public InputStream input;
	
	@BeforeSuite
	public void setup() throws Throwable {
		
		selectBrowser();
		loadpropertiesFile();
		htmlReports = new ExtentSparkReporter(rel_path+"./Reports/DeeLChat_Automation_Report.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReports);
		htmlReports.config().setTheme(Theme.STANDARD);
		htmlReports.config().setDocumentTitle("DeeLChat Automation Report");
		htmlReports.config().setReportName("DeeLChat Automation Testing Report");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) 
		{
			childtest.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			childtest.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		} 
		else if (result.getStatus() == ITestResult.SKIP) 
		{
			childtest.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		} 
		else if (result.getStatus() == ITestResult.SUCCESS) 
		{
			childtest.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " - Test Case Completed", ExtentColor.GREEN));
		}
	}
	
	public static String Screenshot() throws IOException {
		File srcFiler = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		byte[] encoded;
		encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(srcFiler));
		String s = new String(encoded, StandardCharsets.US_ASCII);
		return s;
		}
	
	public static void loadpropertiesFile() throws IOException {
		System.out.println("Properties loading");
		f = new File(rel_path+"/src/main/java/Properties/Login.properties");
		FI = new FileInputStream(f);
		Properties.load(FI);
		
		f = new File(rel_path+"/src/main/java/Properties/Deelslist.properties");
		FI = new FileInputStream(f);
		Properties.load(FI);
		
		f = new File(rel_path+"/src/main/java/Properties/Retmerlist.properties");
		FI = new FileInputStream(f);
		Properties.load(FI);
		
		f = new File(rel_path+"/src/main/java/Properties/Logout.properties");
		FI = new FileInputStream(f);
		Properties.load(FI);
	}
	
	public static void explicitwaitclickable(WebDriver driver, WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void explicitwaitvisible(WebDriver driver, WebElement validsearchresults) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOf(validsearchresults));
	}
	public void explicitwaitvisibletolocate(WebDriver driver, WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
	}
	public void explicitwaitelementclickable(WebDriver driver, WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	@SuppressWarnings("rawtypes")
	public static void swiperighttoleft()
	{
		TouchAction action = new TouchAction(d);
		action.press(PointOption.point(1034, 1238));
		action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(184)));
		action.moveTo(PointOption.point(350, 1238));
		action.release();
		action.perform();
	}
	@SuppressWarnings("rawtypes")
	public static void swipeleftoright()
	{
		TouchAction action = new TouchAction(d);
		action.press(PointOption.point(142, 1184));
		action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(616)));
		action.moveTo(PointOption.point(1061, 1226));
		action.release();	
		action.perform();
	}
	public static WebElement getlocators(String locator) throws Exception {
		String[] split = locator.split(":");
		String locatortype = split[0];
		String locatorvalue = split[1];

		if (locatortype.toLowerCase().equals("id"))
			return d.findElement(By.id(locatorvalue));
		else if (locatortype.toLowerCase().equals("name"))
			return d.findElement(By.name(locatorvalue));
		else if (locatortype.toLowerCase().equals("classname") || (locatortype.toLowerCase().equals("class")))
			return d.findElement(By.className(locatorvalue));
		else if (locatortype.toLowerCase().equals("tagname") || (locatortype.toLowerCase().equals("tag")))
			return d.findElement(By.className(locatorvalue));
		else if (locatortype.toLowerCase().equals("linktext") || (locatortype.toLowerCase().equals("link")))
			return d.findElement(By.linkText(locatorvalue));
		else if (locatortype.toLowerCase().equals("partiallinktext"))
			return d.findElement(By.partialLinkText(locatorvalue));
		else if ((locatortype.toLowerCase().equals("cssselector")) || (locatortype.toLowerCase().equals("css")))
			return d.findElement(By.cssSelector(locatorvalue));
		else if (locatortype.toLowerCase().equals("xpath"))
			return d.findElement(By.xpath(locatorvalue));
		else
			throw new Exception("Unknown locator type '" + locatortype + "'");
	}
	public static List<AndroidElement> getlocatorss(String locator) throws Exception {
		String[] split = locator.split(":");
		String locatortype = split[0];	
		String locatorvalue = split[1];

		if (locatortype.toLowerCase().equals("id"))
			return d.findElements(By.id(locatorvalue));
		else if (locatortype.toLowerCase().equals("name"))
			return d.findElements(By.name(locatorvalue));
		else if (locatortype.toLowerCase().equals("classname") || (locatortype.toLowerCase().equals("class")))
			return d.findElements(By.className(locatorvalue));
		else if (locatortype.toLowerCase().equals("tagname") || (locatortype.toLowerCase().equals("tag")))
			return d.findElements(By.className(locatorvalue));
		else if (locatortype.toLowerCase().equals("linktext") || (locatortype.toLowerCase().equals("link")))
			return d.findElements(By.linkText(locatorvalue));
		else if (locatortype.toLowerCase().equals("partiallinktext"))
			return d.findElements(By.partialLinkText(locatorvalue));
		else if ((locatortype.toLowerCase().equals("cssselector")) || (locatortype.toLowerCase().equals("css")))
			return d.findElements(By.cssSelector(locatorvalue));
		else if (locatortype.toLowerCase().equals("xpath"))
			return d.findElements(By.xpath(locatorvalue));
		else
			throw new Exception("Unknown locator type '" + locatortype + "'");
	}
	
	public static WebElement getwebElement(String locator) throws Exception
	{
		return getlocators(Properties.getProperty(locator));
	}

	public static List<AndroidElement> getwebElements(String locator) throws Exception {
		return getlocatorss(Properties.getProperty(locator));
	}
	
	public static int getElementssize(WebElement element, String optionName) throws Exception {
		List<WebElement> listOfElements = element.findElements(By.tagName(optionName));
		int n=listOfElements.size();
			return n;
	}
		
	public static List<WebElement> getElementsByTagName(WebElement element, String optionName) {
		List<WebElement> listOfElements = element.findElements(By.xpath(optionName));
		if (listOfElements.size() != 0)
			return listOfElements;
		else
			return null;
	}

	@AfterSuite
	public void endReport() {
		extent.flush();
		d.quit();;
	}
}
