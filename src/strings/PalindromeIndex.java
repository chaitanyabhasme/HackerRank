package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeIndex {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			int cases = Integer.parseInt(br.readLine());
			checkInput(cases, 1, 20);
			String[] input = new String[cases];
			for(int i=0;i<cases;i++){
				input[i] = br.readLine();
				checkInput(input[i].length(),1,100005);
			}
			for(int i=0;i<cases;i++){
				System.out.println(palindromeIndex(input[i]));
			}
		}
		catch(IOException e){
			System.out.println("unable to read the input");
			System.exit(1);
		}
	}

	private static int palindromeIndex(String string) {
		int index = 0;
		if(checkPalindrome(string))
			return -1;
		if(checkPalindrome(string.substring(1)))
			return 0;
		int endIndex = string.length();
		for(index = 1; index < string.length(); index++){
			String tempStr = string.substring(0, index) + string.substring(index+1, endIndex);
			if(checkPalindrome(tempStr))
				return index;
		}
		return -1;
	}

	public static boolean checkPalindrome(String str){
		int len = str.length();
		int last = len - 1;
		for(int i = 0; i <= len/2 && i < last; i++){
			if(str.charAt(i) != str.charAt(last))
				return false;
			last--;
		}
		return true;
	}
	public static void checkInput(int num, int min, int max){
		if(num < min || num > max)
			System.exit(1);
	}
}
