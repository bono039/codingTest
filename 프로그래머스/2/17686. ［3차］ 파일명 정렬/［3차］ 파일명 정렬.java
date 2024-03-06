import java.util.*;

class Solution {
    static String[] files;
    static Info[] infos;
    
    public String[] solution(String[] files) {
        this.files = files;       
        infos = new Info[files.length];
        
        for(int i = 0 ; i < files.length ; i++) {
            String head = "";
            String number = "";
            String tail = "";
            
            String file = files[i];
            int numIdx = 0;
            
            for(int j = 0 ; j < file.length() ; j++) {
                if(Character.isDigit(file.charAt(j))) {
                    head = file.substring(0, j);
                    numIdx = j;
                    break;
                }
            }
            
            int tailIdx = 0;
            for(int j = numIdx ; j < file.length() ; j++) {
                if(Character.isDigit(file.charAt(j))) {
                    number += file.charAt(j);
                }
                else {
                    tailIdx = j;
                    break;
                }
            }
            
            if(tailIdx == 0)    // 꼬리가 없는 경우
                tail = "";
            else
                tail = file.substring(tailIdx);
            
            infos[i] = new Info(head, number, tail);
            
            System.out.println(head + " " + number + " " + tail);
        }
        Arrays.sort(infos);
        
        String[] answer = new String[files.length];
        for(int i = 0 ; i < answer.length ; i++) {
            answer[i] = infos[i].head + infos[i].num + infos[i].tail;
        }        
        
        return answer;
    }
}

class Info implements Comparable<Info> {
    String head, num, tail;
    
    public Info(String head, String num, String tail) {
        this.head = head;
        this.num = num;
        this.tail = tail;
    }
    
    @Override
    public int compareTo(Info info) {
        if(this.head.equalsIgnoreCase(info.head)) {
            if(Integer.parseInt(this.num) != Integer.parseInt(info.num)) {
                return Integer.parseInt(this.num) - Integer.parseInt(info.num);
            }
        }
        return this.head.toUpperCase().compareTo(info.head.toUpperCase());    
    }
}