package Java;

import java.util.Scanner;

public class getDayFromDate {
			public static boolean isLeap(int year) {
		        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
		    }								
			
			public static String getDayOfWeek(int year, int month , int day) {
			
			String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
			
			int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31,31,30, 31,30,31};
			
			long totalDays = 0;
			
			for(int y=1; y<year; y++) {
				if (isLeap(y)) {
					totalDays += 366;
				} else {
					totalDays += 365;}
			}
			
			for(int m=1; m<month; m++) {
				totalDays += daysInMonth[m];
				
				if (m==2 && isLeap(m)) {
					totalDays += 1;
				}
			}
			
			totalDays += day;
			
			int indexDay = (int) (totalDays % 7);
			
			return daysOfWeek[indexDay];
		}
		
	public static void main(String[] args) {
		
//		int day = 12; 
//		int month =7;
//		int year = 1998;
//		
//		System.out.println("Day for given date is : " + getDayOfWeek( year,  month , day));

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter year");
		int year = sc.nextInt();
		System.out.println("Enter month");
		int month = sc.nextInt();
		System.out.println("Enter day");
		int day = sc.nextInt();
		
//		int year = a;
//		int month = b;
//		int day = c;
//		
		getDayFromDate display = new getDayFromDate();
		System.out.println(display.getDayOfWeek(year, month, day));
		
		
	}

		}

