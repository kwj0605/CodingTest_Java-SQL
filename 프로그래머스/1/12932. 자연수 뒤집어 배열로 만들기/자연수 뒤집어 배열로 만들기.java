import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        String strN = Long.toString(n);
        for(int i=0; i<strN.length(); i++) {
            stack.push((int)strN.charAt(i)-48);
        }
        answer = new int[strN.length()];
        for(int j=0; j<strN.length(); j++) {
            answer[j] = stack.pop();
        }
        
        
        return answer;
    }
}