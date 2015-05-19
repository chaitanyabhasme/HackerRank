package strings;

import java.util.Scanner;

public class MakeItAnagram {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str1 = input.next();
		String str2 = input.next();
		input.close();
		calcAnagramDeletion(str1,str2);
	}

	public static void calcAnagramDeletion(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		int[] cntArr = new int[26];
		for(int i = 0; i < len1; i++){
			cntArr[arr1[i] - 'a']++;
		}
		int res = 0;
		for(int i = 0; i < len2; i++){
			if(cntArr[arr2[i] - 'a'] > 0){
				cntArr[arr2[i] - 'a']--;
			}
			else{
				res++;
			}
		}
		for(int i : cntArr){
			res += i;
		}
		System.out.println(res);
	}

}
