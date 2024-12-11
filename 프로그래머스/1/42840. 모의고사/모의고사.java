import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        int[][] people = new int[][] {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        Map<Integer, Integer> map = new HashMap<>() {{
            put(1, 0);
            put(2, 0);
            put(3, 0);
        }};
        
        for (int i=0; i<answers.length; ++i) {
            for (int j=0; j<3; ++j) {
                if (answers[i] == people[j][i%people[j].length]) {
                    map.put(j+1, map.get(j+1)+1);
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for (int value : map.values()) {
            if (value > max) {
                max = value;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                list.add(key);
            }
        }
        
        answer = new int[list.size()];
        for (int i=0; i<answer.length; ++i) {
            answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}