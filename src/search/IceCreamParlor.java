package search;

import java.util.Scanner;

public class IceCreamParlor {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int testCases = stdin.nextInt();
		for(int i = 0; i <testCases; i++){
			int dollars = stdin.nextInt();
			int flavors = stdin.nextInt();
			int[] items = new int[flavors];
			for(int j = 0; j < flavors;j++){
				items[j] = stdin.nextInt();
			}
			findItems(items,dollars);
		}
		stdin.close();
	}

	private static void findItems(int[] items, int dollars) {
		int first = 0;
		int second = 0;
		
		for(int i = 0;i<items.length;i++){
			first = items[i];
			second = dollars - first;
			int index2 = binarySearch(items,second,i+1,items.length - 1);
			if(index2 != -1){
				System.out.println(i + " " + index2);
				return;
			}
		}
	}

	private static int binarySearch(int[] arr, int num, int low, int high) {
		if(arr[low] == num)
			return low;
		if(arr[high] == num)
			return high;
		if(low < high){
			int mid = (low+high)/2;
			if(arr[mid] == num)
				return mid;
			else if(num < arr[mid])
				return binarySearch(arr,num,low,mid-1);
			else
				return binarySearch(arr,num,mid+1,high);
		}
		return -1;
	}
}
