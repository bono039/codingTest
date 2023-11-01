import java.util.*;
import java.io.*;

class Product {
    String name, code;

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    @Override
    public String toString() {
        return "product " + this.code + " is " + this.name;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        Product p1 = new Product("codetree", "50");
        Product p2 = new Product(str[0], str[1]);

        System.out.println(p1);
        System.out.println(p2);
    }
}
