import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        int[] heights = new int[W];
        for (int i = 0; i < W; i++) {
            heights[i] = scanner.nextInt();
        }

        // 왼쪽 최대 높이와 오른쪽 최대 높이 배열 계산
        int[] leftMax = new int[W];
        int[] rightMax = new int[W];

        leftMax[0] = heights[0];
        for (int i = 1; i < W; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], heights[i]);
        }

        rightMax[W - 1] = heights[W - 1];
        for (int i = W - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], heights[i]);
        }

        // 고이는 빗물 계산
        int totalWater = 0;
        for (int i = 0; i < W; i++) {
            int water = Math.min(leftMax[i], rightMax[i]) - heights[i];
            if (water > 0) {
                totalWater += water;
            }
        }

        // 결과 출력
        System.out.println(totalWater);
    }
}
