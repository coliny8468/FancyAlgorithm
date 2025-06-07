// https://school.programmers.co.kr/learn/courses/30/lessons/340212

/**
 * 340212: [PCCP 기출문제 2번] / 퍼즐 게임 챌린지
 * # summary
 * : 소요 시간이 limit 이하인 최소 숙련도를 구하자!
 * # access
 * limit을 만족하는 최소 숙련도는 주어진 가장 작은 숙련도와 가장 큰 숙련도 사이에 있다.
 * 따라서 저 사이에서 limit 이하의 충족되는 숙련도가 있다면 answer로 넣고 더 이하의 숙련도가 limit를 충족시키는지 확인해야 함.
 * 다만, 연산 속도를 고려할 때 O(N)은 무리라고 판a단됨.
 * 이유: 전체 시간을 연산할 때 이미 O(N)인데 N이 최대 300,000이기 때문
 * => 결론: 숙련도를 찾을 때, 이진 탐색을 해보자!
 * # logic
 * 1. diff의 최소/최대 숙련도를 이진 탐색 범위로 산정
 * 2. calculate(): level에 의해 계산되는 전체 소요 시간
 * 3. binarySearch()
 *      3-1. 최소/최대의 중간(mid)로부터 전제 소요 시간을 구하기
 *      3-2. 해당 시간이 limit 아래이면, 더 아래 숙련도를 찾아야 하므로 answer에 저장하고 right를 mid - 1로 갱신
 *          해당 시간이 limit 위라면, 더 위 숙련도를 찾아야 하므로 left를 mid + 1로 갱신
 * 4. 가장 작은 숙련도인 answer 출력
 */

class Solution340212 {
    static int[] diffs;
    static int[] times;
    static long limit;
    static int puzzleCnt; // 퍼즐 개수
    static int maxLevel; // 최대 숙련도
    static int minLevel; // 최소 숙련도
    static int answer;

    public int solution(int[] tDiffs, int[] tTimes, long tLimit) {
        diffs = tDiffs;
        times = tTimes;
        limit = tLimit;
        puzzleCnt = diffs.length;

        maxLevel = 0;
        minLevel = Integer.MAX_VALUE;
        for (int i = 0; i < puzzleCnt; i++) {
            if (maxLevel < diffs[i]) maxLevel = diffs[i];
            if (minLevel > diffs[i]) minLevel = diffs[i];
        }

        binarySearch();

        return answer;
    }

    void binarySearch() {
        int left = minLevel;
        int right = maxLevel;
        int cur = maxLevel;

        while (left <= right) {
            int mid = (left + right) / 2;
            long totalTime = calculate(mid);

            if (totalTime <= limit) {
                cur = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        answer = cur;
    }

    long calculate(int level) {
        long total = 0L;
        for (int cur = 0; cur < puzzleCnt; cur++) {
            if (level >= diffs[cur]) {
                total += times[cur];
            } else {
                if (cur == 0) {
                    total += times[cur] + (long) times[cur] * (diffs[cur] - level);
                } else {
                    total += times[cur] + (long) (times[cur - 1] + times[cur]) * (diffs[cur] - level);
                }
            }
        }
        return total;
    }
}

public class PGR_340212 {
    public static void main(String[] args) {
        Solution340212 s = new Solution340212();

        System.out.println(s.solution(new int[]{1, 5, 3}, new int[] {2, 4, 7}, 30));
        System.out.println(s.solution(new int[]{1, 4, 4, 2}, new int[] {6, 3, 8, 2}, 59));
        System.out.println(s.solution(new int[]{1, 328, 467, 209, 54}, new int[] {2, 7, 1, 4, 3}, 1723));
        System.out.println(s.solution(new int[]{1, 99999, 100000, 99995}, new int[] {9999, 9001, 9999, 9001}, 3456789012L));
    }
}