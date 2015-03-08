package soringandarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchIndex {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arraySize;
		int searchNum;
		int[] arr;
		try{
			searchNum = Integer.parseInt(br.readLine().toString());
			arraySize = Integer.parseInt(br.readLine().toString());
			arr = convertToIntArray(br.readLine(),arraySize);
			System.out.println(searchIntoArray(arr, searchNum));
		}
		catch(IOException e){
			System.out.println("Error reading the input!");
			System.exit(1);
		}
	}

	private static int[] convertToIntArray(String readLine, int size) {
		String[] data = readLine.split(" ");
		int[] retArray = new int[size];
		for(int i = 0; i < size; i++){
			retArray[i] = Integer.parseInt(data[i]);
		}
		return retArray;
	}
	
	private static int searchIntoArray(int[] arr, int num){
		int retIndex = -1;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == num){
				retIndex = i;
				break;
			}
		}
		return retIndex;
	}
}
