package vtiger.Practice;

import org.testng.annotations.Test;

public class GenericMethodPractice {
	//Caller
	@Test
	public void genericMethodPractice() {
		add1(); 
		add2(49, 27);
		add2(11, 58);
		add2(15, 5);
		add2(139, 48);
	}
	//Called (Normal Method)
	public static void add1() {
		int a = 5;
		int b = 10;
		int c = a + b;
		System.out.println(c);
	}
	//called (Generic Method)
	public static int add2(int a, int b) {
		int c = a+b;
		System.out.println(c);
		return c;
		
	}

}
