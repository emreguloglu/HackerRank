package challenge;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Palindrome {

	private static Queue<Character> q = new LinkedList<>();
	private static Deque<Character> s = new LinkedList<>();

	private static void pushCharacter(char c) {
		s.push(c);
	}

	private static void enqueueCharacter(char c) {
		q.add(c);
	}

	private static Object dequeueCharacter() {
		return q.remove();
	}

	private static Object popCharacter() {
		return s.pop();
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String word = input.nextLine();
		char[] c = word.toCharArray();

		for (char a : c) {
			pushCharacter(a);
			enqueueCharacter(a);
		}

		boolean isPalindrome = true;
		for (int i = 0; i < q.size(); i++) {
			if (dequeueCharacter() != popCharacter()) {
				isPalindrome = false;
			}
		}

		System.out.println(isPalindrome);

		input.close();
	}

}
