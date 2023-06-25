import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] num_list) {
        int holSum = 0;
        int jakSum = 0;
        
        for(int i = 0 ; i < num_list.length ; i++) {
            if(i % 2 == 0) {
                jakSum += num_list[i];
            } else {
                holSum += num_list[i];
            }
        }
        
        return holSum > jakSum ? holSum : jakSum;
    }
}