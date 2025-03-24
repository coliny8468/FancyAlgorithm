
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int hanX = sc.nextInt();
        int hanY = sc.nextInt();
        int rightX = sc.nextInt();
        int rightY = sc.nextInt();

        List<Integer> min = new ArrayList<>();
        min.add(hanX);
        min.add(hanY);
        min.add(Math.abs(rightX-hanX));
        min.add(Math.abs(rightY-hanY));

        min.sort(Comparator.naturalOrder());

        System.out.println(min.get(0));
    }
}
