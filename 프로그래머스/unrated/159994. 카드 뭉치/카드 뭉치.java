import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        int one = 0;
        int two = 0;
        
        for(int i = 0 ; i < goal.length ; i++) {
            String target = goal[i];
            
            if(one < cards1.length && cards1[one].equals(target)) {
                one++;
            } else if(two < cards2.length && cards2[two].equals(target)) {
                two++;
            } else {
                return "No";
            }
        } 
        
        return "Yes";
    }
}