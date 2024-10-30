import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int max = -1;
			for (int i=0; i<10; ++i) {
				int currNum = Integer.parseInt(st.nextToken());
				if (currNum > max) {
					max = currNum;
				}
			}
			
			System.out.println("#" + t + " " + max);
		}
		
		
	}
}
