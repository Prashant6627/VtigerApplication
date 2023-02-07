package vtiger.GenericUtility;

import java.util.Date;
import java.util.Random;

/**
 * This class contains Java specific generic methods
 * @author Prashant
 *
 */
public class JavaUtility {
	/**
	 * This method will generate a random number for every execution
	 * @return
	 */
	public int getRandomNumber() {
		Random r = new Random();
		int randomNumber = r.nextInt(1000);
		return randomNumber;
	}
	/**
	 * This method will provide system date
	 * @return
	 */
	public String getSystemDate() {
		Date d = new Date();
		String date = d.toString();
		return date;
	}
	/**
	 * This method will provide system date in specific format
	 */
	public String getSystemDateInFormat() {    //Sat Dec 10 02-02-41 IST 2022 (System Date & Time)
		Date d = new Date();                   // 0   1   2     3     4    5   (Index)
		String[] dArr = d.toString().split(" ");
		String date = dArr[2];
		String month = dArr[1];
		String year = dArr[5];
		String time = dArr[3].replaceAll(":", "-");
		String currentDateAndTime = date+" "+month+" "+year+" "+time;
		return currentDateAndTime;
		
		
	}

}
