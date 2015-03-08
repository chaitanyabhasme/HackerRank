package warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class IsFibo {
    private static BigDecimal one = BigDecimal.valueOf(1);
    private static BigDecimal two = BigDecimal.valueOf(2);
    public static boolean isPerfectSquare(BigDecimal num) {
    	BigDecimal squareRoot = one;
    	BigDecimal square = one;
    	BigDecimal i = one;
    	BigDecimal newSquareRoot;
    	int comparison = -1;
    	while (comparison != 0) {
    		if (comparison < 0) {
    			i = i.multiply(two);
    			newSquareRoot = squareRoot.add(i).setScale(0, RoundingMode.HALF_UP);
    		} else {
    			i = i.divide(two);
    			newSquareRoot = squareRoot.subtract(i).setScale(0, RoundingMode.HALF_UP);
    		}
    		if (newSquareRoot.compareTo(squareRoot) == 0) {
    			return false;
    		}
    		squareRoot = newSquareRoot;
    		square = squareRoot.multiply(squareRoot);
    		comparison = square.compareTo(num);
    	}
    	return true;
    }

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		long[] allNums = {0};
		try{
			num = Integer.parseInt(br.readLine().toString());
			if(num < 1 || num > 100000){
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
			long n = allNums[i];
			if(isPerfectSquare(BigDecimal.valueOf(5*n*n + 4))){
				System.out.println("IsFibo");
			}
			else if(isPerfectSquare(BigDecimal.valueOf(5*n*n - 4))){
				System.out.println("IsFibo");
			}
			else{
				System.out.println("IsNotFibo");
			}
		}
	}

}
