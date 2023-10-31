import java.util.*;

class Person implements Comparable<Person>{
    String name;
    int h, w;

    public Person(String name, int h, int w) {
        this.name = name;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Person p) {
        return this.h - p.h;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Person[] people = new Person[n];
        for(int i = 0 ; i < n ; i++) {
            String name = sc.next();
            int height = sc.nextInt();
            int weight = sc.nextInt();

            people[i] = new Person(name, height, weight);
        }

        Arrays.sort(people);    // 키 기준 오름차순 정렬

        for(Person p : people) {
            System.out.println(p.name + " " + p.h + " " + p.w);
        }
    }
}
