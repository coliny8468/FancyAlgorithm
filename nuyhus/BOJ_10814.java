import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable {
        int age;
        String name;

        Node(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Object o) {
            Node node = (Node) o;
            return this.age - node.age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            nodes[i] = new Node(age, name);
        }

        StringBuilder sb = new StringBuilder();
        Arrays.sort(nodes);
        for (Node temp : nodes) {
            sb.append(temp.age + " " + temp.name + "\n");
        }
        System.out.println(sb);
    }
}
