import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String[] str = Integer.toString(n, k).split("0");
                
        for(String s : str) {
            if(s.equals(""))    continue;
            
            if(isPrime(Long.parseLong(s)))
                answer++;
        }
        
        return answer;
    }
    
    private static boolean isPrime(long num) {
        if(num < 2)    return false;
        
        for(int i = 2 ; i <= Math.sqrt(num) ; i++) {
            if(num % i == 0)
                return false;
        }
        
        return true;
    }
}