import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            int doll = getDoll(board, move-1);
            if (doll != 0) {
                if (stack.empty()) {
                    stack.push(doll);
                }
                else {
                    if (stack.peek() == doll) {
                        stack.pop();
                        answer += 2;
                    }
                    else {
                        stack.push(doll);
                    }
                }
            }
        }
        
        return answer;
    }
    
    public int getDoll(int[][] board, int move) {
        for (int i=0; i<board.length; ++i) {
            if (board[i][move] > 0) {
                int doll = board[i][move];
                board[i][move] = 0;
                return doll;
            }
        }
        
        return 0;
    } 
}