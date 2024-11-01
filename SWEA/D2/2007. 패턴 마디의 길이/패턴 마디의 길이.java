import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; ++t) {
			String str = br.readLine();
			
			int length = Integer.MAX_VALUE;
			
			for (int i=10; i>0; --i) {
				if (str.substring(0, i).equals(str.substring(i, 2 * i))) {
					if (i < length) {
						length = i;
					}
				}
			}
			
			System.out.println("#" + t + " " + length);
		}
	}
}
