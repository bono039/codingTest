class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int target = Integer.bitCount(n);    // 자연수 n을 이진수로 변환했을 때의 1의 개수
        
        // n을 1씩 증가시키며 2진수 표현에서의 1의 개수 계산
        for(int i = n + 1 ; ; i++) {
            int tmpCnt = Integer.bitCount(i);   // 새 수에서의 1의 개수
            
            if(tmpCnt == target) {
                answer= i;
                break;
            }
        }
        
        return answer;
    }
}