package combinatorics;

import java.util.Scanner;

public class PickingCards {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		int[] result = new int[testCases];
		for(int i = 0; i < testCases;i++){
			int arrSize = input.nextInt();
			int[] arr = new int[arrSize];
			for(int j = 0; j < arrSize; j++){
				arr[j] = input.nextInt();
			}
			result[i] = calcPickingWays(arr);
		}
		input.close();
		for(int res: result){
			System.out.println(res);
		}
	}

	private static int calcPickingWays(int[] arr) {
		int size = arr.length;
		int[] cntArray = new int[size+1];		//we will calculate the count of each card in this array
		for(int i = 0; i < size; i++){
			cntArray[arr[i]]++;
		}
		int totalCardsPicked = 0;
		long ways = 1;
		int modWith = 1000000007;
		for(int i = 0; i < size+1; i++){
			if(i <= totalCardsPicked && cntArray[i] > 0){
				ways *= cntArray[i];
				ways %= modWith;
				cntArray[i]--;
				if((i < size) && (cntArray[i] >0)){
					cntArray[i+1] += cntArray[i];
				}
				totalCardsPicked++;
			}
		}
		if(totalCardsPicked < size)
			ways = 0;
		return (int)ways;
	}

}
