package combinatorics;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HandShake {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			int testCases = Integer.parseInt(br.readLine());
			checkInput(testCases, 1, 1000);
			long[] input = new long[testCases];
			for(int i = 0; i < testCases; i++){
				input[i] = Long.parseLong(br.readLine());
				checkInput((int)input[i], 1, 1000000 - 1);
			}
			for(int i = 0; i < testCases; i++){
				long totalHandShakes = (input[i] * (input[i]-1))/2;
				System.out.println(totalHandShakes);
			}
		}catch(Exception e){
			System.out.println("Unable to read the input!");
			System.exit(1);
		}
	}

	public static void checkInput(int num, int min, int max){
		if(num < min || num > max)
			System.exit(1);
	}
}
