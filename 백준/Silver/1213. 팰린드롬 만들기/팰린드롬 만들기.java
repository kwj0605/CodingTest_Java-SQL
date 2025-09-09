import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        sc.close();

        int[] alp = new int[26];

        StringBuilder sb = new StringBuilder();
        StringBuilder start = new StringBuilder();
        char mid = ' ';
        StringBuilder end = new StringBuilder();

        // 알파벳 갯수 구하기
        for (int i = 0; i < s.length(); i++) {
            alp[s.charAt(i) - 65]++;
        }

        // 팰린드롬 만들기
        boolean check = false; // 팰린드롬 만들 수 있는 지 확인
        int oddCheck = 0; // 홀수 갯수 체크
        for (int i = 0; i < 26; i++) {
            if (alp[i] != 0 && alp[i] % 2 == 1) {
                if (oddCheck == 0) {
                    mid = (char) ('A' + i);
                    oddCheck++;
                } else {
                    check = true;
                    sb.append("I'm Sorry Hansoo");
                    break;
                }
            }
            for (int j = 0; j < alp[i] / 2; j++) {
                char a = (char) ('A' + i);
                start.append(a);
                end.insert(0, a);
            }
        }
        if (!check) {
            if (mid == ' ') {
                sb.append(start).append(end);
            } else {
                sb.append(start).append(mid).append(end);
            }
        }

        System.out.println(sb);
    }
}