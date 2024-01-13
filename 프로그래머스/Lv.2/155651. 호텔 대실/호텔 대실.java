class Solution {
    private static final int MAX_TIME = 24 * 60 + 10;
    
    public int solution(String[][] book_time) {
        int answer = 0;
        
        int[] rooms = new int[MAX_TIME];
        
        for(String[] time : book_time) {
            String start = time[0];
            String end = time[1];
            
            rooms[calcTime(start)] += 1;        // 입실 시간
            rooms[calcTime(end) + 10] += -1;    // 퇴실 + 청소 시간
        }
        
        // 누적합
        for(int i = 1 ; i < MAX_TIME ; i++) {
            rooms[i] += rooms[i - 1];
            answer = Math.max(answer, rooms[i]);
        }        
        
        return answer;
    }
    
    private static int calcTime(String time) {
        String[] str = time.split(":");
        String hh = str[0];
        String mm = str[1];
        
        return ((Integer.parseInt(hh) * 60) + Integer.parseInt(mm));
    }
}