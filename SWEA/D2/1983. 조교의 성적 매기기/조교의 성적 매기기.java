import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static List<Double> ratio = Arrays.asList(0.35, 0.45, 0.2);
	static List<String> grade = Arrays.asList("A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0");
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			Double[] scores = new Double[N];
			
			for (int i=0; i<N; ++i) {
				st = new StringTokenizer(br.readLine());
				scores[i] = conversionScore(st);
			}
			
			double currScore = scores[K-1];
			Arrays.sort(scores, Comparator.reverseOrder());
			
			System.out.println("#" + t + " " + grade.get(findRank(scores, currScore)));
			
			
		}
	}
	
	public static double conversionScore(StringTokenizer st) {
		double total = 0;
		for (int i=0; i<3; ++i) {
			total += Integer.parseInt(st.nextToken()) * ratio.get(i);
		}
		
		return total;
	}
	
	public static int findRank(Double[] scores, double currScore) {
		int idx;

		for (idx = 0; idx<scores.length; ++idx) {
			if (scores[idx] == currScore) return idx / (scores.length / 10);
		}
		
		return idx;
		
	}
}
