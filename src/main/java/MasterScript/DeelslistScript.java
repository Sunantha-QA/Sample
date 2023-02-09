package MasterScript;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageScript.Deelslist;
import TestBase.BaseClass;

public class DeelslistScript extends BaseClass {
	
	Deelslist deelslist_obj = new Deelslist();

	@DataProvider 
	public String[] invalid_searchdeel()
	{
		String[] data= {"bhdgtr"};
		return data;
	}
	
	@DataProvider 
	public String[] Validsuffixsearchdeels()
	{
		String[] data= {"ilk"};
		return data;
	}
	@DataProvider 
	public String[] Validprefixsearchdeels()
	{
		String[] data= {"Mil"};
		return data;
	}
	@DataProvider 
	public String[] Validmiddlesearchdeels()
	{
		String[] data= {"il"};
		return data;
	}
	
	@Test(priority = 1, dataProvider="invalid_searchdeel")
	public void TC_01_InvalidSearchDeels(String Keyword) throws Throwable {
		String testcasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try 
		{
			System.out.println("Deels list TC_01 started");
			Deelslist.Invalidsearchdeels(Keyword);
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Test(priority = 2, dataProvider="Validprefixsearchdeels")
	public void TC_02_Validprefixsearchdeels(String Keyword) throws Throwable {
		String testcasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try 
		{
			System.out.println("Deels list TC_02 started");
			Deelslist.Validprefixsearchdeels(Keyword);
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Test(priority = 3, dataProvider="Validsuffixsearchdeels")
	public void TC_02_Validsuffixsearchdeels(String Keyword) throws Throwable {
		String testcasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try 
		{
			System.out.println("Deels list TC_03 started");
			Deelslist.Validsuffixsearchdeels(Keyword);
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Test(priority = 4, dataProvider="Validmiddlesearchdeels")
	public void TC_02_Validmiddlesearchdeels(String Keyword) throws Throwable {
		String testcasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try 
		{
			System.out.println("Deels list TC_04 started");
			Deelslist.Validmiddlesearchdeels(Keyword);
			
		} catch (Exception e) {
			throw e;
		}
	}
	
}
