import java.util.*;
import java.io.*;

public class nuyhus {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] height = new int[W];
        for(int i=0; i<W; i++) height[i] = Integer.parseInt(st.nextToken());

        int rain = 0;

        for(int i=1; i<W-1; i++) {
            int leftHeight = 0;
            int rightHeight = 0;

            for(int j=0; j<i; j++) {
                leftHeight = Math.max(height[j], leftHeight);
            }

            for(int j=(i+1); j<W; j++) {
                rightHeight = Math.max(height[j], rightHeight);
            }

            if(height[i] < leftHeight && height[i] < rightHeight) rain += Math.min(leftHeight, rightHeight) - height[i];
        }
        System.out.println(rain);
    }
}