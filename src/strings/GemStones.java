package strings;

import java.util.Scanner;

public class GemStones {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int rocks = input.nextInt();
		String[] comp = new String[rocks];
		for(int i = 0; i<rocks;i++){
			comp[i] = input.next();
		}
		input.close();
		int res = 0;
		for(int i = 97; i <= 122; i++){
			char c = (char)i;
			int temp = 1;
			for(int j = 0; j < rocks; j++){
				if(comp[j].indexOf(c) == -1){
					temp = 0;
					break;
				}
			}
			if(temp == 1){
				res++;
			}
			
		}
		System.out.println(res);
	}

}
