package warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lonely {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arraySize;
		int[] arr;
		
		try {
			arraySize = Integer.parseInt(br.readLine());
			if(arraySize < 1 || arraySize >= 100)
				System.exit(1);
			
			arr = convertToIntArray(br.readLine(), arraySize);
			findLonelyInteger(arr,arraySize);
			
		} catch (NumberFormatException e) {
			System.out.println("Number format Exception");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("IO Exception");
			System.exit(0);
		}
	}

	private static void findLonelyInteger(int[] arr, int arraySize) {
		int lonely = 0;
		for(int i = 0; i < arraySize;i++){
			lonely = lonely ^ arr[i];
		}
		System.out.println(lonely);
	}

	private static int[] convertToIntArray(String readLine, int arraySize) {
		String[] data = readLine.split(" ");
		int[] newArray = new int[arraySize];
		for(int i = 0;i < arraySize; i++){
			newArray[i] = Integer.parseInt(data[i]);
			if(arraySize < 0 || arraySize > 100)
				System.exit(1);
		}
		return newArray;
	}
	
}
