package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testing3 
{
	SoftAssert softAssert = new SoftAssert();
	
	@Test(priority = 1, groups  = {"smoke", "sanity"}) //create new User test@test.com
	public void createUser() 
	{
		System.out.println("I am in home test");
		System.out.println("Before assertion");
		Assert.assertTrue(2>3, "Verifying Element"); //we use regular assert in industry
		System.out.println("After assertion");
		Assert.assertEquals("abc", "abc");
	}
	
	@Test(priority = 2, dependsOnMethods = "createUser") //Edit user test@test.com
	public void editUser() 
	{
		System.out.println("Before assertion");
		softAssert.assertTrue(2>3, "Verifying Element");
		System.out.println("After assertion");
		softAssert.assertAll(); //similar to error collector in junit
	}
	
	@Test(priority = 3, dependsOnMethods = "editUser") //Delete user test@test.com
	public void deleteuser() 
	{
		System.out.println("I am in end test");
		System.out.println("Before assertion");
		softAssert.assertTrue(2>3, "Verifying Element");
		System.out.println("After assertion");
		softAssert.assertEquals("abc", "abc1");
		System.out.println("After second assertion");
		softAssert.assertAll();
	}
}
