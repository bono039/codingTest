import java.util.ArrayList;

class Solution {
    public int[] solution(int n) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=1; i <=n ; i++) {
            if(n % i == 0) {
                arr.add(i);
            }
        }
        
        int[] answer = arr.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}