package strings;

import java.util.Scanner;

public class BiggerIsGreater {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		String[] allStr = new String[testCases];
		for(int i = 0; i<testCases; i++){
			allStr[i] = input.next();
		}
		input.close();
		for(int i = 0; i<testCases; i++){
			findLexNext(allStr[i]);
		}
	}

	private static void findLexNext(String string) {
		char[] arr = string.toCharArray();
		int i;
		for(i = arr.length - 1; i > 0; i--){
			if(arr[i] <= arr[i - 1])
				continue;
			else
				break;
		}
		if(i == 0){
			System.out.println("no answer");
			return;
		}
		else{
			if(arr.length == 2){
				System.out.println(arr[1] + "" + arr[0]);
				return;
			}
			int pivot = i - 1;
			int j;
			for(j = arr.length - 1; j >= i; j--){
				if(arr[j] > arr[pivot])
					break;
			}
			//swap
			char temp = arr[pivot];
			arr[pivot] = arr[j];
			arr[j] = temp;
			String res = "";
			for(j = 0; j <= pivot; j++){
				res = res + arr[j];
			}
			for(j = arr.length - 1; j > pivot; j--){
				res = res + arr[j];
			}
			System.out.println(res);
		}
	}
}
