import java.util.*;
import java.io.*;

class Solution {
    public int solution(String num_str) {
        
        char[] ch = num_str.toCharArray();
        int answer = 0;
        
        for(int i = 0 ; i < ch.length ; i++) {
            answer += ch[i] - '0';
        }
        
        return answer;
    }
}