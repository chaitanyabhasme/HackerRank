package combinatorics;

import java.util.Scanner;

public class StrangeGrid {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int row = input.nextInt();
		int col = input.nextInt();
		input.close();
		long result = findElement(col,row);
		System.out.println(result);
	}

	public static long findElement(int col, int row) {
		long result = 0;
		if(row % 2 == 0){
			long rowFirstElem = (long)(row - 2)*5 + 1;
			result = rowFirstElem + 2*(col-1);
		}
		else{
			long rowFirstElem = (long)(row - 1)*5;
			result = rowFirstElem + 2*(col-1);
		}
		return result;
	}

}
