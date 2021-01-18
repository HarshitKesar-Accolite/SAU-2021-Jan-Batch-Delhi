package q2;

import java.util.Scanner;

public class ExceptionExample {
	
	static double divide(int dividend, int divisor) throws ArithmeticException{
		if(divisor == 0) {
			throw new ArithmeticException();
		}
		return dividend/divisor;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double result = 0;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter the Dividend : ");
		int dividend = sc.nextInt();
		System.out.print("\nEnter the Divisor : ");
		int divisor = sc.nextInt();
		try {
			result = divide(dividend, divisor);
		}
		catch(ArithmeticException e) {
			System.out.println(e);
		}
		System.out.println(result);
	}

}
