package data;

import java.util.Scanner;

public class Jumo {

	public static int[] visited;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		int[] result = new int[testCases];
		for (int i = 0; i < testCases; i++) {
			int n = input.nextInt();
			int m = input.nextInt();
			int[] arr = new int[n];
			visited = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = input.nextInt();
			}
			result[i] = calcIfValid(arr, m);
		}
		input.close();
		for (int i : result) {
			System.out.println(i > 0 ? "YES" : "NO");
		}
	}

	public static int calcIfValid(int[] arr, int m) {

		if (recValidation(arr, 0, m)) {
			return 1;
		} else {
			return 0;
		}
	}

	public static boolean recValidation(int[] arr, int index, int m) {

		if (index > arr.length - 1) {
			return true;
		}
		if (index < 0 || arr[index] == 1) {
			return false;
		}
		if (visited[index] == 1) {
			return false;
		}
		visited[index] = 1;
		int jump = isJumpPossible(arr, index, m);
		if (jump != -1) {
			return recValidation(arr, jump, m)
					|| recValidation(arr, index - 1, m)
					|| recValidation(arr, index + 1, m);
		} else {
			return recValidation(arr, index - 1, m)
					|| recValidation(arr, index + 1, m);
		}
	}

	public static int isJumpPossible(int[] arr, int index, int m) {
		int newIndex = index + m;
		if (newIndex > arr.length - 1 || arr[newIndex] == 0) {
			return newIndex;
		} else {
			return -1;
		}
	}
}
