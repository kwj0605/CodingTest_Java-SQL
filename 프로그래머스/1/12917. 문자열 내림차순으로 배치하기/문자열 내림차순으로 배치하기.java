import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";

        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        answer = new String(chars);

        answer = new StringBuffer(answer).reverse().toString();
        
        return answer;
    }
}