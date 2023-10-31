import java.util.*;
import java.io.*;

class Person implements Comparable<Person> {
    String name;
    int h, w;

    public Person(String name, int h, int w) {
        this.name = name;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Person p) {
        if(this.h == p.h) {
            return p.w - this.w;
        }
        return this.h - p.h;
    }
}

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
        Person[] people = new Person[n];
		for(int i = 0 ; i < n ; i++) {
            String[] str = br.readLine().split(" ");
            people[i] = new Person(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]));
		}
		
		Arrays.sort(people);
		for(Person p : people) {
            System.out.println(p.name + " " + p.h + " " + p.w);
        }
	}
}
