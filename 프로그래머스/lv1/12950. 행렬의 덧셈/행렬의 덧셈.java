class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int len1 = arr1.length;
        int len2 = arr1[0].length;
        
        int[][] answer = new int[len1][len2];
        
        if(len1 == 1 && len2 == 1) {
            answer[0][0] = arr1[0][0] + arr2[0][0];
            answer[0][1] = arr1[0][1] + arr2[0][1];
        }
        
        for(int i=0 ; i < len1 ; i++) {
            for(int j=0 ; j < len2 ; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        
        return answer;
    }
}