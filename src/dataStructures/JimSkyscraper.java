package dataStructures;

import java.util.Hashtable;
import java.util.Scanner;

public class JimSkyscraper {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[] inArr = new int[num];
		for(int i = 0; i < num; i++){
			inArr[i] = input.nextInt();
		}
		input.close();
		System.out.println(2*calculateValidPaths(inArr));
	}

	public static long calculateValidPaths(int[] arr) {
		long res = 0;
		int maxHeight = -1;
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
		for(int elem : arr){
			if(elem >= maxHeight && maxHeight != -1){
				if(elem > maxHeight){
					table.clear();
					maxHeight = -1;
				}
				else{
					int val = table.get(elem) + 1;
					table.clear();
					table.put(elem, val);
					res += val;
					continue;
				}
			}
			if(maxHeight == -1){
				maxHeight = elem;
			}
			if(table.containsKey(elem)){
				int val = table.get(elem)+1;
				table.put(elem,val);
				res += val;
			}
			else{
				table.put(elem, 0);
			}
		}
		return res;
	}
}
