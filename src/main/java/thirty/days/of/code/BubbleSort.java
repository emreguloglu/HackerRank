package challenge;

import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		bubbleSort(a);
		in.close();
	}

	private static void bubbleSort(int[] a) {
		int endPosition = a.length - 1;
		int swapIndex;
		int temp;
		int swapCounter = 0;
		while (endPosition > 0) {
			swapIndex = 0;
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] > a[i + 1]) {
					temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
					swapIndex = i;
					swapCounter++;
				}
			}
			endPosition = swapIndex;
		}
		System.out.println("Array is sorted in " + swapCounter + " swaps.");
		System.out.println("First Element: " + a[0]);
		System.out.println("Last Element: " + a[a.length - 1]);

	}
}
