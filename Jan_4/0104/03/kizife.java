import java.util.Scanner;

public class Main {

    static long[] layers; //레벨별 햄버거 레이어 크기
    static long[] patties; //레벨별 패티 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long x = sc.nextLong();
        layers = new long[n + 1];
        patties = new long[n + 1];
        layers[0] = 1; //레벨0에는 레이어 1장
        patties[0] = 1; //그게 패티 1장..

        for (int i = 1; i <= n; i++) {
            layers[i] = (layers[i - 1] * 2) + 3;
            patties[i] = (patties[i - 1] * 2) + 1;
        }

        long result = eatPatties(n, x);
        System.out.println(result);

    }

    private static long eatPatties(int level, long index) {
        long count = 0;
        long center = (layers[level] / 2) + 1; //현재레벨의 중앙 패티 위치

        if (level == 0) return 1; //레벨0이면 패티는 1개
        if (index == 1) return 0; //x = 1이면 패티 못 먹으니까 0장

        //x = 햄버거 맨끝이면 다 먹은 거니까 패티 전체 크기 출력
        if (index == layers[level]) return (patties[level - 1] * 2) + 1;

        else if (index < center) { //햄버거의 한쪽 부분 확인
            count += eatPatties(level - 1, index - 1);
        } else if (index == center) { //중앙까지 먹는다면
            count += patties[level - 1] + 1; //이전레벨 패티수+1
        } else { //중앙보다 더 먹으면.. 초과한 부분 알아야...
            count += patties[level - 1] + 1 + eatPatties(level - 1, index - layers[level - 1] - 2);
        }

        return count;
    }
}
