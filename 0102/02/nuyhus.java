import java.io.*;
import java.util.*;

public class nuyhus {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
        }

        List<Integer> timeList = new ArrayList<>(map.keySet());
        Collections.sort(timeList);
        int sum = 0;
        int max = 0;
        int startTime = 0;
        int endTime = 0;
        boolean isMax = false;
        for (int time : timeList) {
            sum += map.get(time);
            if (sum > max) {
                startTime = time;
                max = sum;
                isMax = true;
            } else if (sum != max && isMax) {
                endTime = time;
                isMax = false;
            }
        }

        System.out.println(max);
        System.out.println(startTime + " " + endTime);
    }
}