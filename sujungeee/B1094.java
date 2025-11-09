import java.io.*;

public class Main {
    static int x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine());

        int minSticks = Integer.bitCount(x);

        System.out.println(minSticks);
    }
}