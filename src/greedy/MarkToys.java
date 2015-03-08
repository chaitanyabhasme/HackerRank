package greedy;

import java.util.Scanner;

public class MarkToys {

	public static void main(String[] args) {
		Scanner stdin=new Scanner(System.in);
        int n=stdin.nextInt();
        int k=stdin.nextInt();
        int prices[]=new int[n];
        for(int i=0;i<n;i++){ 
        	prices[i]=stdin.nextInt();
        }
        quicksort(prices, 0, n-1);
		findToys(prices, k);
		stdin.close();
	}
	
	private static void findToys(int[] prices, int limit) {
		int cnt = 0;
		long bought = 0;
		int len = prices.length;
		for(int i = 0; i < len; i++){
			if(bought + prices[i] > limit)
				break;
			else{
				cnt++;
				bought = bought + prices[i];
			}
		}
		System.out.println(cnt);
	}
	
	public static void quicksort(int[] arr, int low, int high){
		if(low < high){
			int pivot = parition(arr, low, high);
			quicksort(arr, low, pivot - 1);
			quicksort(arr, pivot + 1, high);
		}
	}

	public static int parition(int[] arr, int low, int high) {
		int mid = (low+high)/2;
		int pivotValue = arr[mid];
		//swap last element with the pivot element
		int temp = arr[high];
		arr[high] = arr[mid];
		arr[mid] = temp;
		
		int index = low;
		//compare index with pivot value
		for(int i = low;i<=high-1;i++){
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
	
	public static void checkInput(int num, int min, int max){
		if(num < min || num > max)
			System.exit(1);
	}
}
