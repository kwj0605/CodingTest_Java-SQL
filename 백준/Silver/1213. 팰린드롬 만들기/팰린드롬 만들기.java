import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next(); 
        sc.close();

        StringBuilder sb = new StringBuilder();
        StringBuilder front = new StringBuilder();
        char mid = ' ';
        StringBuilder end = new StringBuilder();

        int[] alp = new int[26];

        int oddCheck = 0; // 홀수 갯수
        boolean check = false; // 팰린드롬이 가능한지

        for(int i=0; i<s.length(); i++) {
            alp[s.charAt(i)-65]++;
        }

        for(int i=0; i<26; i++) {
            // 홀수
            if(alp[i] != 0 && alp[i]%2 == 1) {
                if(oddCheck == 0) {
                    mid = (char) ('A' + i);
                    oddCheck++;
                } else {
                    check = true;
                    sb.append("I'm Sorry Hansoo");
                    break;
                }
            }

            if(alp[i] != 0) {
                for(int j=0; j<alp[i]/2; j++) {
                    char c = (char) ('A'+ i);
                    front.append(c);
                    end.insert(0, c);
                }
            }
        }

        if(!check) {
            if(mid == ' ') {
                sb.append(front).append(end);
            } else {
                sb.append(front).append(mid).append(end);
            }
        }
        System.out.println(sb);
    }
}