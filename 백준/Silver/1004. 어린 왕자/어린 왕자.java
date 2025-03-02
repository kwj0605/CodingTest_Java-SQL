import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 

        while (T-- > 0) {
            // 출발점, 도착점
            int x1 = sc.nextInt(), y1 = sc.nextInt();
            int x2 = sc.nextInt(), y2 = sc.nextInt();
            
            int n = sc.nextInt(); 
            int count = 0; // 진입/이탈 횟수

            for (int i = 0; i < n; i++) {
                int cx = sc.nextInt(), cy = sc.nextInt(), r = sc.nextInt();

                boolean startInside = isInside(x1, y1, cx, cy, r);
                boolean endInside = isInside(x2, y2, cx, cy, r);

                if (startInside != endInside) {
                    count++;
                }
            }
            // 결과 출력
            System.out.println(count);
        }
        sc.close();
    }

    private static boolean isInside(int x, int y, int cx, int cy, int r) {
        return (x - cx) * (x - cx) + (y - cy) * (y - cy) < r * r;
    }
}
