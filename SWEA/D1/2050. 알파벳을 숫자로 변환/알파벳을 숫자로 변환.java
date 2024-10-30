import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		char[] arr = str.toCharArray();
		
		for (int i=0; i<arr.length; ++i) {
			if (Character.isUpperCase(arr[i])) {
				System.out.printf("%d ", arr[i]-64);
			}
			else {
				System.out.printf("%d ", arr[i]-95);
			}
		}
		
		
	}

}
//소문자 96 / 대문자 65