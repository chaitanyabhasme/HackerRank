package warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class First {
	
	public static int addSol(int a, int b){
		return a+b;
	}
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int a = Integer.parseInt(br.readLine().toString());
			int b = Integer.parseInt(br.readLine().toString());
			System.out.println(addSol(a,b));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
