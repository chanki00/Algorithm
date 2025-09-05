import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, K;
	static long[] arr;
	static long[] tree;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 수의 개수
		M = Integer.parseInt(st.nextToken()); // 수의 변경이 일어나는 횟수
		K = Integer.parseInt(st.nextToken()); // 구간의 합을 구하는 횟수
		
		arr = new long[N];
		for (int i=0; i<N; ++i) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		int H = (int) Math.ceil(Math.log(N) / Math.log(2));
//		tree = new long[(int) Math.pow(2, H+1) - 1];
		tree = new long[(2 << (H+1) - 1)];
		
		init(0, N-1, 1);
		
		for (int m=0; m<M+K; ++m) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (a == 1) {
				long c = Long.parseLong(st.nextToken());
				update(b-1, c);
			}
			else {
				int c = Integer.parseInt(st.nextToken());
				System.out.println(query(b-1, c-1, 0, N-1, 1));
			}
		}
		
//		System.out.println(Arrays.toString(tree));
	}
	
	public static void init(int start, int end, int curr) {
		if (start == end) { // 리프 노드
			tree[curr] = arr[start];
		}
		else {
			init(start, (start+end)/2, 2*curr);
			init((start+end)/2 + 1, end, 2*curr+1);
			tree[curr] = tree[2*curr] + tree[2*curr+1];
		}
	}
	
	public static void update(int idx, long val) {
		long diff = val - arr[idx];
		arr[idx] = val;
		
		updateTree(0, N-1, idx, val, diff, 1);
	}
	
	public static void updateTree(int start, int end, int idx, long val, long diff, int curr) {
		if (idx < start || end < idx) {
			return;
		}
		
		tree[curr] += diff;

		if(start == end) {
			return;
		}
		
		updateTree(start, (start+end)/2, idx, val, diff, 2*curr);
		updateTree((start+end)/2 + 1, end, idx, val, diff, 2*curr+1);
	}
	
	public static long query(int left, int right, int start, int end, int curr) {
		long ret = 0;
		
		if (right < start || end < left) {
			return 0;
		}
		else if (left <= start && end <= right) {
			return tree[curr];
		}
		else {
			ret += query(left, right, start, (start+end)/2, 2*curr);
			ret += query(left, right, (start+end)/2 + 1, end, 2*curr+1);			 
		}
		
		return ret;
	}
}
