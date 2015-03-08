package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pangram {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String sentence = br.readLine().replace(" ", "").toLowerCase();
			char[] charArr = sentence.toCharArray();
			if(checkPangram(charArr)){
				System.out.println("pangram");
			}
			else{
				System.out.println("not pangram");
			}
		} catch (IOException e) {
			System.out.println("Error Reading the INput!");
			System.exit(1);
		}
	}

	public static boolean checkPangram(char[] charArr) {
		int[] cntArray = new int[26];
		for(int i = 0; i<charArr.length;i++){
			cntArray[charArr[i] - 97] = 1;
		}
		for(int i = 0;i<26;i++){
			if(cntArray[i] != 1)
				return false;
		}
		return true;
	}

}
