import java.util.*;
// 정사각형 (세로 좌표, 가로 좌표)
// 빈 칸 :  . / 파일 O : #
// 최소한의 이동거리를 갖는 한 번의 드래그를 하기 위한 시작점과 끝점 좌표를 담은 정수 배열
class Solution {
    public int[] solution(String[] wallpaper) { // 컴퓨터 바탕화면 상태
        int[] answer = new int[4];
        
        int minX = wallpaper.length;
        int minY = wallpaper[0].length();
        int maxX = 0;
        int maxY = 0;
        
        
        char[][] map = new char[wallpaper.length][wallpaper[0].length()];
        for(int i = 0 ; i < wallpaper.length ; i++) {
            String str = wallpaper[i];
            for(int j = 0 ; j < wallpaper[i].length() ; j++) {
                map[i][j] = str.charAt(j);
                
                if(map[i][j] == '#') {
                    minX = Math.min(i, minX);
                    minY = Math.min(j, minY);
                    maxX = Math.max(i, maxX);
                    maxY = Math.max(j, maxY);
                }
            }
        }
        
        //System.out.println(minX + " / " + minY + " / " + maxX + " / " + maxY);
        answer[0] = minX;
        answer[1] = minY;
        answer[2] = maxX + 1;
        answer[3] = maxY + 1;
        
        
        return answer;
    }
}