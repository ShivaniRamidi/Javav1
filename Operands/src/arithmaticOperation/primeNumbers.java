package arithmaticOperation;

import java.util.Scanner;

public class primeNumbers {
	int num;
	public static boolean isPrime(int num) {
		
		if (num <= 1) {
		return false;
		}
		if (num <= 3) {
			return true;
			}
		if (num % 2 ==0 || num % 3 ==0) {
			return false;
		}
		for (int i = 5; i * i <= num; i = i + 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
		return true;
		}
		return true;
		
	}
		public static void main (String[] args) {
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Enter a number: ");
			int numToCheck = scanner.nextInt();
			
			if (isPrime(numToCheck)) {
				System.out.println(numToCheck + " is prime number.");
			} else { System.out.println(numToCheck + " is not a prime number.");}
		}
	}

