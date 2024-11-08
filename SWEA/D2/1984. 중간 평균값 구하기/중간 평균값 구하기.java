import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; ++t) {
			int[] nums = new int[10];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0; i<nums.length; ++i) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(nums);
			
			double sum = 0;
			for (int i=1; i<nums.length-1; ++i) {
				sum += nums[i];
			}
			
			System.out.println("#" + t + " " + Math.round(sum/(nums.length-2)));
		}
	}

}
