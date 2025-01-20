import java.util.*;
import java.io.*;

public class BOJ_2877 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = Integer.toBinaryString(Integer.parseInt(br.readLine()) + 1).replace("0", "4").replace("1", "7");

        System.out.println(n.substring(1, n.length()));
    }
}