import java.util.*;

class Solution {    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0 ; i < n ; i++) {
            StringBuilder sb = new StringBuilder();
            int num = arr1[i] | arr2[i];    // OR 연산하기
            
            String bin = Integer.toString(num, 2);    // 이진 문자열 얻기
            for(int j = 0 ; j < n - bin.length() ; j++) {   // 자릿수 모자라면 앞을 0으로 채우기
                sb.append(" ");
            }
            
            for(char ch : bin.toCharArray()) {
                sb.append(ch == '0' ? ' ' : '#');
            }
            
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}