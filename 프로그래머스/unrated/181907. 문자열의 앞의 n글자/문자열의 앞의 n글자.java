import java.util.*;
import java.io.*;

class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        
        for(int i = 0 ; i < n ; i++) {
            answer += my_string.substring(i, i+1);
        }
        
        return answer;
    }
}