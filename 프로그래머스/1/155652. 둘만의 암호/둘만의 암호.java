//a = 97, z = 122
class Solution {
    
    public String solution(String s, String skip, int index) {
        String answer = "";
        char[] arr = s.toCharArray();
        
        for (int i = 0; i < s.length(); ++i) {
            int tmpIdx = 0;
            int realIdx = 0;
            char c = s.charAt(i);

            while (tmpIdx < index) {
                ++realIdx;
                char currC = (char) ('a' + ((c + realIdx) - 97) % 26);
                if (skip.contains(String.valueOf(currC))) {
                    continue;
                }
                ++tmpIdx;
            }
            arr[i] = (char) ('a' + ((c + realIdx) - 97) % 26);
        }
        
        answer = String.valueOf(arr);
        
        return answer;
    }
}