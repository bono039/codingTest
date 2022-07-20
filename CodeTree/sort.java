import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        str = sc.next();
        
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        
        String sortedStr = new String(chars);
        System.out.println(sortedStr);

    }
}
