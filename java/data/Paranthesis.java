package data;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Paranthesis {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			list.add(input.next());
		}
		input.close();
		for (String s : list) {
			System.out.println(checkIfBalanced(s));
		}
	}

	public static boolean checkIfBalanced(String s) {
		char[] arr = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for (char c : arr) {
			if (c == '{' || c == '[' || c == '(') {
				stack.add(c);
			} else {
				if (!stack.isEmpty()) {
					char tmp = stack.pop();
					if (tmp == '{' && c == '}') {
						continue;
					} else if (tmp == '[' && c == ']') {
						continue;
					} else if (tmp == '(' && c == ')') {
						continue;
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		}
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
