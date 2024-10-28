import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 백준 1972
 * 대문자 알파벳으로 이룽진 문자열 -> D쌍 = 문자열 내에서 거리가 D인 두 문자를 순서대로 나열한 것
 * ZGBG -> 0쌍 = ZG, GB, BG / 1쌍 = ZB, GG / 2쌍 = ZG
 * 문자열의 길이가 N일 때 0쌍 ~ (N-2)쌍까지 정의
 * 어떤 문자열의 D쌍이 서로 다를 때 "D유일" -> 0유일 / 1유일 / 2유일
 * AAA -> 0유일X이지만 1유일
 * 모든 D에 대해 D유일이면 놀라운 문자열
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = br.readLine();
            if (str.equals("*")) break;
            if (isSurprise(str)) {
                System.out.println(str + " is surprising.");
            }
            else {
                System.out.println(str + " is NOT surprising.");
            }
        }

    }

    public static boolean isSurprise(String str) {
        ArrayList<ArrayList<String>> list = new ArrayList<>();


        for (int d = 0; d <= str.length() - 2; ++d) {
            list.add(new ArrayList<>());
            for (int i = 0; i < str.length() - 1 - d; ++i) {
                list.get(d).add(String.valueOf(str.charAt(i)) + String.valueOf(str.charAt(i+ 1 + d)));
            }
        }

        for (ArrayList<String> l : list) {
            Set<String> set = new HashSet<>();
            set.addAll(l);
            if (set.size() != l.size()) {
                return false;
            }
        }

        return true;
    }
}
