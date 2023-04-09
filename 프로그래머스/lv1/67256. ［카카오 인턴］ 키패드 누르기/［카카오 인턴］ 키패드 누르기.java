class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int left  = 10;
        int right = 12;
        
        for(int tmp : numbers) {
            if(tmp == 1 || tmp == 4 || tmp == 7) {
                answer += "L";
                left = tmp;
            } else if(tmp == 3 || tmp == 6 || tmp == 9) {
                answer += "R";
                right = tmp;
            } else {
                if(tmp == 0) tmp = 11;
                int leftD = Math.abs(tmp - left) / 3 + Math.abs(tmp - left) % 3;
                int rightD = Math.abs(tmp - right) / 3 + Math.abs(tmp - right) % 3;
                
                if(leftD < rightD) {
                    answer += "L";
                    left = tmp;
                } else if(leftD > rightD) {
                    answer += "R";
                    right = tmp;
                } else {
                    if(hand.equals("left")) {
                        answer += "L";
                        left = tmp;
                    } else {
                        answer += "R";
                        right = tmp;
                    }
                }
            }
        }
 
        return answer;
    }
}