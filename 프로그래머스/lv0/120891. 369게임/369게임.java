class Solution {
    public int solution(int order) {
        int answer = 0;
        
        String orderStr = Integer.toString(order);
        
        answer = orderStr.length() - orderStr.replaceAll("[369]", "").length();
        
        return answer;
    }
}