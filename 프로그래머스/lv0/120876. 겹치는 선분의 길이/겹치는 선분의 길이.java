class Solution {
    public int solution(int[][] lines) {
        
        int[] arr = new int[200];
        int answer = 0;
        
        // lines 정보를 arr배열에 적용
        for(int i=0 ; i < lines.length ; i++) {
            for(int j = lines[i][0] + 100 ; j < lines[i][1] + 100 ; j++) {
                arr[j]++;
            }
        }
        
        // 겹친 부분 세기
        for(int i=0 ; i < 200 ; i++) {
            if(arr[i] > 1) {
                answer++;
            }
        }
        
        return answer;
    }
}