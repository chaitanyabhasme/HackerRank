package strings;

import java.util.Scanner;
public class CommomChild {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str1 = input.next();
		String str2 = input.next();
		findLCS(str1,str2);
		input.close();
	}
	
	public static void findLCS(String s1, String s2){
		int m = s1.length()+1;
		int n = s2.length()+1;
		int[][] Cmat = new int[m][n];
		for(int i = 0;i < m; i++){
			Cmat[i][0] = 0;
		}
		for(int j = 0;j < n; j++){
			Cmat[0][j] = 0;
		}
		for(int i = 1;i < m; i++){
			for(int j = 1; j < n; j++){
				if(s1.charAt(i-1) == s2.charAt(j-1)){
					Cmat[i][j] = Cmat[i-1][j-1] + 1;
				}
				else{
					if(Cmat[i-1][j] >= Cmat[i][j-1]){
						Cmat[i][j] = Cmat[i-1][j];
					}
					else{
						Cmat[i][j] = Cmat[i][j-1];
					}
				}
			}
		}
		System.out.println(Cmat[m-1][n-1]);
	}
}
