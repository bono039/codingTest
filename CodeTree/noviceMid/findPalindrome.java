// 문제 : https://www.codetree.ai/missions/5/problems/find-the-number-of-palindrome?&utm_source=clipboard&utm_medium=text

import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int cnt = 0;
        for(int i = n ; i <= m ; i++) {
            if(isPalindrome(i)) {
                cnt++;
            }
        }
        
        System.out.println(cnt);
    }
 
    // 팰린드롬 판별 메소드
    private static boolean isPalindrome(int num) {
        String str = Integer.toString(num);
 
        for(int i = 0 ; i <= str.length() / 2 ; i++) {
            if(str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        }
        return true;
    }
}
