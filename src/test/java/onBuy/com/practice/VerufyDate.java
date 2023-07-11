package onBuy.com.practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class VerufyDate {

	public static void main(String[] args) {
		
		Date d=new Date();
		System.out.println(d.toString());//Fri Jun 30 14:24:25 IST 2023
		
		SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy");
		System.out.println(s.format(d));//30-06-23
		
		Calendar c=Calendar.getInstance();
		c.add(Calendar.DATE, -30);
		Date date = c.getTime();
	
		System.out.println(s.format(date));//31-05-2023

		
	}

}
