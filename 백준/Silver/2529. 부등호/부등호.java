import java.util.*;
import java.io.*;

public class Main {
    static int K;
    
    static int[] nums;
    static char[] signs;
    static boolean[] used;    // 0~9 사용 여부
    
    static List<String> answer = new ArrayList<>();
    
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        K = Integer.parseInt(br.readLine()) + 1;
        
        nums = new int[10];
        for(int i = 0 ; i < 10 ; i++) {
            nums[i] = i;
        }
        
        
        signs = new char[K - 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < K - 1 ; i++) {
            signs[i] = st.nextToken().charAt(0);
        }
        
        for(int i = 0 ; i < 10 ; i++) {
            used = new boolean[10];
            
            used[i] = true;
            back(i, 0, i+"");
            used[i] = false;
        }
        
        System.out.println(answer.get(answer.size() - 1));
        System.out.println(answer.get(0));
    }
    
    private static void back(int startIdx, int depth, String word) {
        if (word.length() == K) {
            answer.add(word);
            return;
        }
        
        for (int i = 0; i <= 9; i++) {
            if(!used[i]) {
                char tmp = signs[depth];
                
                if(tmp == '>') {
                    if(startIdx > i) {
                        used[i] = true;
                        back(i, depth + 1, word+i);
                        used[i] = false;
                    }
                }
                else {
                    if(startIdx < i) {
                        used[i] = true;
                        back(i, depth + 1, word+i);
                        used[i] = false;
                    }
                }
            }
        }
    }
}
