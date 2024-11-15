import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; ++t) {
			int N = Integer.parseInt(br.readLine());
			
			Set<Integer> set = new HashSet<>();
			
			int k = 0;
			while (set.size() < 10) {
				++k;
				int currNum = k * N;
				while (currNum > 0) {
					set.add(currNum % 10);
					currNum /= 10;
				}
			}
			
			System.out.println("#" + t + " " + k*N);
		}
	}

}
