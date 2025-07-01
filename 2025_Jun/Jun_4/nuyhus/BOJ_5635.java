import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Person implements Comparable<Person> {
        String name;
        int dd;
        int mm;
        int yy;

        Person(String[] input) {
            this.name = input[0];
            dd = Integer.parseInt(input[1]);
            mm = Integer.parseInt(input[2]);
            yy = Integer.parseInt(input[3]);
        }

        @Override
        public int compareTo(Person o) {
            if (this.yy == o.yy) {
                if (this.mm == o.mm) {
                    return Integer.compare(this.dd, o.dd);
                }

                return Integer.compare(this.mm, o.mm);
            }

            return Integer.compare(this.yy, o.yy);
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Person[] persons = new Person[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String[] input = new String[4];
            for (int j = 0; j < 4; j++) {
                input[j] = st.nextToken();
            }
            persons[i] = new Person(input);
        }

        Arrays.sort(persons);

        System.out.println(persons[n - 1]);
        System.out.println(persons[0]);
    }
}
