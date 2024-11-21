/******************************************************************************
- N개의 레벨 존재
- 각 레벨 클리어마다 점수 주어짐
- 플레이어 점수 = 각 레벨 클리어 점수의 합
- 점수를 바탕으로 온라인 순위 매김
- 레벨을 난이도 순으로 배치 -> but 쉬운 레벨 점수가 더 높은 경우를 만듦
- 따라서 특정 레벨 점수 감소를 원함 -> 오름차순이 되게
- 최소 몇 번 감소시키면 클리어 점수가 오름차순이 될까? (1번 감소 마다 1 감소)
*******************************************************************************/

import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] scores = new int[N];
        
        for (int i=0; i<N; ++i) {
            scores[i] = Integer.parseInt(br.readLine());
        }
        
        int count = 0;
        for (int i=N-1; i>0; --i) {
            int gap = scores[i-1] - scores[i] + 1;
            if (gap > 0) {
                count += gap;
                scores[i-1] -= gap;
            }
        }
        
        System.out.println(count);
	}
}
