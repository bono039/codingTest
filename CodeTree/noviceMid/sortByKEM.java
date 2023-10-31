import java.util.*;
import java.io.*;

class Student implements Comparable<Student> {
    String name;
    int k, e, m;

    public Student(String name, int k, int e, int m) {
        this.name = name;
        this.k = k; this.e = e; this.m = m;
    }

    @Override
    public int compareTo(Student st) {
        if(st.k == this.k) {
            if(st.e == this.e) {
                return st.m - this.m;
            }
            return st.e - this.e;
        }
        return st.k - this.k;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Student[] students = new Student[N];
        for(int i = 0 ; i < N ; i++) {
            String[] str = br.readLine().split(" ");
            students[i] = new Student(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]), Integer.parseInt(str[3]));
        }

        Arrays.sort(students);  // 우선순위 국영수 순 정렬

        for(Student s : students) {
            System.out.println(s.name + " " + s.k + " " + s.e + " " + s.m);
        }
    }
}
