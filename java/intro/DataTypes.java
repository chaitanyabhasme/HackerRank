package intro;

import java.util.Scanner;

public class DataTypes {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		String[] arr = new String[testCases];
		String[] types = new String[testCases];
		for(int i = 0; i < testCases; i++){
			if(input.hasNextByte()){
				arr[i] = input.next();
				types[i] = "byte";
				continue;
			} else if(input.hasNextShort()){
				arr[i] = input.next();
				types[i] = "short";
				continue;
			} else if(input.hasNextInt()){
				arr[i] = input.next();
				types[i] = "int";
				continue;
			} else if(input.hasNextLong()){
				arr[i] = input.next();
				types[i] = "long";
				continue;
			}
			else{
				arr[i] = input.next();
				types[i] = "NaN";
			}
		}
		input.close();
		printResult(arr, types);
		
	}
	
	public static void printResult(String[] arr, String[] typeArr){
		for(int i = 0; i < typeArr.length; i++){
			if(typeArr[i].equals("NaN")){
				System.out.println(arr[i] + " can't be fitted anywhere.");
			}
			else{
				System.out.println(arr[i] + " can be fitted in:");
				printAllTypes(typeArr[i]);
			}
		}
	}

	public static void printAllTypes(String string) {
		switch(string){
			case "byte":
				System.out.println("* byte");
			case "short":
				System.out.println("* short");
			case "int":
				System.out.println("* int");
			case "long":
				System.out.println("* long");
		}
	}
}
