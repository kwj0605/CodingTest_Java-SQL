import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        sc.close();

        int len1 = s1.length();
        int len2 = s2.length();

        int minLen = len1 + len2;

        for (int i = 0; i < len1; i++) {
            boolean isPossible = true;
            for (int j = 0; j < len2; j++) {
                if (i + j < len1) {
                    if (s1.charAt(i + j) == '2' && s2.charAt(j) == '2') {
                        isPossible = false;
                        break;
                    }
                }
            }
            if (isPossible) {
                int currentLen = Math.max(len1, i + len2);
                minLen = Math.min(minLen, currentLen);
            }
        }

        // s2를 기준으로 s1을 곂쳐야하는 상황
        for (int i = 0; i < len2; i++) {
            boolean isPossible = true;
            for (int j = 0; j < len1; j++) {
                if (i + j < len2) {
                    if (s2.charAt(i + j) == '2' && s1.charAt(j) == '2') {
                        isPossible = false;
                        break;
                    }
                }
            }
            if (isPossible) {
                int currentLen = Math.max(len2, i + len1);
                minLen = Math.min(minLen, currentLen);
            }
        }

        System.out.println(minLen);
    }
}