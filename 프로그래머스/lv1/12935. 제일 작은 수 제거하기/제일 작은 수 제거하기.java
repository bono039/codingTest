import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        // 배열 길이가 1인 경우
        if(arr.length == 1) {
            int[] answer = {-1};
            return answer;
        }
        
        // 그게 아닌 경우
        int[] answer = new int[arr.length - 1];
        int min = arr[0];
        for(int i : arr) {
            min = Math.min(min, i);
        }
        
        
        int idx = 0;
        
        for(int i=0 ; i < arr.length ; i++) {
            if(arr[i] == min) {
                continue;
            }
            
            answer[idx++] = arr[i];
        }
        
        return answer;
    }
}