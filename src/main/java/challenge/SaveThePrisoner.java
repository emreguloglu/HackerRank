package challenge;

import java.io.IOException;
import java.util.Scanner;

public class SaveThePrisoner {

	static int saveThePrisoner(int n, int m, int s) {
		int result = 0;
		
		// remaining sugar
		int mod = m % n;
		
		// if sugar equals to prisoner it returns 1 chair back since round table
		if(mod == 0) {
			if(s == 1) {
				return n;
			} else {
				return s - 1;
			}
		}
		
		// sum of remaining sugar and chair count gives where distribution ends
		result = mod + s - 1;
		
		// if sugar count exceeds chair count
		if(result > n) {
			result -= n;
		}
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String[] nms = scanner.nextLine().split(" ");

			int n = Integer.parseInt(nms[0]);
			int m = Integer.parseInt(nms[1]);
			int s = Integer.parseInt(nms[2]);
			int result = saveThePrisoner(n, m, s);
			System.out.println(result);
		}

		scanner.close();
	}
}
