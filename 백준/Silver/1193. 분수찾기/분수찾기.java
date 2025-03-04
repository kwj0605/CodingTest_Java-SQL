import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();

        int floor = 1;  // 첫 계층은 1
        int floorInx = 1; // 계층의 몇 번째 수
        int numerator = 0;
        int denominator = 0;

        for (int i = 0; i < X; i++) {
            if (floor % 2 != 0) {
                numerator = floor - floorInx + 1;
                denominator = floorInx;
                if (floorInx == floor) {
                    floor += 1;
                    floorInx = 1;
                    continue;
                }
            } else {
                numerator = floorInx;
                denominator = floor - floorInx + 1;
                if (floorInx == floor) {
                    floor += 1;
                    floorInx = 1;
                    continue;
                }
            }
            floorInx += 1;
        }
        System.out.println(numerator + "/" + denominator);
    }
}