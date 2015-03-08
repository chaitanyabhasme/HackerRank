package combinatorics;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConnectingTowns {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			int testCases = Integer.parseInt(br.readLine());
			checkInput(testCases, 1, 1000);
			long[] result = new long[testCases];
			for(int i = 0; i < testCases; i++){
				int towns = Integer.parseInt(br.readLine());
				checkInput(towns, 3, 100);
				int[] routes = new int[towns - 1];
				String[] inputRoutes = br.readLine().split(" ");
				for(int k = 0; k < (towns - 1); k++){
					routes[k] = Integer.parseInt(inputRoutes[k]);
					checkInput(routes[k], 1, 1000);
				}
				long res = 1;
				for(int k = 0; k < (towns - 1); k++){
					res = (res * routes[k])%1234567;
				}
				result[i] = (res % 1234567);
			}
			for(int i = 0; i < testCases; i++){
				System.out.println(result[i]);
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
