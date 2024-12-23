import java.util.Scanner;

public class BOJ_11509 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = balloon(arr);

        System.out.println(answer);
    }

    private static int balloon(int[] arr) {
        int maxHeight = 0; //제일 높은 풍선 높이
        for (int height : arr) {
            if(height>maxHeight) {
                maxHeight = height;
            }
        }

        //최대높이 기준으로 화살 관리하는 배열
        int[] arrows = new int[maxHeight + 1];
        int count = 0;

        for (int height:arr) {
            if(arrows[height] >0) {
                arrows[height]--; //현재 높이에 화살 있으면 해당 화살 사용
                arrows[height-1]++; //사용된 화살->한칸 낮은 곳으로 이동
            } else {
                count++; //현재 높이에 화살 없으면 새 화살 추가
                arrows[height-1]++; //새 화살->한칸 낮은 곳으로 이동 
            }
        }

        return count;

    }
}
