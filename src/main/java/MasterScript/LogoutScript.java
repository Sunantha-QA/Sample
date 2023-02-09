package MasterScript;

import org.testng.annotations.Test;

import PageScript.Logout;

public class LogoutScript extends Logout{
	
	Logout logout_obj = new Logout();
	
	@Test(priority = 1)
	public void TC_01_Logoutvisiblility() throws Throwable {
		String testcasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try 
		{
			System.out.println("Logout TC_01 started");
			logout_obj.Logoutvisiblility();

		} catch (Exception e) {
			throw e;
		}
	}
	
	@Test(priority = 2)
	public void TC_02_Logoutpopupno() throws Throwable {
		String testcasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try 
		{
			System.out.println("Logout TC_02 started");
			logout_obj.popupno();

		} catch (Exception e) {
			throw e;
		}
	}
	
	@Test(priority = 3)
	public void TC_03_Logoutpopupquestionvalidation() throws Throwable {
		String testcasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try 
		{
			System.out.println("Logout TC_03 started");
			logout_obj.popupquestionvalidation();

		} catch (Exception e) {
			throw e;
		}
	}
	
	@Test(priority = 4)
	public void TC_03_Logoutpopupyes() throws Throwable {
		String testcasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try 
		{
			System.out.println("Logout TC_04 started");
			logout_obj.popupyes();

		} catch (Exception e) {
			throw e;
		}
	}
}
