import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        int len = nums.length;
        int answer = 0;
        
        for(int i = 0 ; i < len ; i++) {
            for(int j = i+1 ; j < len ; j++) {
                for(int k = j+1 ; k < len ; k++) {
                    int sum = nums[i] + nums[k] + nums[j];
                    answer += isPrime(sum) ? 1 : 0;          
                }
            }
        }
        
        return answer;
    }
    
    // 소수 여부 반환 메소드
    private boolean isPrime(int num) {
        for(int i=2 ; i<= Math.sqrt(num) ; i++) {
            if(num % i == 0)
                return false;
        }
        
        return true;
    }
}