import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; ++t) {
			String s = br.readLine();
			
			System.out.println("#" + t + " " + isPalindrome(s));
		}
	}
	
	public static int isPalindrome(String s) {		
		for (int i=0; i<s.length()/2; ++i) {
			if (s.charAt(i) != s.charAt(s.length()-1-i)) {
				return 0;
			}
		}
		
		return 1;
	}

}
