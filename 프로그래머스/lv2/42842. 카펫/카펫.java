class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];  // 가로, 세로
        int sum = brown + yellow;
        
        // 세로는 3 이상
        // 카펫 사이즈 경우의 수 <- (brown + yellow)의 약수 구하기
        for(int i = 3 ; i < sum ; i++) {
            int width = sum / i;    // 가로
            
            if(width >= i) {
                if((i - 2) * (width - 2) == yellow) {
                    answer[0] = width;  // 가로
                    answer[1] = i;      // 세로
                    break;
                }
            }
        }
        return answer;
    }
}