package dynamic;

/*
 * Given a list of n integers, A={a1,a2,…,an}, and another integer, k representing the expected sum. 
 * Select zero or more numbers from A such that the sum of these numbers is as near as possible, 
 * but not exceeding, to the expected sum (k).
 * 
 *  Note: Each element of A can be selected multiple times. If no element is selected then the sum is 0.
 *  
 *  INPUT:
 *  The first line contains T the number of test cases.
 *  Each test case comprises of two lines. First line contains two integers, n k, representing the length 
 *  of list A and expected sum, respectively. Second line consists of n space separated integers, 
 *  a1,a2,…,an, representing the elements of list A.
 *  
 *  OUTPUT:
 *  Output T lines, the answer for each test case.
 */
import java.util.Scanner;

public class KnapSack {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		int[] result = new int[testCases];
		for(int i = 0; i < testCases; i++){
			int arrLen = input.nextInt();
			int sum = input.nextInt();
			int[] arr = new int[arrLen];
			for(int j = 0; j < arrLen; j++){
				arr[j] = input.nextInt();
			}
			quickSort(arr, 0, arrLen - 1);
			result[i] = findTotalSumKnapsack(arr,sum);
		}
		input.close();
		for(int i = 0; i < testCases;i++){
			System.out.println(result[i]);
		}
	}

	private static int findTotalSumKnapsack(int[] arr, int sum) {
		if(sum < arr[0])
			return 0;			//if sum less than the first element in the sorted array return 0 as no solution is possible.
		int len = arr.length;
		int result  = 0;
		int diff = 999999;
		int[][] matrix = new int[len+1][sum+1];
		for(int i = 0; i<=len;i++){
			for(int w = 0; w<=sum; w++){
				if(i == 0 || w==0){
					matrix[i][w] = 0;
					continue;
				}
				int w_i = arr[i-1];
				if(w < w_i){
					matrix[i][w] = matrix[i-1][w];
				}
				else{
					matrix[i][w] = maxOfTwo(maxOfTwo(matrix[i-1][w], checkIfGreaterThanSum(w, matrix[i-1][w - w_i] + w_i)), checkIfGreaterThanSum(w, w_i * (w/w_i)));
					if((sum - matrix[i][w]) < diff){
						diff = sum - matrix[i][w];
						result = matrix[i][w];
					}
					if(result == sum)
						return result;		//most optimized solution, return if found.
				}
			}
		}
//		for(int i = 0; i<=len;i++){
//			for(int w = 0; w<=sum; w++){
//				System.out.format("%2d ",matrix[i][w]);
//			}
//			System.out.print("\n");
//		}
		return result;
	}
	
	public static int maxOfTwo(int a, int b){
		return (a>b) ? a: b;
	}
	public static int checkIfGreaterThanSum(int w, int w_i){
		if(w_i > w)
			return 0;
		else
			return w_i;
	}

	private static void quickSort(int[] arr, int low, int high) {
		if(low < high){
			int pivot = partition(arr,low,high);
			quickSort(arr,low,pivot - 1);
			quickSort(arr, pivot + 1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int mid = (low+high)/2;
		int pivotValue = arr[mid];
		int temp = arr[high];
		arr[high] = arr[mid];
		arr[mid] = temp;
		
		int index = low;
		for(int i = low; i <= (high - 1);i++){
			if(arr[i] < pivotValue){
				temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
				index++;
			}
		}
		temp = arr[high];
		arr[high] = arr[index];
		arr[index] = temp;
		return index;
	}

}
