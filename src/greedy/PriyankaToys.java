package greedy;

import java.util.Scanner;

public class PriyankaToys {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int numToys = stdin.nextInt();
		int[] weights = new int[numToys];
		for(int i = 0;i<numToys; i++){
			weights[i] = stdin.nextInt();
		}
		stdin.close();
		quicksort(weights,0,numToys - 1);
		findUnits(weights);
	}

	private static void findUnits(int[] arr) {
		int units = 0;
		int currWt = 0;
		for(int i = 0; i<arr.length;i++){
			if(units == 0){
				units++;
				currWt = arr[i];
				continue;
			}
			if(arr[i] > currWt+4){
				units++;
				currWt = arr[i];
			}
		}
		System.out.println(units);
	}

	private static void quicksort(int[] arr, int low, int high) {
		if(low < high){
			int pivot = partition(arr, low, high);
			quicksort(arr, low, pivot - 1);
			quicksort(arr, pivot + 1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int mid = (low+high)/2;
		int pivotValue = arr[mid];
		//swap pivot value with high
		int temp = arr[mid];
		arr[mid] = arr[high];
		arr[high] = temp;
		
		int index = low;
		for(int i = low; i<=high -1;i++){
			if(arr[i] < pivotValue){
				temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
				index++;
			}
		}
		temp = arr[index];
		arr[index] = arr[high];
		arr[high] = temp;
		return index;
	}

}
