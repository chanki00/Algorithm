class Solution {
    public String solution(String s) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        
        int wordIdx = 0;
        for (int i=0; i<s.length(); ++i) {
            if (arr[i] == ' ') {
                wordIdx = 0;
                sb.append(arr[i]);
                continue;
            }
            
            if (wordIdx % 2 == 0) {
                arr[i] = Character.toUpperCase(arr[i]);
            }
            else {
                arr[i] = Character.toLowerCase(arr[i]);
            }
            sb.append(arr[i]);
            ++wordIdx;
        }
        
        answer = sb.toString();
        
        return answer;
    }
}