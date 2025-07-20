import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> reserveSet = Arrays.stream(reserve).boxed().collect(Collectors.toSet());
        Set<Integer> lostSet = Arrays.stream(lost).boxed().collect(Collectors.toSet());


        Set<Integer> intersection = new HashSet<>(reserveSet);
        intersection.retainAll(lostSet);
        reserveSet.removeAll(intersection);
        lostSet.removeAll(intersection);

        List<Integer> lostList = new ArrayList<>(lostSet);
        Collections.sort(lostList);  

        int cnt = 0;
        for (int l : lostList) {
            if (reserveSet.contains(l - 1)) {
                reserveSet.remove(l - 1);
                cnt++;
            } else if (reserveSet.contains(l + 1)) {
                reserveSet.remove(l + 1);
                cnt++;
            }
        }

        return n - lostSet.size() + cnt;
    }
}
