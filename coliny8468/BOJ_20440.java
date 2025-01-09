import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
class Time implements Comparable<Time> {
    long start;
    long end;
 
    public Time(long start, long end) {
        this.start = start;
        this.end = end;
    }
 
    @Override
    public int compareTo(Time o) {
        if (this.end < o.end) {
            return -1;
        } else if (this.end == o.end) {
            if (this.start < o.start) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return 1;
        }
    }
}
 
public class Main {
    static int n;
    static long[][] arr;
    static long a, b;
    static PriorityQueue<Time> queue = new PriorityQueue<>();
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new long[n][2];
 
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = Long.parseLong(s[0]);
            arr[i][1] = Long.parseLong(s[1]);
        }
 
        Arrays.sort(arr, (a, b) -> {
            if (a[0] <= b[0]) {
                return -1;
            } else {
                return 1;
            }
        });
        int max = 0;
        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty() && arr[i][0] > queue.peek().end) {
                queue.poll();
            }
            if(!queue.isEmpty() && arr[i][0] == queue.peek().end){
                if(queue.peek().end==b){
                    b = arr[i][1];
                }
                queue.poll();
            }
            queue.add(new Time(arr[i][0], arr[i][1]));
            if(queue.size()>max){
                max = queue.size();
                a = arr[i][0];
                b = queue.peek().end;
            }
        }
        System.out.println(max);
        System.out.println(a + " " + b);
    }
}
