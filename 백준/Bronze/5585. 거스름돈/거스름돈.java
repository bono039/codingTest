import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int price = 1000 - Integer.parseInt(br.readLine());
        long cnt = 0;
        
        while(price > 0) {
            int tmp = 0;
            
            if(price / 500 > 0) {
                tmp = price/500;
                cnt += tmp;
                price -= tmp * 500;
            }
            else if(price / 100 > 0) {
                tmp = price/100;
                cnt += tmp;
                price -= tmp * 100;                
            }
            else if(price / 50 > 0) {
                tmp = price/50;
                cnt += tmp;
                price -= tmp * 50;                
            }
            else if(price / 10 > 0) {
                tmp = price/10;
                cnt += tmp;
                price -= tmp * 10;                
            }
            else if(price / 5 > 0) {
                tmp = price/5;
                cnt += tmp;
                price -= tmp * 5;                
            }
            else if(price / 1 > 0) {
                tmp = price/1;
                cnt += tmp;
                price -= tmp * 1;                
            }
        }
        System.out.println(cnt);
    }
}
