import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; ++t) {
			int N = Integer.parseInt(br.readLine());
			int[] prices = new int[N];
			int[] maxList = new int[N];
			
			long total = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; ++i) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			
			int maxIdx = findMaxIdx(prices, 0);
			int currMax = prices[maxIdx];
			
			for (int i=0; i<N; ++i) {
				if (i > maxIdx) {
					maxIdx = findMaxIdx(prices, i);
					currMax = prices[maxIdx];
				}
				
				if (i < maxIdx) {
					total += currMax - prices[i];
				}
			}
			
			System.out.println("#" + t + " " + total);
			
		}
	}
	
	public static int findMaxIdx(int[] prices, int startIdx) {
		
		int max = Integer.MIN_VALUE;
		int maxIdx = startIdx;
			
		for (int i=startIdx; i<prices.length; i++) {
			if (prices[i] >= max) {
				max = prices[i];
				maxIdx = i;
			}
		}
		
		return maxIdx;
	}

}
