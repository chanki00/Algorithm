import java.util.*;
import java.io.*;
/*
- 최소 필요 피로도(던전 시작을 위한) / 소모 피로도(던전 탐험 끝날 때)
- 최대한 많이 탐험 -> 현재 피로도 k / [최소][소모]
*/


class Solution {
    
    int max = Integer.MIN_VALUE;
    boolean[] v;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        v = new boolean[dungeons.length];
        recursive(dungeons, new int[dungeons.length], 0, k);
        answer = max;
        
        return answer;
    }
    
    public void recursive(int[][] dungeons, int[] sel, int idx, int stamina) {        
        if (idx == dungeons.length) {
            chk(dungeons, sel, stamina);
            return;
        }
        
        for (int i=0; i<dungeons.length; ++i) {
            if (!v[i]) {
                v[i] = true;
                sel[idx] = i;
                recursive(dungeons, sel, idx+1, stamina);
                v[i] = false;
            }
        }
    }
    
    public void chk(int[][] dungeons, int[] sel, int stamina) {
        int count = 0;
        for (int i=0; i<dungeons.length; ++i) {
            if (stamina >= dungeons[sel[i]][0]) {
                ++count;
                stamina -= dungeons[sel[i]][1];
            }
        }
        max = Math.max(max, count);
    }
}