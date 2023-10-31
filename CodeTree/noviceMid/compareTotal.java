import java.util.*;
import java.io.*;
class Student implements Comparable<Student> {
    String name;
    int a,b,c;
    public Student(String name, int a, int b, int c) {
        this.name = name;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public int compareTo(Student st) {	// 총점 기준 오름차순 정렬
        return (this.a + this.b + this.c) - (st.a + st.b + st.c);
    }
}
public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
        Student[] students = new Student[n];
		for(int i = 0 ; i < n ; i++) {
		    String[] str = br.readLine().split(" ");
            students[i] = new Student(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]), Integer.parseInt(str[3]));
		}
		
		Arrays.sort(students);
		
        for(Student s : students) {
            System.out.println(s.name + " " + s.a + " " + s.b + " " + s.c);
        }
	}
}
