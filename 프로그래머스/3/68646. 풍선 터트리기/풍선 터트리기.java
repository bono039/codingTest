import java.util.*; // lv3

class Solution {
    public int solution(int[] a) {
        int size = a.length;
        if(size == 1)   return 1;
        
        int[] leftMin = new int[size];  
        int[] rightMin = new int[size]; 
        int l = a[0];   
        int r = a[size -1]; 
        
        for(int i = 1 ; i < size -1 ; i++) {
            if(l > a[i])
                l = a[i];
            leftMin[i] = l;
        }
        
        for(int i = size -2 ; i > 0 ; i--) {
            if(r > a[i])
                r = a[i];
            rightMin[i] = r;
        }       
        
        int answer = 2; 
        for(int i = 1 ; i <= size -2 ; i++) {
            if(a[i] > leftMin[i] && a[i] > rightMin[i]) continue;
            answer++;
        }
        
        return answer;
    }
}