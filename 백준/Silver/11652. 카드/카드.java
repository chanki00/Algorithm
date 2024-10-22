import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Long[] card = new Long[N];
        for (int i = 0; i < N; ++i) {
            card[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(card);

        findMaxCount(card);
    }

    public static void findMaxCount(Long[] card) {
        Map<Long, Integer> map = new HashMap<>(); //num, count
        int count = 0;
        long prevNum = card[0];

        for (int i = 0; i < card.length; ++i) {
            if (card[i] != prevNum) {
                map.put(prevNum, count);
                count = 0;
                prevNum = card[i];
            }
            ++count;
        }

        map.put(card[card.length-1], count);

        System.out.println(findMinNum(map));

    }

    public static long findMinNum(Map<Long, Integer> map) {
        long minNum = Long.MAX_VALUE;
        int maxCount = 0;

        ArrayList<Long> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> {
            return Long.compare(a, b);
        });

        for (long l : list) {
            if (map.get(l) > maxCount) {
                maxCount = map.get(l);
                minNum = l;
            }
        }

        return minNum;
    }
}

