import java.util.*;

public class Main {
    public static int d(int num) {
        String str = Integer.toString(num);
        for(int i=0; i<str.length(); i++) {
            num += Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        if(num>10000) return 0;
        return num;
    }
    public static void main(String[] args) {
        boolean[] checkSelfNum = new boolean[10001];
        for(int i=1; i<=10000; i++) {
            int sum = d(i);
            checkSelfNum[sum] = true;
        }

        for(int i=1; i<10001; i++) {
            if(!checkSelfNum[i]) {
                System.out.println(i);
            }
        }
    }
}