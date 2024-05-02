import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int digit = 10;
        int sum=0;
        
        while(true) {
            if(n>0) {
                sum = n%digit;
                answer += sum;
                n = n/digit;
            }
            else break;
        }
            
        

        return answer;
    }
}