package challenge;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MagicSquare {

	static int formingMagicSquare(int[][] s) {
		List<Integer> costs = new ArrayList<>();
		List<int[][]> magicList = generateAllSquares();
		int cost = 0;
		
		// Calculate lowest cost by comparing all generated squares 
		for (int[][] e : magicList) {
			for (int i = 0; i < s.length; i++) {
				for (int j = 0; j < s[0].length; j++) {
					cost += Math.abs(s[i][j] - e[i][j]);
				}
			}
			costs.add(cost);
			cost = 0;
		}
		return Collections.min(costs);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int[][] s = new int[3][3];

		for (int i = 0; i < 3; i++) {
			String[] sRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 3; j++) {
				int sItem = Integer.parseInt(sRowItems[j]);
				s[i][j] = sItem;
			}
		}

		int result = formingMagicSquare(s);
		System.out.println(result);
		scanner.close();
	}

	// Generate first magic square
	public static int[][] magicSquare() {
		int square = 3;
		int[][] magicSquare = new int[square][square];
		int element = 1;
		int i = 0;
		int j = square / 2;
		int tempI = 0;
		int tempJ = 0;

		while (element <= Math.pow(square, 2)) {
			magicSquare[i][j] = element;
			element++;
			tempI = (i - 1) % square;
			if (tempI < 0) {
				tempI += square;
			}
			tempJ = (j + 1) % square;
			if (magicSquare[tempI][tempJ] == 0) {
				i = tempI;
				j = tempJ;
			} else {
				i++;
			}
		}
		return magicSquare;
	}

	// Rotate square by 90 degree in clockwise direction
	static int[][] rotateClockwise(int[][] s) {
		int rowNum = s.length;
		int colNum = s[0].length;

		int[][] temp = new int[rowNum][colNum];
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < colNum; j++) {

				temp[i][j] = s[rowNum - j - 1][i];
			}
		}
		return temp;
	}

	// Generate new square by reflecting
	public static int[][] reflect(int[][] s) {
		int[][] temp = Arrays.stream(s).map(int[]::clone).toArray(int[][]::new);
		int size = temp.length;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size - i; j++) {
				int tmp = temp[i][j];
				temp[i][j] = temp[size - j - 1][size - i - 1];
				temp[size - j - 1][size - i - 1] = tmp;
			}
		}
		return temp;
	}

	// Perform all generate functions
	public static List<int[][]> generateAllSquares() {
		List<int[][]> magicList = new ArrayList<>();
		int[][] magicSquare = magicSquare();
		int[][] rotated90Square = rotateClockwise(magicSquare);
		int[][] rotated180Square = rotateClockwise(rotated90Square);
		int[][] rotated270Square = rotateClockwise(rotated180Square);
		int[][] reflectSquare = reflect(magicSquare);
		int[][] reflect90Square = reflect(rotated90Square);
		int[][] reflect180Square = reflect(rotated180Square);
		int[][] reflect270Square = reflect(rotated270Square);
		magicList.add(magicSquare);
		magicList.add(rotated90Square);
		magicList.add(rotated180Square);
		magicList.add(rotated270Square);
		magicList.add(reflectSquare);
		magicList.add(reflect90Square);
		magicList.add(reflect180Square);
		magicList.add(reflect270Square);
		return magicList;
	}
}
