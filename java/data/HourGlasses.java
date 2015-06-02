package data;

import java.util.Scanner;

public class HourGlasses {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[][] arrIn = new int[6][6];
		for(int i = 0; i < arrIn.length; i++){
			for(int j = 0; j < arrIn[i].length; j++){
				arrIn[i][j] = input.nextInt();
			}
		}
		input.close();
		int maxHourGlassSum = Integer.MIN_VALUE;
		for(int i = 0; i < arrIn.length; i++){
			for(int j = 0; j < arrIn[i].length; j++){
				if(checkIfIndexValid(arrIn, i, j)){
					int tmpSum = calcSumHourGlass(arrIn, i, j);
					if(tmpSum > maxHourGlassSum){
						maxHourGlassSum = tmpSum;
					}
				}
			}
		}
		System.out.println(maxHourGlassSum);
		
	}

	public static int calcSumHourGlass(int[][] arrIn, int i, int j) {
		int res = 0;
		int x = i, y = j;
		for(;y <= j+2; y++){
			res += arrIn[x][y];
		}
		x = i + 1;
		y = j + 1;
		res += arrIn[x][y];
		for(x = i+2,y=j;y <= j+2; y++){
			res += arrIn[x][y];
		}
		return res;
	}

	private static boolean checkIfIndexValid(int[][] arrIn, int i, int j) {
		int x_len = arrIn.length;
		int y_len = arrIn[0].length;
		if(i > x_len - 3 || j > y_len - 3)
			return false;
		return true;
	}

}
