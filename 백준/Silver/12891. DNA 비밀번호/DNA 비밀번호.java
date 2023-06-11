import java.util.*;
import java.io.*;

public class Main { 
    static int check[];
    static int now[];
    static int checkSecret;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int result = 0;
        
        char A[] = new char[S];
        check = new int[4];
        
        now = new int[4];
        checkSecret = 0;
        
        A = br.readLine().toCharArray();
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < 4 ; i++) {
            check[i] = Integer.parseInt(st.nextToken());
            
            if(check[i] == 0) {
                checkSecret++;
            }
        }
        
        for(int i = 0 ; i < P ; i++) {
            Add(A[i]);
        }
        
        if(checkSecret == 4) {
            result++;
        }
        
        for(int i = P ; i < S ; i++) {
            int j = i - P;
            Add(A[i]);
            Remove(A[j]);
            
            if(checkSecret == 4) {
                result++;
            }
        }
        System.out.println(result);
        br.close();
        
    }
    
    private static void Add(char c) {
        switch(c) {
            case 'A' :
                now[0]++;
                
                if(now[0] == check[0]) checkSecret++;
                break;
                
            case 'C' :
                now[1]++;
                
                if(now[1] == check[1]) checkSecret++;
                break;
            
            case 'G' :
                now[2]++;
                
                if(now[2] == check[2]) checkSecret++;
                break;
            
            case 'T' :
                now[3]++;
                
                if(now[3] == check[3]) checkSecret++;
                break;
        }
    }
    
    private static void Remove(char c) {
        switch(c) {
            case 'A' :
                if(now[0] == check[0]) checkSecret--;
                now[0]--;
                break;
                
            case 'C' :
                if(now[1] == check[1]) checkSecret--;
                now[1]--;
                break;
                
            case 'G' :
                if(now[2] == check[2]) checkSecret--;
                now[2]--;
                break;

            case 'T' :
                if(now[3] == check[3]) checkSecret--;
                now[3]--;
                break;
        }
    }
}