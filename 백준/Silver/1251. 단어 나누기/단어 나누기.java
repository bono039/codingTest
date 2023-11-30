import java.util.*;
import java.io.*;

public class Main {
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        List<String> list = new ArrayList<>();

        int len = str.length();

        for(int i = 1 ; i < len ; i++) {
            for(int j = i + 1 ; j < len ; j++) {
                String tmp = getSolution(i, j);
                list.add(tmp);
            }
        }
        Collections.sort(list);

        System.out.println(list.get(0));
    }

    private static String getSolution(int s, int e) {
        StringBuilder sb = new StringBuilder();

        StringBuilder sb1 = new StringBuilder(str.substring(0, s));
        StringBuilder sb2 = new StringBuilder(str.substring(s, e));
        StringBuilder sb3 = new StringBuilder(str.substring(e));

        sb.append(sb1.reverse().toString());
        sb.append(sb2.reverse().toString());
        sb.append(sb3.reverse().toString());

        return sb.toString();
    }
}