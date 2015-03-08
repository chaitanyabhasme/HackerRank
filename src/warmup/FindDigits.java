package warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindDigits {

	public static int findDigits(long n){
		int res = 0;
		long n1 = n;
		while(n > 0){
			int temp = (int) (n % 10);
			if((temp != 0) && (n1%temp == 0))
				res++;
			
			n = n / 10;
		}
		return res;
	}
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		long[] allNums = {0};
		try{
			num = Integer.parseInt(br.readLine().toString());
			if(num < 1 || num > 15){
				System.exit(1);
			}
			allNums = new long[num];
			for(int i = 0; i < num; i++){
				allNums[i] = Long.parseLong(br.readLine().toString());
			}
		}catch(IOException e){
			System.out.println("Error reading the input!");
			System.exit(1);
		}
		for(int i = 0;i < allNums.length ;i++){
			System.out.println(findDigits(allNums[i]));
		}
	}

}
