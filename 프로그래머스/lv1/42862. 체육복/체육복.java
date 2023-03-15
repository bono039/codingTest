import java.util.*;

class Solution {
    //                                도난         여벌
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n];
        Arrays.fill(arr, 1);    // 배열을 1로 채우기
        
        boolean[] std = new boolean[n];
        Arrays.fill(std, true); // 배열 true로 채우기
        
        // lost, reserve 반영하기
        for(int i=0 ; i < lost.length ; i++) {
            arr[lost[i] - 1] = 0;
            std[lost[i] - 1] = false;
        }
        for(int i=0; i < reserve.length ; i++) {
            arr[reserve[i] - 1] = 2;
            std[reserve[i] - 1] = true;
        }
        
        // 여벌도 있지만 도난 당한 경우
        int idx = 0;
        for(int i=0 ; i < lost.length ; i++) {
            for(int j=0 ; j < reserve.length ; j++) {
                if(lost[i] == reserve[j]) {
                    idx = reserve[j] - 1;
                    arr[idx] = 1;
                }
            }
        }
    
        for(int i=0 ; i < std.length ; i++) {
            if(!std[i]) {
                // 가운데 수의 학생일 때
                if(i != 0 && i != (n-1)) {
                    if(arr[i-1] == 2) {
                        arr[i-1]--;
                        std[i] = true;
                    } else if(arr[i+1] == 2) {
                        arr[i+1]--;
                        std[i] = true;
                    }

                }
                // 첫 번째 학생일 때
                else if(i==0) {
                    if(arr[i+1] == 2) {
                        arr[i+1]--;
                        std[i] = true;
                    }
                }
                // 마지막 번호 학생일 때
                else if(i==(n-1)) {
                    if(arr[i-1] == 2) {
                        arr[i-1]--;
                        std[i] = true;
                    }
                }                
            }

        }
     
        // 체육복 있는 (=True인) 학생 수 계산
        for(boolean b : std) {
            if(b) answer++;
        }
   
        return answer;
    }
}