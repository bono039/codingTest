class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int[] cnt = new int[2];
        
        s = s.toLowerCase();
        
        for(int i=0 ; i < s.length() ; i++) {
            if(String.valueOf(s.charAt(i)).equals("p"))      cnt[0]++;
            else if(String.valueOf(s.charAt(i)).equals("y")) cnt[1]++;
        }
        
        if(cnt[0] == cnt[1] && cnt[0]!= 0 && cnt[1] != 0) answer = true;
        else if(cnt[0] != cnt[1])                         answer = false;
        else if(cnt[0] == 0 && cnt[1] == 0)               answer = true;
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}