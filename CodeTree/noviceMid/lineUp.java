import java.util.*;
import java.io.*;

class Person implements Comparable<Person> {
    int h, w, idx;
    
    public Person(int h, int w, int idx) {
        this.h = h;
        this.w = w;
        this.idx = idx;
    }
    
    @Override
    public int compareTo(Person p) {
        if(this.h != p.h) { // 조건1) 키가 더 큰 학생이 앞에 와야
            return p.h - this.h;
        }
        else {
			if(this.w != p.w) 
				return p.w - this.w;	// 조건2) 키가 동일하다면, 몸무게가 더 큰 학생이 앞에 와야
			return this.idx - p.idx;	// 조건3) 키와 몸무게가 동일하다면, 번호가 작은 학생이 앞에 와야
		}
    }
}

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
        Person[] people = new Person[n];
		for(int i = 0 ; i < n ; i++) {
            String[] str = br.readLine().split(" ");
            people[i] = new Person(Integer.parseInt(str[0]), Integer.parseInt(str[1]), i + 1);
		}
		
		Arrays.sort(people);

		for(Person p : people) {
            System.out.println(p.h + " " + p.w + " " + p.idx);
        }
	}
}
