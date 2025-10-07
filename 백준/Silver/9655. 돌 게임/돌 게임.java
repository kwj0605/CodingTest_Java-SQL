import java.util.*;

class Main {

    public static void main(String[] args) {
        //  창영이까지 해서 2, 4, 6 가능

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n%2 == 0 || n%4 == 0 || n%6 == 0) {
            System.out.println("CY");
        } else System.out.println("SK");
    }
}
