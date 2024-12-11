import java.util.*;

class Solution {
    Map<Integer, Integer> days = new HashMap<>() {{
        put(1, 31);
        put(2, 29);
        put(3, 31);
        put(4, 30);
        put(5, 31);
        put(6, 30);
        put(7, 31);
        put(8, 31);
        put(9, 30);
        put(10, 31);
        put(11, 30);
        put(12, 31);
    }};
    
    Map<Integer, String> week = new HashMap<>() {{
        put(0, "FRI");
        put(1, "SAT");
        put(2, "SUN");
        put(3, "MON");
        put(4, "TUE");
        put(5, "WED");
        put(6, "THU");
    }};
    
    public String solution(int a, int b) {
        String answer = "";
        
        int totalDay = 0;
        for (int i=1; i<a; ++i) {
            totalDay += days.get(i);
        }
        
        totalDay += b-1;
        answer = week.get(totalDay % 7);
        
        return answer;
    }
}