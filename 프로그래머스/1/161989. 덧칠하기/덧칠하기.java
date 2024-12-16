class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int curr = 0;
        for (int i=0; i<section.length; ++i) {
            if (curr < section[i]) {
                ++answer;
                curr = section[i] + m - 1;
            }
        }
        
        return answer;
    }
}