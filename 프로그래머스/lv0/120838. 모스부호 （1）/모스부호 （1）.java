import java.util.*;

class Solution {
    public String solution(String letter) {
        String answer = "";
        String[] strArr = letter.split(" ");
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        for(int i=0 ; i < strArr.length ; i++) {
            for(int j=0 ; j < codes.length ; j++) {
                if(strArr[i].equals(codes[j])) {
                    answer += (char)('a' + j);
                }
            }
        }
        
        return answer;
    }
}