import java.util.*;
import java.io.*;

public class Main {
    static Keyboard[] qwerty = new Keyboard[30];
    
    static String pos;
    static char[] input;
    static int[] left, right;
    
    static int time = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        makeKeyboard();

        pos = br.readLine();
        left = new int[2];
        right = new int[2];
            
        for(int j = 0 ; j < 30 ; j++) {
            if(qwerty[j].c == pos.charAt(0)) {
                if(qwerty[j].hand == 'l') { 
                    left = new int[] {qwerty[j].x, qwerty[j].y};
                }
                else {
                    right = new int[] {qwerty[j].x, qwerty[j].y};
                }
                break;
            }
        }
        for(int j = 0 ; j < 30 ; j++) {
            if(qwerty[j].c == pos.charAt(2)) {
                if(qwerty[j].hand == 'l') { 
                    left = new int[] {qwerty[j].x, qwerty[j].y};
                }
                else {
                    right = new int[] {qwerty[j].x, qwerty[j].y};
                }
                break;
            }
        }
        
        input = br.readLine().toCharArray();
        
        for(int i = 0 ; i < input.length ; i++) {
            // 문자열 위치 찾기
            char h = 'x';
            int[] findPos = new int[2];
            
            for(int j = 0 ; j < 30 ; j++) {
                if(qwerty[j].c == input[i]) {
                    findPos[0] = qwerty[j].x;
                    findPos[1] = qwerty[j].y;
                    h = qwerty[j].hand;
                    break;
                }
            }
            
            // 왼손이면, 왼손에서 움직여서 택시 거리 구하기
            if(h == 'l') {
                int dist = Math.abs(left[0] - findPos[0]) + Math.abs(left[1] - findPos[1]);
                time += dist + 1;
                left[0] = findPos[0];
                left[1] = findPos[1];
            }
            // 오른손이면, 오른손에서 움직여서 택시 거리 구하기
            else if(h == 'r') {
                int dist = Math.abs(right[0] - findPos[0]) + Math.abs(right[1] - findPos[1]);
                time += dist + 1;
                right[0] = findPos[0];
                right[1] = findPos[1];
            }
        }
        
        System.out.println(time);
    }
    
    private static void makeKeyboard() {
        qwerty[0] = new Keyboard('q', 'l', 0, 0);
        qwerty[1] = new Keyboard('w', 'l', 0, 1);
        qwerty[2] = new Keyboard('e', 'l', 0, 2);
        qwerty[3] = new Keyboard('r', 'l', 0, 3);
        qwerty[4] = new Keyboard('t', 'l', 0, 4);
        qwerty[5] = new Keyboard('y', 'r', 0, 5);
        qwerty[6] = new Keyboard('u', 'r', 0, 6);
        qwerty[7] = new Keyboard('i', 'r', 0, 7);
        qwerty[8] = new Keyboard('o', 'r', 0, 8);
        qwerty[9] = new Keyboard('p', 'r', 0, 9);
        
        qwerty[10] = new Keyboard('a', 'l', 1, 0);
        qwerty[11] = new Keyboard('s', 'l', 1, 1);
        qwerty[12] = new Keyboard('d', 'l', 1, 2);
        qwerty[13] = new Keyboard('f', 'l', 1, 3);
        qwerty[14] = new Keyboard('g', 'l', 1, 4);
        qwerty[15] = new Keyboard('h', 'r', 1, 5);
        qwerty[16] = new Keyboard('j', 'r', 1, 6);
        qwerty[17] = new Keyboard('k', 'r', 1, 7);
        qwerty[18] = new Keyboard('l', 'r', 1, 8);
        qwerty[19] = new Keyboard('X', 'x', 0, 0);  // null
        
        qwerty[20] = new Keyboard('z', 'l', 2, 0);
        qwerty[21] = new Keyboard('x', 'l', 2, 1);
        qwerty[22] = new Keyboard('c', 'l', 2, 2);
        qwerty[23] = new Keyboard('v', 'l', 2, 3);
        qwerty[24] = new Keyboard('b', 'r', 2, 4);
        qwerty[25] = new Keyboard('n', 'r', 2, 5);
        qwerty[26] = new Keyboard('m', 'r', 2, 6);
        
        qwerty[27] = new Keyboard('X', 'x', 0, 0);  // null
        qwerty[28] = new Keyboard('X', 'x', 0, 0);  // null
        qwerty[29] = new Keyboard('X', 'x', 0, 0);  // null        
    }
}

class Keyboard {
    char c, hand;
    int x, y;
    
    public Keyboard(char c, char hand, int x, int y) {
        this.c = c;
        this.hand = hand;
        this.x = x;
        this.y = y;
    }
}
