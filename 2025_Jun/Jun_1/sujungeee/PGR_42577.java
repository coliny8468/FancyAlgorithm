// https://school.programmers.co.kr/learn/courses/30/lessons/42577?language=java

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

/**
 * 42577: 전화번호 목록
 * # summary
 * : 한 번호가 다른 번호의 접두어이면 -> false
 * , 접두어가 없으면 -> true
 * # logic
 * 1. 맨 앞 전화번호를 해시 set에 넣기.
 * 2. 두 번째 전화번호부터 부분 문자열을 추출해서 해시 set 안에 있는지 확인하고
 *    , 있으면 false return
 * 3. 전체 다 돌았는데도 없으면 true return
 */

class Solution42577 {
    public boolean solution(String[] phone_book) {
        // 1
        Set<String> set = new HashSet<>();
        set.add(phone_book[0]);

        // 2
        for (int i = 1; i < phone_book.length; i++) {
            StringBuilder partStr = new StringBuilder();
            for (int j = 0; j < phone_book[i].length(); j++) {
                partStr.append(phone_book[i].charAt(j));
                if (set.contains(partStr.toString())) {
                    return false;
                }
            }
            set.add(phone_book[i]);
        }

        return true;
    }
}

class Solution42577_2 {
    public boolean solution(String[] phone_book) {
        // 사전 순으로 정렬하기
        Arrays.sort(phone_book);

        // 사전 순으로 정렬한 인접한 두 단어를 비교하여, 접두어가 있는지 없는지 확인
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }
}

public class PGR_42577 {
    public static void main(String[] args) {
        Solution42577 s = new Solution42577();

        System.out.println(s.solution(new String[] {"119", "97674223", "1195524421"}));
        System.out.println(s.solution(new String[] {"123","456","789"}));
        System.out.println(s.solution(new String[] {"12","123","1235","567","88"}));
    }
}