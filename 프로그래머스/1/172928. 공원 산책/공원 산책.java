import java.util.*;

class Solution {
    static String[] park, routes;
    static int[] answer = new int[2];
    
    public int[] solution(String[] park, String[] routes) {
        this.park = park;
        this.routes = routes;
        
        for(int i = 0 ; i < park.length ; i++) {
            for(int j = 0 ; j < park[0].length() ; j++) {
                if(park[i].charAt(j) == 'S') {
                    answer = new int[]{i, j};
                }
            }
        }
        
        for(String route : routes) {
            char op = route.charAt(0);
            int  n = Integer.parseInt(route.substring(2));
            boolean flag = true;
            
            int nowX = answer[0];
            int nowY = answer[1];
            
            for(int i = 0 ; i < n ; i++) {
                if(op == 'N') {
                    if(!inRange(nowX - 1, nowY) || park[nowX - 1].charAt(nowY) == 'X') {
                        flag = false;
                        break;
                    }
                    nowX--;
                }
                if(op == 'S') {
                    if(!inRange(nowX + 1, nowY) || park[nowX + 1].charAt(nowY) == 'X') {
                        flag = false;
                        break;
                    }
                    nowX++;
                }
                if(op == 'W') {
                    if(!inRange(nowX, nowY - 1) || park[nowX].charAt(nowY - 1) == 'X') {
                        flag = false;
                        break;
                    }
                    nowY--;
                }
                if(op == 'E') {
                    if(!inRange(nowX, nowY + 1) || park[nowX].charAt(nowY + 1) == 'X') {
                        flag = false;
                        break;
                    }
                    nowY++;
                }
            }
            
            if(flag) {
                answer[0] = nowX;
                answer[1] = nowY;
            }
        }
        
        return answer;
    }
        
    private static boolean inRange(int x, int y) {
        return 0 <= x && x < park.length && 0 <= y && y < park[0].length();
    }
}