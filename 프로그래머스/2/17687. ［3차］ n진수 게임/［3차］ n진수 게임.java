import java.util.*;

class Solution {    
    public String solution(int n, int t, int m, int p) {
        
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        
        int num = 0;
        
        while(sb.length() < m * t) {            
            sb.append(Integer.toString(num++, n));
        }
        
        for(int i = p - 1 ; i < m * t ; i += m) {
            ans.append(sb.charAt(i));
        }
        
        return ans.toString().toUpperCase();
    }
}