import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i=1; i<=N; ++i) {
			int count = clapCount(i);
			if (count > 0) {
				for (int j=0; j<count; ++j) {
					System.out.print("-");
				}
			}
			else {
				System.out.print(i);
			}
			System.out.print(" ");
		}
		
	}
	
	public static int clapCount(int num) {
		int count = 0;
		char[] arr = String.valueOf(num).toCharArray();
		
		for (int i=0; i<arr.length; ++i) {
			if (arr[i] == '3' || arr[i] == '6' || arr[i] == '9') {
				++count;
			}
		}
		
		return count;
	}

}
