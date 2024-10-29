import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; ++t) {
			int[] nums = new int[10];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int sum = 0;
			for (int i=0; i<nums.length; ++i) {
				sum += Integer.parseInt(st.nextToken());
			}
			
			System.out.println("#" + t + " " + (int)Math.round((double)sum/nums.length));
		}

	}

}
