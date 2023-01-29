class Solution {
    public int[] solution(int n, int[] numlist) {
        // 새 배열 길이 계산
        int cnt = 0;
        
        for(int num : numlist) {
            if(num % n == 0) {
                cnt++;
            }
        }
        
        // 새 배열 채워넣기
        int[] answer = new int[cnt];
        int idx = 0;
        
        for(int num : numlist) {
            if(num % n == 0) {
                answer[idx] = num;
                idx++;
            }
        }
        
        return answer;
    }
}