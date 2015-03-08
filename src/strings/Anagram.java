package strings;

import java.util.Scanner;

public class Anagram {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		String[] allString = new String[testCases];
		for(int i = 0; i < testCases; i++){
			allString[i] = input.next();
		}
		for(int i = 0; i < testCases; i++){
			System.out.println(findAnagramChar(allString[i]));
		}
		input.close();
	}

	private static int findAnagramChar(String string) {
		int len = string.length();
		if((len % 2) != 0){
			return -1;
		}
		int res = 0;
		String str1 = string.substring(0, len/2);
		String str2 = string.substring(len/2,len);
		int[] hash = new int[26];
		for(int i = 0; i < str1.length(); i++){
			hash[str1.charAt(i) - 97]++;
		}
		for(int i = 0; i < str2.length(); i++){
			if(hash[str2.charAt(i) - 97] > 0){
				hash[str2.charAt(i) - 97]--;
			}
			else{
				res++;
			}
		}
		return res;
	}

}
