import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        char tmp;
        
        for(int i = 0 ; i < my_string.length() ; i++) {
            
            tmp = my_string.charAt(i); /// 아스키 코드
            
            if((65 <= tmp) && (tmp <= 90)) {        // 대문자인 경우
                answer += my_string.valueOf(tmp).toLowerCase();
            } else if((97 <= tmp) && (tmp <= 122)) {// 소문자
                answer += my_string.valueOf(tmp).toUpperCase();
            } else {
                answer += (char)tmp;
            }
        }
        return answer;
    }
}