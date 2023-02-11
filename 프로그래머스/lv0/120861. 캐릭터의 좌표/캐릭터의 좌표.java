class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        
        // 상하좌우 cnt 배열 생성
        int[] direction = new int[4];        
        
        
        for(String s : keyinput) {
            switch(s) {
                case "up" -> {
                    if(answer[1] >= board[1] / 2) {
                        continue;
                    }
                    answer[1]++;
                }

                case "down" -> {
                    if(answer[1] <= -(board[1] / 2)) {
                        continue;
                    }
                    answer[1]--;
                }

                case "right" -> {
                    if(answer[0] >= board[0] / 2) {
                        continue;
                    }
                    answer[0]++;
                }

                default -> {
                    if(answer[0] <= -(board[0] / 2)) {
                        continue;
                    }
                    answer[0]--;
                }
            }
        }
        
        return answer;
    }
}