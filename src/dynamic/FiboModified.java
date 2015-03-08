package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class FiboModified {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			String[] data = br.readLine().split(" ");
			int N = Integer.parseInt(data[2]);
			checkInput(N, 3, 20);
			int firstTerm = Integer.parseInt(data[0]);
			int secondTerm = Integer.parseInt(data[1]);
			checkInput(firstTerm, 0, 2);
			checkInput(secondTerm, 0, 2);
			BigInteger[] arr = new BigInteger[N];
			arr[0] = new BigInteger(data[0]);
			arr[1] = new BigInteger(data[1]);
			for(int i = 2; i < N; i++){
				arr[i] = arr[i-1].pow(2).add(arr[i-2]);
			}
			System.out.println(arr[N-1]);
			
		}catch(IOException e){
			System.out.println("Unable to read the Input");
			System.exit(0);
		}
	}
	
	public static void checkInput(int num, int min, int max){
		if(num < min || num > max)
			System.exit(1);
	}

}
