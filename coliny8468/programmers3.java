import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        Set<Character> skipSet = new HashSet<>();
        for (char c : skip.toCharArray()) skipSet.add(c);

        List<Character> alphabet = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            if (!skipSet.contains(c)) alphabet.add(c);
        }

        int n = alphabet.size();

        for (char c : s.toCharArray()) {
            int pos = alphabet.indexOf(c);      
            int newPos = (pos + index) % n;     
            sb.append(alphabet.get(newPos));
        }

        return sb.toString();
    }
}
