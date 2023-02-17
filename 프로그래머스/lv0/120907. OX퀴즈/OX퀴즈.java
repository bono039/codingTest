class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for(int i=0 ; i < quiz.length ; i++) {
            String[] arr = quiz[i].split(" ");
            
            int result = Integer.parseInt(arr[4]);
            
            if(arr[1].equals("+")) {
                if(Integer.parseInt(arr[0]) + Integer.parseInt(arr[2]) == result) answer[i] = "O";
                else                                                              answer[i] = "X";
            }
            else {
                if(Integer.parseInt(arr[0]) - Integer.parseInt(arr[2]) == result) answer[i] = "O";
                else                                                              answer[i] = "X";
            }
        }
        
        return answer;
    }
}