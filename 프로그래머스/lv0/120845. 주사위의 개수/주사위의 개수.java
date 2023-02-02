class Solution {
    public int solution(int[] box, int n) {
        int answer = 1;
        
        // 10 8 6 (3) -> 12
        //  3 2 2
        for(int num : box) {
            answer *= num/n;
        }
        
        
        return answer;
    }
}