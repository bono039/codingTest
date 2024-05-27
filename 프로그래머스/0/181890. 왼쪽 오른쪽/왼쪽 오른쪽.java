class Solution {
    public String[] solution(String[] str_list) {
        
        String[] tmp = new String[str_list.length];
        int cnt = 0;
        
        for(int i = 0 ; i < str_list.length ; i++) {
            if(str_list[i].equals("l")) {
                for(int j = 0 ; j < i ; j++) {
                    tmp[cnt] = str_list[j];
                    cnt++;
                }
                break;
            }
            else if(str_list[i].equals("r")) {
                for(int j = i + 1 ; j < str_list.length ; j++) {
                    tmp[cnt] = str_list[j];
                    cnt++;
                }
                break;
            }
        }
                
        String[] answer = new String[cnt];
        for(int i = 0 ; i < cnt ; i++) {
            answer[i] = tmp[i];
        }
        return answer;
    }
}