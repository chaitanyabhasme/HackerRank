package data;

import java.util.Hashtable;
import java.util.Scanner;

public class PhoneBook {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int testCases = Integer.parseInt(input.nextLine());
        Hashtable<String, String> htable = new Hashtable<String, String>(testCases + 10);
        for(int i = 0 ; i < testCases; i++){
            String name = input.nextLine();
            String num = input.nextLine();
            htable.put(name, num);
        }
        while(input.hasNext()){
            String key = input.nextLine();
            if(htable.containsKey(key)){
                System.out.println(key + "=" + htable.get(key));
            }
            else{
                System.out.println("Not found");
            }
        }
    }
}
