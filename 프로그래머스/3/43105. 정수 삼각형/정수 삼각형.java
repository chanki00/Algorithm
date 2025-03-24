import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int[][] sum = new int[triangle.length][1];
        sum[0][0] = triangle[0][0];
        
        for (int i=0; i<triangle.length-1; ++i) {
            sum[i+1] = new int[triangle[i+1].length];
            for (int j=0; j<sum[i].length; ++j) {
                sum[i+1][j] = Math.max(sum[i+1][j], sum[i][j]+triangle[i+1][j]);
                sum[i+1][j+1] = Math.max(sum[i+1][j+1], sum[i][j]+triangle[i+1][j+1]);
            }
        }
        
        // for (int i=0; i<sum.length; ++i) {
        //     System.out.println(Arrays.toString(sum[i]));
        // }
        
        
        int l = sum.length-1;
        
        for (int i=0; i<sum[l].length; ++i) {
            answer = Math.max(answer, sum[l][i]);
        }
        
        return answer;
    }
    
    public int getSum(int n) {
        int sum = 0;
        
        for (int i=1; i<=n; ++i) {
            sum += i;
        }
        
        return sum;
    }
}