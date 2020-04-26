package challenge;

import java.io.IOException;
import java.util.Scanner;

public class FindDigits {

	// Complete the findDigits function below.
	static int findDigits(int n) {
		int number = n;
		int remainder = 0;
		int counter = 0;
		while (number > 0) {
			remainder = number % 10;
			number /= 10;
			if (remainder != 0 && n % remainder == 0) {
				counter++;
			}
		}
		return counter;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int result = findDigits(n);
			System.out.println(result);
		}
		scanner.close();
	}
}
