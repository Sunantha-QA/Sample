package Utils;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import Excel.ExcelRead;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestUtils extends ExcelRead{
	public static AndroidDriver<AndroidElement> d;
	protected static ExcelRead data=new ExcelRead();
	public static void selectBrowser() throws Throwable
	{
		String device = (data.ReadExcelData(1, 0, "browser"));
		System.out.println("Device value " + device);
		String rel_path=System.getProperty("user.dir");
		File app = new File(rel_path+"/DeeLChat/APK_File/app-release.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		if(device.equalsIgnoreCase("android"))
		{
			System.out.println("Android is selected");		
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 50);
			//cap.setCapability("platformName", "Android");
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2" );
			cap.setCapability(MobileCapabilityType.UDID, "RZ8M20M3ZQY");
			cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.deelchat");
			cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".modules.Splash.SplashActivity");
		    d = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), cap);
		    d.setLogLevel(Level.INFO);
		    d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}
	public static String getScreenshot(WebDriver d, String screenshotName) throws Exception {
		return ((TakesScreenshot) d).getScreenshotAs(OutputType.BASE64);
	}
}
