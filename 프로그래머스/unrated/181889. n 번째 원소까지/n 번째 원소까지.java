class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[n];
        
        for(int i = 1 ; i <= n ; i++) {
            answer[i-1] = num_list[i-1];
        }
        
        return answer;
    }
}