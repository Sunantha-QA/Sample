package MasterScript;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageScript.Login;
import TestBase.BaseClass;

public class LoginScript extends BaseClass{
	
	Login login_object = new Login();
	
	@DataProvider 
	public String[] invalid_emails()
	{
		String[] data= {"advertiser","advertiser123","advertiser123@.com","fabricstudioyopmail.com","fabricstudio@yopmail"};
		return data;
	}
	@DataProvider 
	public Object[][] invalid_password()
	{
		Object[][] data= {{"fix@yopmail.com","test"}};
		return data;
	}
	@DataProvider 
	public Object[][] valid_credential()
	{
		Object[][] data= {{"fix@yopmail.com","Test1234"}};
		return data;
	}
	@Test(priority = 1)
	public void TC_01_LoginRequiredFieldValidation() throws Exception {
		String testcasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try 
		{
			System.out.println("Login TC_01 started");
			login_object.LoginRequiredfields();

		} catch (Exception e) {
			throw e;
		}
	}
	
	@Test(priority = 2, dataProvider="invalid_emails")
	public void TC_02_InvalidEmail(String emails) throws Exception { 
		String testcasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try 
		{
			System.out.println("Login TC_02 started");
			Login.Logininvalidemail(emails);
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Test(priority = 3, dataProvider="invalid_password")
	public void TC_03_InvalidPassword(String validemail, String invalidpassword) throws Throwable { 
		String testcasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try 
		{
			System.out.println("Login TC_02 started");
			Login.Logininvalidpassword(validemail, invalidpassword);
			
		} catch (Exception e) {
			throw e;
		}
	}
	@Test(priority = 4, dataProvider="valid_credential", groups = { "Static" })
	public void TC_04_LoginValidCredential(String valid_email, String valid_password) throws Throwable {
		String testcasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try 
		{
			System.out.println("Login TC_01 started");
			Login.LoginValidCredential(valid_email,valid_password);

		} catch (Exception e) {
			throw e;
		}
	}
}
