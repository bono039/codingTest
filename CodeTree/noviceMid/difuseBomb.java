import java.util.*;
import java.io.*;

class Node {
    String code, color, second;

    public Node(String code, String color, String second) {
        this.code = code;
        this.color = color;
        this.second = second;
    }

    @Override
    public String toString() {
        return "code : " + this.code + "\n" + "color : " + this.color + "\n" + "second : " + this.second;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        Node node = new Node(str[0], str[1], str[2]);
        System.out.println(node);
    }
}
