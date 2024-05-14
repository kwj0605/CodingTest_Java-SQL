import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String str = Long.toString(n); // 각 자리수에 charAt
        long[] arr1 = new long[str.length()];
        long a = 10;
        for(int j =0; j<str.length(); j++) {
            System.out.println("n%a는" + n%a);
            arr1[j]= (long)n%a;
            n = n / a;
            System.out.println("n은 " + n);
        }
        System.out.println(Arrays.toString(arr1));
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));
        for(int i = 0; i<arr1.length; i++) {
            answer += arr1[i]*Math.pow(10, i);
        }
        return answer;
    }
}