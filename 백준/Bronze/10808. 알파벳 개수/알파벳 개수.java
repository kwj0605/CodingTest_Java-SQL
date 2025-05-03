import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String string = sc.next();

        sc.close();

        int[] alp = new int[26];

        for (int i = 0; i < string.length(); i++) {
            int n = (int)string.charAt(i) - 'a';
            alp[n]++;
        }

        for (int i = 0; i < 25; i++) {
            System.out.print(alp[i]+" ");
        }
        System.out.print(alp[25]);
    }
}