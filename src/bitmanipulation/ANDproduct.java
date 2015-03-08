package bitmanipulation;

import java.util.Scanner;

public class ANDproduct {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		long[] result = new long[testCases];
		for(int i = 0 ;i < testCases ; i ++){
			long a = input.nextLong();
			long b = input.nextLong();
			result[i] = getANDproduct(a,b);
		}
		input.close();
		for(int i = 0 ;i < testCases ; i ++){
			System.out.println(result[i]);
		}
	}

	private static long getANDproduct(long a, long b) {
		long diff = a - b + 1;
		if(diff < a){
			return a;
		}
		if(diff % 2 == 0){
			return a;
		}
		else
			return 0;
	}

}
