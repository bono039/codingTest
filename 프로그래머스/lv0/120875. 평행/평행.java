class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        
        float[] line = new float[6];
        int idx = 0;
        
        for(int i = 0 ; i < dots.length - 1 ; i++) {
            for(int j = i+1 ; j < dots.length ; j++) {
                
                // 기울기
                float result = (float)(dots[i][1] - dots[j][1]) / (float)(dots[i][0] - dots[j][0]);
                
                line[idx] = result;
                idx++;
                
            }
        }
        
        // 평행 확인
        for(int i=0 ; i < line.length - 1 ; i++) {
            for(int j = i+1 ; j < line.length ; j++) {
                if(line[i] == line[j]) return 1;
            }
        }
        
    
        return answer;
    }
}