import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> scoreSet = new HashMap<>();
        
        for(int i = 0; i < name.length; i++){
            scoreSet.put(name[i], yearning[i]);
        }
        
        for(int i = 0; i < photo.length ;i++){
            int score = 0;
            for(int j = 0; j < photo[i].length; j++){
                score += scoreSet.getOrDefault(photo[i][j], 0);
            }
            answer[i] = score;
        }

        
        
        return answer;
    }
}
