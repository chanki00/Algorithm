import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        // 클리어못한 플레이어 수 / 도달한 플레이어 수(지나간 사람도 해당)
        // 실패율이 같으면 스테이지의 오름차순
        
        List<Rate> rateList = new ArrayList<>();
        
        int[] counts = new int[N];
        Arrays.sort(stages);
        for (int stage : stages) {
            if (stage > N) break;
            
            ++counts[stage-1];
        }
        
        int length = stages.length;
        for (int i=0; i<counts.length; ++i) {
            double failedRate = length != 0 ? (double) counts[i] / length : 0;
            Rate rate = new Rate(failedRate, i+1);
            length -= counts[i];
            rateList.add(rate);
        }
        
        rateList.sort((o1, o2) -> Double.compare(o2.failedRate, o1.failedRate));
        int idx = 0;
        for (Rate rate : rateList) {
            answer[idx++] = rate.idx; 
        }
        
        return answer;
    }
    
    class Rate {
        double failedRate;
        int idx;
        
        Rate(double failedRate, int idx) {
            this.failedRate = failedRate;
            this.idx = idx;
        }
    }
}