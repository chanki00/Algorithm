class Solution {
    
    int MOD = 1234567;
    
    public int solution(int n) {
        int answer = 0;
        
        int[] memo = new int[n+1];
        memo[1] = 1;
        memo[2] = 1;
        for (int i=3; i<=n; ++i) {
            memo[i] = (memo[i-2] + memo[i-1]) % MOD;
        }
        
        answer = memo[n];
        
        return answer;
    }
}