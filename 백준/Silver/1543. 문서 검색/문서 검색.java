import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String target = sc.nextLine();
        String a = sc.nextLine();
        sc.close();

        // 첫 시작부터 목표가 일치하면 슬라이딩 윈도우

        int count = 0;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == a.charAt(0)) {
                boolean isSame = true;
                for (int j = 0; j < a.length(); j++) {
                    if (i + j >= target.length() || target.charAt(i + j) != a.charAt(j)) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {
                    i = i + a.length() - 1;
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
