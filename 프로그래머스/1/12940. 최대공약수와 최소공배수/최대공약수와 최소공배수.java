class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        if (n > m) {
            int tmp = n;
            n = m;
            m = tmp;
        }
        
        answer[0] = 1;
        for (int i=2; i<=n; ++i) {
            if (n % i == 0 && m % i == 0) answer[0] = i;
        }
        
        int tmpN = n;
        int tmpM = m;
        while (tmpN != tmpM) {
            tmpN += n;
            if (tmpN > tmpM) {
                tmpM += m;
            }
        }
        
        answer[1] = tmpN;
        
        return answer;
    }
}