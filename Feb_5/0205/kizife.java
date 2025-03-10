import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        Map<Character, Integer> map = new HashMap<>();

        for (String word : words) {
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char ch = word.charAt(i);
                int weight = (int) Math.pow(10, length-i-1); //몇의자리숫자인지?? int화
                map.put(ch, map.getOrDefault(ch, 0) + weight); //가중치를 누적해서 저장함... 키값이랑 
            }
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue()); //내림차순 정렬. b.getValue() - a.getValue()란?? 둘 중 큰 값을 앞으로 

        Map<Character, Integer> assignMap = new HashMap<>();
        int num = 9; //가장 큰 수 설정 (여기부터 삽입할 것) 
        for (Map.Entry<Character, Integer> entry : list) { //list에 있는 것들 꺼내면서...
          //가중치 큰 것부터 나오게 되어 있으니, 9부터 순차적으로 대입해 줌 
            assignMap.put(entry.getKey(), num--);
        }

        int sum = 0;
        for (String word: words) {
            int value = 0;
            for (char ch : word.toCharArray()) {
                value = value*10 + assignMap.get(ch); //자릿수 하나씩 밀어가면서(?) 숫자로 변환하기  
            }
            sum += value; //숫자들 더하기 
        }

        System.out.println(sum);
    }
}
