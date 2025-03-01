import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수
        
        for (int i = 0; i < T; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();
            
            System.out.println(findIntersectionPoints(x1, y1, r1, x2, y2, r2));
        }
        sc.close();
    }
    
    public static int findIntersectionPoints(int x1, int y1, int r1, int x2, int y2, int r2) {
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)); // 두 원의 중심 거리
        
        if (x1 == x2 && y1 == y2 && r1 == r2) {
            return -1; 
        }
        
        if (distance > r1 + r2) {
            return 0; 
        }
        
        if (distance < Math.abs(r1 - r2)) {
            return 0; 
        }
        
        if (distance == r1 + r2) {
            return 1; 
        }
        
        if (distance == Math.abs(r1 - r2)) {
            return 1; 
        }
        
        return 2; 
    }
}
