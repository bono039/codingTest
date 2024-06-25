import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        
        List<long[]> list = new ArrayList<>();
        
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        
        for(int i = 0 ; i < line.length ; i++) {
            long A = line[i][0];
            long B = line[i][1];
            long E = line[i][2];
                        
            for(int j = i+1 ; j < line.length ; j++) {
                long C = line[j][0];
                long D = line[j][1];
                long F = line[j][2];
                
                long xUp   = B*F - E*D;
                long xDown = A*D - B*C;
                
                long yUp   = E*C - A*F;
                long yDown = A*D - B*C;
                
                if(xDown != 0) {
                    double x = xUp / (double)xDown;
                    double y = yUp / (double)yDown;
                    
                    if(x == Math.ceil(x) && y == Math.ceil(y)) {
                        list.add(new long[]{(long)x, (long)y});
                        
                        minX = Math.min(minX, (long)x);
                        maxX = Math.max(maxX, (long)x);
                        minY = Math.min(minY, (long)y);
                        maxY = Math.max(maxY, (long)y);
                    }                    
                }                
            }
        }
        
        boolean[][] answerTmp = new boolean[(int)(maxY - minY + 1)][(int)(maxX - minX + 1)];
        
        for(long[] info : list) {
            int x = (int)(info[0] - minX);
            int y = (int)(info[1] - maxY);
            
            answerTmp[Math.abs(y)][Math.abs(x)] = true;
        }
               
        String[] answer = new String[answerTmp.length];
        int idx = 0;
        
        for(boolean[] bs : answerTmp) {
            StringBuilder sb = new StringBuilder();
            
            for(boolean b : bs) {
                sb.append(b ? "*" : ".");
            }
            
            answer[idx++] = sb.toString();
        }
        return answer;
    }
}