class Solution {
    public int solution(String[] spell, String[] dic) {
        boolean wordChk = false;
        
        for(String word : dic) {
            int cnt = 0;
            
            for(String s : spell) {
                if(word.contains(s)) cnt++;
            }
            
            if(cnt == spell.length) {
                wordChk = true;
                break;
            }
        }
        
        return wordChk ? 1 : 2;
    }
}