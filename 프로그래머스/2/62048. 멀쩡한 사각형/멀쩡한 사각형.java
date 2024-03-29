import java.util.*;

class Solution {
    public long solution(int w, int h) {        
        long ww = (long)w;
        long hh = (long)h;
        
        return ww * hh - (ww + hh - getGCD(ww, hh));
    }
    
    private static long getGCD(long x, long y) {
        if(y == 0) return x;
        return getGCD(y, x%y);
    }
}