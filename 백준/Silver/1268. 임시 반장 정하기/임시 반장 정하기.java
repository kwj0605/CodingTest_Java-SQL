import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int student = sc.nextInt();

        int[][] cla= new int[student][5];

        for(int i=0; i<student; i++) {
            for(int j=0; j<5; j++) {
                cla[i][j] = sc.nextInt();
            }
        }
        sc.close();

        int[] banjang = new int[student];
        for(int i=0; i<student; i++) {
            for(int j=0; j<student; j++) {
                if(j==i) continue;
                for(int k=0; k<5; k++) {
                    if(cla[i][k] == cla[j][k]) {
                        banjang[i] += 1;
                        break; // 중복되서 같은 반이 될 수 있기 떄문에 제거
                    }
                }
            }
        }
        int max = -1;
        int banjangNum=0;
        for(int i=0; i<student; i++) {
            if(max<banjang[i]) {
                max=banjang[i];
                banjangNum=i+1;
            }
        }
        System.out.println(banjangNum);
    }
}
