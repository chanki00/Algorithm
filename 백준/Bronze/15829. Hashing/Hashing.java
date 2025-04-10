import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int r = 31;
	static int M = 1234567891;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		String s = br.readLine();
		long result = 0;
		for (int i=0; i<L; ++i) {
			result += (s.charAt(i)-'a'+1)*(int)(Math.pow(r, i)) % M;
		}
		
		System.out.println(result);
	}
}
