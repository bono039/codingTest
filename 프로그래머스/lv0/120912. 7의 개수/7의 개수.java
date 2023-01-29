class Solution {
    public int solution(int[] array) {
        int answer = 0;
        String str = "";
        
        // 배열에서 꺼내서 문자열 하나로 만들고 거기서 7 갯수 구하기
        for(int arr : array) {
            str += Integer.toString(arr);
        }
        
        for(int i=0 ; i<str.length() ; i++) {
            if(str.charAt(i) == '7') answer++;
        }
        
        return answer;
    }
}