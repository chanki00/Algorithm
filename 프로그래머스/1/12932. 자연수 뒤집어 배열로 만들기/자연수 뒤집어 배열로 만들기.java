class Solution {
    public int[] solution(long n) {
        int[] answer;
        
        int count = 0;
        long tmp = n;
        while (tmp > 0) {
            ++count;
            tmp /= 10;
        }
        
        answer = new int[count];
         
        int idx = 0;
        while (n > 0) {
            answer[idx] = (int) (n % 10);
            n /= 10;
            ++idx;
        }
        
        return answer;
    }
}