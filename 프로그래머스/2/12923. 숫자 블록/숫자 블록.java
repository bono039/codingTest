import java.util.*;

class Solution {
    static final int MAX = 10_000_000;
    
    public List<Integer> solution(long begin, long end) {
        List<Integer> answer = new ArrayList<>();
        
        for(long i = begin ; i <= end ; i++) {
            if(i == 1) {
                answer.add(0);
                continue;
            }
            answer.add((int)getGCD(i));
        }
        
        return answer;
    }
    
    private static long getGCD(long x) {
        long result = 1;
        
        for(long i = 2 ; i <= Math.sqrt(x) ; i++) {
            if(x % i == 0) {
                result = i;
                
                if(x/i <= MAX) {
                    result = x/i;
                    break;
                }
            }                
        }
        
        return result;
    }
}