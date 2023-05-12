import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        StringBuilder sb = new StringBuilder(a);
        
        for(int i = 0 ; i < a.length() ; i++) {
            char c = a.charAt(i);
            if('A' <= c && c <= 'Z') {
                sb.setCharAt(i, (char) (c + 32));
            }
            else if('a' <= c && c <= 'z') {
                sb.setCharAt(i, (char) (c - 32));
            }
        }
        System.out.println(sb.toString());
    }
}