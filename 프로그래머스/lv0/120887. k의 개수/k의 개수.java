class Solution {
    public int solution(int i, int j, int k) {
        int cnt = 0;
        String str = ""; 
        
        for(int t=i ; t<=j ; t++) {
            str += Integer.toString(t);
        }
        
        cnt = str.length() - str.replace(String.valueOf(k), "").length();
        return cnt;
    }
}