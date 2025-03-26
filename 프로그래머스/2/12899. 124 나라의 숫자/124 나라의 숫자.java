import java.io.*;
import java.util.*;

// 0 = 1
// 1 = 2
// 2 = 4

class Solution {
    public String solution(int n) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        
        while (n > 3) {
            sb.append(n%3);
            if (n%3 == 0) {
                --n;
            }
            if (n <= 3) {
                break;
            }
            n /= 3;
        }
        
        if (n < 3) {
            sb.append(n);
        }
        else {
            sb.append(n%3);
        }
        
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                sb.setCharAt(i, '4');
            }
        }
        
        answer = sb.reverse().toString();
        
        
        return answer;
    }
}