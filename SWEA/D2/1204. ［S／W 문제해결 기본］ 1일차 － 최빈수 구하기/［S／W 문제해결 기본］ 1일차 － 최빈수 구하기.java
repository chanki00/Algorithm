import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; ++t) {
			br.readLine();
			
			HashMap<Integer, Integer> map = new HashMap<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int score = Integer.parseInt(st.nextToken());
				if (map.containsKey(score)) {
					map.put(score,map.get(score)+1);
				}
				else {
					map.put(score, 1);
				}
			}
			
			int max = Integer.MIN_VALUE;
			int maxScore = -1;
			
			for (int s : map.keySet()) {
				if (map.get(s) >= max && s > maxScore) {
					max = map.get(s);
					maxScore = s;
				}
			}
			
			System.out.println("#" + t + " " + maxScore);
		}
	}

}
