class Solution {
    public int solution(int n, int[] stations, int w) {
        int now = 1;
        int sIdx = 0;
        int answer = 0;
                
        while(now <= n) {
            if(sIdx >= stations.length || now < stations[sIdx] - w) {
                answer++;
                now += 2*w + 1;
            }
            else {
                now = stations[sIdx] + w +1;
                sIdx++;
            }
        }

        return answer;
    }
}