import java.util.*;
import java.io.*;

public class Main {
    static int L, C;
    static String[] inputArr;
    static String[] strArr;
    
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        inputArr = new String[C];
        strArr = new String[L];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < C ; i++) {
            inputArr[i] = st.nextToken();
        }
        Arrays.sort(inputArr);
        
        combination(0, 0, 0, 0);
        System.out.println(sb);
    }
    
    private static void combination(int start, int cnt, int mo, int za) {
        if(cnt == L) {
            if(mo >= 1 && za >= 2) {
                for(int i = 0 ; i < strArr.length ; i++) {
                    sb.append(strArr[i]);
                }
                sb.append("\n");
            }
            return;
        }
        
        for(int i = start ; i < C ; i++) {
            if(inputArr[i].equals("a") || inputArr[i].equals("e") || inputArr[i].equals("i") || inputArr[i].equals("o") || inputArr[i].equals("u")) {
                strArr[cnt] = inputArr[i];
                combination(i + 1, cnt + 1, mo + 1, za);
            }
            else {
                strArr[cnt] = inputArr[i];
                combination(i + 1, cnt + 1, mo, za + 1);
            }
        }
    }
}