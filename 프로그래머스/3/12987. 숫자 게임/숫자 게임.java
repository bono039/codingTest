import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int idx = A.length - 1;
                
        Arrays.sort(A);
        Arrays.sort(B);
                
        for(int i = A.length - 1 ; i >= 0 ; i--) {
            if(B[idx] > A[i]) {
                answer++;
                idx--;
            }
        }
                
        return answer;
    }
}