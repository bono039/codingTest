import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]); // 진출 지점 기준 오름차순 정렬
        
        int location = routes[0][1];    // 카메라 설치 지점
        int answer = 1;
        
        for(int i = 1 ; i < routes.length ; i++) {
            if(routes[i][0] > location) {   // 시작 지점이 마지막 카메라 설치 지점보다 크다면 설치
                answer++;
                location = routes[i][1];
            }
        }
        
        return answer;
    }
}