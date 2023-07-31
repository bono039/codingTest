import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int end = 0;        // 수행되고 난 직후 시간
        int jobsIdx = 0;    // jobs 배열의 인덱스
        int cnt = 0;        // 수행된 요청 갯수

        Arrays.sort(jobs, (o1,o2) -> o1[0] - o2[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        while(cnt < jobs.length) {
            while(jobsIdx < jobs.length && jobs[jobsIdx][0] <= end) {
                pq.add(jobs[jobsIdx++]);
            }
            
            if(pq.isEmpty()) {
                end = jobs[jobsIdx][0];
            }
            else {
                int[] tmp = pq.poll();
                
                answer += tmp[1] + end - tmp[0];
                end += tmp[1];
                cnt++;
            }
        }
        
        return (int)Math.floor(answer / jobs.length);
    }
}