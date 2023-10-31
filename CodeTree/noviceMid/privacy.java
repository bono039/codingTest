import java.util.*;
import java.io.*;

class Person {
    String name;
    int h;
    double w;

    public Person(String name, int h, double w) {
        this.name = name;
        this.h = h;
        this.w = w;
    }
}

public class Main {
    static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Person[] people = new Person[5];
		for(int i = 0 ; i < 5 ; i++) {
            String[] str = br.readLine().split(" ");
		    people[i] = new Person(str[0], Integer.parseInt(str[1]), Double.parseDouble(str[2]));
		}
		        
        // 1. 이름 순으로 정렬 (람다식 활용)
        sb.append("name\n");
        Arrays.sort(people, (p1, p2) -> (p1.name).compareTo(p2.name));
        
        print(people);
        sb.append("\n");

        // 2. 키가 큰 순으로 내림차순 정렬
        sb.append("height\n");
		Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p2.h - p1.h; // = return Integer.compare(p2.h, p1.h);
            }
        });
        print(people);

        System.out.println(sb.toString());
	}

    // 출력 메소드
    public static void print(Person[] person) {
        for(Person p : person) {
            sb.append(p.name + " " + p.h + " " + p.w);
            sb.append("\n");
        }
    }
}
