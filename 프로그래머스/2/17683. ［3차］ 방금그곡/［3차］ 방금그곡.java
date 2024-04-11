import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxTime = -1;
        
        m = m.replace("C#", "c")
              .replace("D#", "d")
              .replace("F#", "f")
              .replace("G#", "g")
              .replace("A#", "a")
              .replace("B#", "b");
        
        for(String music : musicinfos) {
            String[] info = music.split(",");
            int play = getLastingTime(info[0], info[1]);
            
            info[3] = info[3].replace("C#", "c")
                              .replace("D#", "d")
                              .replace("F#", "f")
                              .replace("G#", "g")
                              .replace("A#", "a")
                              .replace("B#", "b");
            
            String melody = info[3];
            
            if(play <= melody.length()) {
                melody = melody.substring(0, play);
            }
            else {
                StringBuilder newMelody = new StringBuilder();
                
                for(int i = 0 ; i < play/melody.length() ; i++) {
                    newMelody.append(melody);
                }
                
                newMelody.append(melody.substring(0, play % melody.length()));
                melody = newMelody.toString();
            }
            
            if(melody.contains(m) && play > maxTime) {
                answer = info[2];
                maxTime = play;
            }
        }
        
        return answer;
    }
    
    private static int getLastingTime(String s1, String s2) {
        String[] t1 = s1.split(":");
        String[] t2 = s2.split(":");
        
        return (Integer.parseInt(t2[0]) *60 + Integer.parseInt(t2[1])) - (Integer.parseInt(t1[0])*60 + Integer.parseInt(t1[1]));
    }
}
