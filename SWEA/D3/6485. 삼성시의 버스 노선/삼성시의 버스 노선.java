import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; ++t) {
			int N = Integer.parseInt(br.readLine());
			int[] A = new int[N];
			int[] B = new int[N];
			
			Map<Integer, Integer> map = new HashMap<>();
			
			for (int i=0; i<N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				A[i] = Integer.parseInt(st.nextToken());
				B[i] = Integer.parseInt(st.nextToken());
				for (int j=A[i]; j<=B[i]; ++j) {
					if (!map.containsKey(j)) {
						map.put(j, 1);
					}
					else {
						map.put(j, map.get(j)+1);
					}
				}
			}
			
			int P = Integer.parseInt(br.readLine());
			int[] arr = new int[P];
			for (int i=0; i<P; ++i) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			
			System.out.print("#" + t + " ");
			for (int a : arr) {
				if (map.containsKey(a)) {
					System.out.print(map.get(a) + " ");
				}
				else {
					System.out.print(0 + " ");
				}
			}
			System.out.println();
			
			
		}
	}

}
