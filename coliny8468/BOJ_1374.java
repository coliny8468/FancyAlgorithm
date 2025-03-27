import java.util.*;

public class Main {
    static class ClassInfo {
        int num;
        int start;
        int end;

        public ClassInfo(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<ClassInfo> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ClassInfo(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(list, Comparator.comparingInt((ClassInfo a) -> a.end).reversed());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (ClassInfo lecture : list) {
            if (!pq.isEmpty() && pq.peek() >= lecture.end) {
                pq.poll();
            }
            pq.add(lecture.start);
        }

        System.out.println(pq.size());
    }
}
