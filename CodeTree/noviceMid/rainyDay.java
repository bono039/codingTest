import java.util.*;
import java.io.*;

class Data implements Comparable<Data> {
    String day, date, weather;

    public Data(String day, String date, String weather) {
        this.day = day;
        this.date = date;
        this.weather = weather;
    }

    @Override
    public int compareTo(Data d) {  // 날짜 기준 오름차순 정렬
        String[] str1 = this.day.split("-");
        String[] str2 = d.day.split("-");

        if(str1[0].equals(str2[0])) {
            if(str1[1].equals(str2[0])) {
                return Integer.parseInt(str1[2]) - Integer.parseInt(str2[2]);
            }
            return Integer.parseInt(str1[1]) - Integer.parseInt(str2[1]);
        }
        return Integer.parseInt(str1[0]) - Integer.parseInt(str2[0]);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Data[] data = new Data[N];
        for(int i = 0 ; i < N ; i++) {
            String[] str = br.readLine().split(" ");
            data[i] = new Data(str[0], str[1], str[2]);
        }

        Arrays.sort(data);

        // 정렬하고 나서, 가장 먼저 나오는 "비" 출력
        for(Data d : data) {
            if(d.weather.equals("Rain")) {
                System.out.println(d.day + " " + d.date + " " + d.weather);
                break;
            }
        }      
    }
}
