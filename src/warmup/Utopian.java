package warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utopian {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arraySize;
		try {
			arraySize = Integer.parseInt(br.readLine());
			if(arraySize < 1 || arraySize > 10){
				System.exit(1);
			}
			int[] arr = convertToIntArray(br, arraySize);
			for(int i = 0; i < arraySize; i++){
				int ans = 1;
				for(int j = 1; j <= arr[i]; j++){
					if(j%2 == 0){
						ans = ans + 1;
					}
					else
						ans = ans*2;
				}
				System.out.println(ans);
			}
		} catch (NumberFormatException e) {
			System.out.println("Number format exception.");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("IO exception.");
			System.exit(1);
		}
	}

	private static int[] convertToIntArray(BufferedReader br, int arraySize) {
		int[] newArray = new int[arraySize];
		for(int i = 0;i < arraySize; i++){
			try {
				newArray[i] = Integer.parseInt(br.readLine());
				if(newArray[i] < 0 || newArray[i] > 60){
					System.exit(1);
				}
			} catch (NumberFormatException e) {
				System.out.println("Number format exception.");
				System.exit(1);
			} catch (IOException e) {
				System.out.println("IO exception.");
				System.exit(1);
			}
		}
		return newArray;
	}
}
