import java.util.*;

class Solution {    
    public int solution(int[] num_list) {        
        int multiple = 1;
        for(int i : num_list) {
            multiple *= i;
        }
        
        int sum = 0;
        for(int i : num_list) {
            sum += i;
        }
        sum *= sum;
        
        return multiple < sum ? 1 : 0;
    }
}