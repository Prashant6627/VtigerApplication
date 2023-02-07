package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
	@Test(enabled=true,priority=5,invocationCount=2)
	public void createCustomerTest() {
		System.out.println("tc-1 : Customer is created");
	}
	@Test(priority=1,enabled=true,dependsOnMethods= {"createCustomerTest","modifyCustomerTest"})
	public void deleteCustomerTest() {
		System.out.println("tc 3 : Customer is deleted");
	}
	@Test(priority=-2,dependsOnMethods="createCustomerTest")
	public void modifyCustomerTest() {
		//Assert.fail();
		System.out.println("tc 2 : Customer is modified");
	}
}

