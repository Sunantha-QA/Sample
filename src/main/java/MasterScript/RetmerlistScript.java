package MasterScript;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageScript.Retmerlist;
import TestBase.BaseClass;

public class RetmerlistScript extends BaseClass{
	
	Retmerlist retmerlist_obj = new Retmerlist();
	
	@Test(priority = 1)
	public void TC_01_titlevalidation() throws Throwable {
		String testcasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try 
		{
			System.out.println("Retmerlist TC_01 started");
			retmerlist_obj.Titlevalidation();

		} catch (Exception e) {
			throw e;
		}
	}
	
	@Test(priority = 2)
	public void TC_02_retmercount() throws Throwable {
		String testcasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try 
		{
			System.out.println("Retmerlist TC_02 started");
			retmerlist_obj.retmercount();

		} catch (Exception e) {
			throw e;
		}
	}
	
	@Test(priority = 3)
	public void TC_03_retmerlistvalidation() throws Throwable {
		String testcasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try 
		{
			System.out.println("Retmerlist TC_03 started");
			retmerlist_obj.retmerlistvalidation();

		} catch (Exception e) {
			throw e;
		}
	}
}
