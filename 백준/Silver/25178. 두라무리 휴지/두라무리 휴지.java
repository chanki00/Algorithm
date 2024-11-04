import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 한 단어를 재배열해 다른 단어를 만들 수 있어야 한다.
 * 2. 두 단어의 첫 글자와 마지막 글자 서로 동일
 * 3. a, e, i, o, u를 제거한 문자열 동일
 * @author USER
 *
 */

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String src = br.readLine();
		String dst = br.readLine();
		
		boolean isPossible = check(src, dst);
		if (!isPossible) {
			System.out.println("NO");
			return;
		}
		
		System.out.println(solve(src, dst));
		
		
		
	}
	
	public static boolean check(String src, String dst) {
		int[] counts = new int[26];
		
		
		for (int i=0; i<src.length(); ++i) {
			++counts[src.charAt(i) - 97];
			--counts[dst.charAt(i) - 97];
		}
		
		for (int i=0; i<counts.length; ++i) {
			if (counts[i] != 0) return false;
		}
		
		return src.charAt(0) == dst.charAt(0) && src.charAt(src.length()-1) == dst.charAt(dst.length() - 1);
	}
	
	public static String solve(String src, String dst) {
		StringBuilder srcBuilder = new StringBuilder();
		StringBuilder dstBuilder = new StringBuilder();
		
		String tmp = "aeiou";
		
		for (int i=0; i<src.length(); ++i) {
			if (tmp.indexOf(src.charAt(i)) == -1) {
				srcBuilder.append(src.charAt(i));
			}
			
			if (tmp.indexOf(dst.charAt(i)) == -1) {
				dstBuilder.append(dst.charAt(i));
			}
		}
		
		return srcBuilder.toString().equals(dstBuilder.toString()) ? "YES" : "NO";
	}
	

}
