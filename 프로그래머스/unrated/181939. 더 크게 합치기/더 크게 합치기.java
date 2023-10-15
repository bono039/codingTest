import java.util.*;

class Solution {
    public int solution(int a, int b) {
        String s1 = Integer.toString(a);
        String s2 = Integer.toString(b);
        
        int tmp1 = Integer.parseInt(s1+s2);
        int tmp2 = Integer.parseInt(s2+s1);
                
        return tmp1 >= tmp2 ? tmp1 : tmp2;
    }
}