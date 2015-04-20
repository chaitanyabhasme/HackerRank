package strings;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

public class SherlockAnagrams {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		String[] inStrs = new String[testCases];
		for (int i = 0; i < testCases; i++) {
			inStrs[i] = input.next();
		}
		input.close();
		for (int i = 0; i < testCases; i++) {
			System.out.println(calcUnorderedAnagrams(inStrs[i]));
		}
	}

	public static int calcUnorderedAnagrams(String string) {
		int totalAnagrams = 0;
		int size = fact(string.length());
		 Hashtable<String, Integer> allStrs = new Hashtable<String, Integer>(size);
		for (int i = 1; i <= string.length(); i++) {
			for (int j = 0; j + i <= string.length(); j++) {
				String str = string.substring(j, j + i);
				if(str.length() > 1 && str.length() < string.length()){
					//sort the sub-string. For efficiency no need to sort if the substring is the original string itself
					char[] charArray = str.toCharArray();
					Arrays.sort(charArray);
					str = new String(charArray);
				}
				if(allStrs.containsKey(str)){
					//sub string string already present 
					int value = allStrs.get(str);
					totalAnagrams += value;
					allStrs.put(str, ++value);
				}
				else{
					allStrs.put(str, 1);
				}				
			}
		}
		return totalAnagrams;
	}

	// factorial function to calculate the required size of the hashtable
	public static int fact(int num) {
		int ret = 1;
		while (num > 1) {
			ret = ret * num;
			num -= 1;
		}
		return ret;
	}
}
