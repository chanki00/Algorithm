class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int[] count = new int[2];
        
        s = s.toLowerCase().replaceAll("[^py]", "");
        
        for (int i=0; i<s.length(); ++i) {
            if (s.charAt(i) == 'p') {
                ++count[0];
            }
            else {
                ++count[1];
            }
        }
        
        answer = count[0] == count[1];

        return answer;
    }
}