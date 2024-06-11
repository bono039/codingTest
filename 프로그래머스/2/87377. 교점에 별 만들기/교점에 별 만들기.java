import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        
        List<long[]> list = new ArrayList<>();
        
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
                
        for(int i = 0 ; i < line.length ; i++) {
            long a = line[i][0];
            long b = line[i][1];
            long n1 = line[i][2];
        
            for(int j = i+1 ; j < line.length ; j++) {
                long c = line[j][0];
                long d = line[j][1];
                long n2 = line[j][2];
                
                long xUp = b*n2 - n1*d;
                long xDown = a*d - b*c;
                
                long yUp = n1*c - a*n2;
                long yDown = a*d - b*c;
                
                if(xDown != 0) {
                    double x = xUp / (double)xDown;
                    double y = yUp / (double)yDown;
                    
                    if(x == Math.ceil(x) && y == Math.ceil(y)) {
                        list.add(new long[] {(long)x, (long)y});
                        
                        minX = Math.min(minX, (long)x);
                        maxX = Math.max(maxX, (long)x);
                        minY = Math.min(minY, (long)y);
                        maxY = Math.max(maxY, (long)y);
                    }
                }
            }
        }
        
        boolean[][] answerTmp = new boolean[(int)(maxY - minY + 1)][(int)(maxX - minX + 1)];
        
        for(long[] ints : list) {
            int x = (int) (ints[0] - minX);
            int y = (int) (ints[1] - maxY);
            
            answerTmp[Math.abs(y)][Math.abs(x)] = true;
        }
        
        String[] answer = new String[answerTmp.length];
        
        int i = 0;
        for(boolean[] bs : answerTmp) {
            StringBuilder sb = new StringBuilder();
            for(boolean b : bs) {
                sb.append(b ? "*" : ".");
            }
            answer[i++] = sb.toString();
        }
        return answer;
    }
}