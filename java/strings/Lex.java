package strings;

import java.util.Scanner;

public class Lex {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.next();
		int len = input.nextInt();
		input.close();
		findLexMinMax(str,len);
	}

	public static void findLexMinMax(String str, int len) {
		String min = null;
		String max = null;
		for(int i = 0; i+len <= str.length(); i++){
			String sub = str.substring(i, i+len);
			if(min == null || sub.compareTo(min)<0){
				min = sub;
			}
			if(max == null || sub.compareTo(max) > 0){
				max = sub;
			}
		}
		System.out.println(min);
		System.out.println(max);
	}
}
