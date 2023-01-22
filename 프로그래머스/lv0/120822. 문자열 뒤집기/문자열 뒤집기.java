import java.util.Arrays;

class Solution {
    public String solution(String my_string) {
        // 배열 생성 (문자열 길이)
        char[] arr = new char[my_string.length()];
        
        for(int i = 0 ; i < my_string.length()  ; i++) {
            arr[my_string.length() - i - 1] = my_string.charAt(i);
        }
        
        return String.valueOf(arr);
    }
}