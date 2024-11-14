import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class Solution {
	
	static Map<String, Integer> nums = new HashMap<String, Integer>() {{
        put("ZRO", 0);
        put("ONE", 1);
        put("TWO", 2);
        put("THR", 3);
        put("FOR", 4);
        put("FIV", 5);
        put("SIX", 6);
        put("SVN", 7);
        put("EGT", 8);
        put("NIN", 9);
    }};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String c = st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			
			List<Digit> digits = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			
			while (st.hasMoreTokens()) {
				String s = st.nextToken();
				digits.add(new Digit(s, nums.get(s)));
			}
			
			java.util.Collections.sort(digits);
			
			System.out.println(c);
			for (Digit digit : digits) {
				System.out.print(digit.name + " ");
			}
			System.out.println();
		}
	}
	
	static class Digit implements Comparable<Digit> {
		private String name;
		private int num;
		
		public Digit(String name, int num) {
			this.name = name;
			this.num = num;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public void setNum(int num) {
			this.num = num;
		}
		
		@Override
		public int compareTo(Digit o) {
			return this.num - o.num;
		}
	}

}
