import java.util.*;
import java.io.*;

class Person {
    String name, addr, city;

    public Person(String name, String addr, String city) {
        this.name = name;
        this.addr = addr;
        this.city = city;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Person[] people = new Person[N];
        for(int i = 0 ; i < N ; i++) {
            String[] str = br.readLine().split(" ");
            people[i] = new Person(str[0], str[1], str[2]);
        }

        Arrays.sort(people, (o1, o2) -> (o2.name).compareTo(o1.name));  // 이름, 사전 순 내림차순 정렬
        
        System.out.println("name " + people[0].name);
        System.out.println("addr " + people[0].addr);
        System.out.println("city " + people[0].city);
    }
}
