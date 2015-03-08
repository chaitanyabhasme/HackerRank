package soringandarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Insertion1 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arraySize;
		int[] arr;
		try{
			arraySize = Integer.parseInt(br.readLine().toString());
			arr = convertToIntArray(br.readLine(),arraySize);
			insertIntoSorted(arr);
		}
		catch(IOException e){
			System.out.println("Error reading the input!");
			System.exit(1);
		}
	}
	private static void printArray(int[] ar) {
		for(int n: ar){
			System.out.print(n+" ");
		}
		System.out.println("");
	}
	private static int[] convertToIntArray(String readLine, int size) {
		String[] data = readLine.split(" ");
		int[] retArray = new int[size];
		for(int i = 0; i < size; i++){
			retArray[i] = Integer.parseInt(data[i]);
		}
		return retArray;
	}
	public static void insertIntoSorted(int[] ar) {
		// Fill up this function
		int size = ar.length;
		int n = ar[size - 1];
		for(int i = size - 1; i >= 0; i--){
			if(i == 0 && ar[i] > n){
				ar[i] = n;
				printArray(ar);
				break;
			}
			if(ar[i - 1] > n){
				ar[i] = ar[i-1];
				printArray(ar);
			}
			else{
				ar[i] = n;
				printArray(ar);
				break;
			}
		}
	}
}
