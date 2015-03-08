package bitmanipulation;

import java.util.Scanner;

public class SansaXOR {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		int[] result = new int[testCases];
		for(int i = 0; i < testCases; i++){
			int arrSize = input.nextInt();
			int[] arr = new int[arrSize];
			for(int s = 0; s < arrSize; s++){
				arr[s] = input.nextInt();
			}
			result[i] = getXORoutput(arr);
		}
		input.close();
		for(int i = 0; i < testCases; i++){
			System.out.println(result[i]);
		}
	}

	private static int getXORoutput(int[] arr) {
		int res = 0;
		int len = arr.length;
		if(len == 1){
			return arr[0];
		}
		if(len % 2 == 0){
			return 0;
		}
		else{
			for(int i = 0; i < len; i = i + 2){
				res = res ^ arr[i];
			}
		}
		return res;
	}
}
