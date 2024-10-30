import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=0; t<T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			boolean[] used = new boolean[N+1];
			
			long floor = 0;
			
			for (int i=1; i<=N; ++i) {
				floor += i;
				used[i] = true;
				if (floor == P) {
					floor -= findMinFloor(used);
				}
			}
			
			System.out.println(floor);
			
		}

	}
	
	public static int findMinFloor(boolean[] used) {
		for (int i=1; i<used.length; ++i) {
			if (used[i]) {
				return i;
			}
		}
		
		return 0;
	}

}
