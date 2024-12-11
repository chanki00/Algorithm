class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i=0; i<nums.length; ++i) {
            answer += add(i+1, nums, 1, nums[i]);
        }

        return answer;
    }
    
    public int add(int idx, int[] nums, int count, int sum) {
        if (count >= 3) {
            return isPrime(sum) ? 1 : 0;
        }
        
        int primeCount = 0;
        for (int i=idx; i<nums.length; ++i) {
             primeCount += add(i+1, nums, count+1, sum + nums[i]);
        }
        
        return primeCount;
    }
    
    public boolean isPrime(int num) {
        for (int i=2; i*i<=num; ++i) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}