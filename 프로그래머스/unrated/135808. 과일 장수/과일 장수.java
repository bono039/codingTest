import java.util.*;

class Solution {
    //                      점     개        
    public int solution(int k, int m, int[] score) {
        int answer = 0; // 최대 이익
        
        Arrays.sort(score); // 오름차순 정렬
        
        // 내림차순으로 정렬하기
        for(int i = 0 ; i < score.length / 2; i++) {
            int tmp = score[i];
            score[i] = score[score.length - 1 - i];
            score[score.length - 1 - i] = tmp;
        }
        
        
        
        // 배열 자르기
        for(int i = 0 ; i < score.length / m ; i++) {
            int[] arr = Arrays.copyOfRange(score, i * m, i * m + m);
            
            if(arr.length == m) {
                answer += arr[m-1] * m;        
            } else{
                break;
            }
            
        }

        return answer;
    }
}