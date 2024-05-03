import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        int[] arr = new int[100_000 + 1];
        for(String s : strArr) {
            arr[s.length()]++;
        }
        
        for(int i = 0 ; i < arr.length ; i++) {
            answer = Math.max(answer, arr[i]);
        }
        return answer;
    }
}