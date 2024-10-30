import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; ++t) {
			String str = br.readLine();
			
			String year = str.substring(0, 4);
			String month = str.substring(4, 6);
			String day = str.substring(6, 8);
			
			int monthNum = Integer.parseInt(month);
			int dayNum = Integer.parseInt(day);
			
			boolean isPossible = false;
			
			switch (monthNum) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				isPossible  = (dayNum <= 31 && dayNum >= 1);
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				isPossible = (dayNum <= 30 && dayNum >= 1);
				break;
			case 2:
				isPossible = (dayNum <=28 && dayNum >= 1);
				break;
			default:
				break;
			}
			
			if (isPossible) {
				System.out.println("#" + t + " " + year + "/" + month + "/" + day);
			}
			else {
				System.out.println("#" + t + " -1");
			}
			
		}
	}

}
