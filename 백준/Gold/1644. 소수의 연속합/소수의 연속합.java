import java.util.*;
import java.io.*;

public class Main {
    static boolean[] isPrime;
    static ArrayList<Integer> numbers = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        isPrime = new boolean[N + 1];
        isPrime[0] = isPrime[1] = true;
        
        for(int i = 2 ; i <= (int)Math.sqrt(N) ; i++) {
            if(isPrime[i])  continue;
            for(int j = i * i ; j <= N ; j += i) {
                isPrime[j] = true;
            }
        }
        
        for(int i = 1 ; i <= N ; i++) {
            if(!isPrime[i])
                numbers.add(i);
        }
        
        int start = 0, end = 0, sum = 0, cnt = 0;
        
        while(true) {
            if(sum >= N)
                sum -= numbers.get(start++);
            else if(end == numbers.size())
                break;
            else
                sum += numbers.get(end++);
            
            if(N == sum) cnt++;
        }
        System.out.println(cnt);
    }
}
