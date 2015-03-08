package warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FlippingBits {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arraySize;
		int[] arr;
		
		try {
			arraySize = Integer.parseInt(br.readLine());
			if(arraySize < 1 || arraySize >= 100)
				System.exit(1);
			
			arr = new int[arraySize];
			for(int i = 0; i < arraySize;i ++){
				arr[i] = Integer.parseInt(br.readLine());
				System.out.println(flipBits2(arr[i], 32));
			}
			
		} catch (NumberFormatException e) {
			System.out.println("Number format Exception");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("IO Exception");
			System.exit(0);
		}
	}
	public static int flipBits2(int n, int k) {
	    int mask = (1 << k) - 1;
	    return ~n & mask;
	}

}
