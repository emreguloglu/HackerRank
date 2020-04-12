package challenge;

import java.io.IOException;
import java.util.Scanner;

public class CountingValleys {

	static int countingValleys(int n, String s) {
		int counter = 0;
		int valleyCounter = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'U') {
				counter++;
			} else {
				counter--;
				if (counter == -1) {
					valleyCounter++;
				}
			}
		}
		return valleyCounter;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		String s = scanner.nextLine();
		int result = countingValleys(n, s);
		System.out.println(result);
		scanner.close();
	}
}
