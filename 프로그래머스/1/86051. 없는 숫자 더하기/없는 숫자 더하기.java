import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int count = 0;

        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] != count) {
                answer += count;
                i--;
            }
            count++;
        }
        if(numbers[numbers.length-1] != 9) {
            for(int i = numbers[numbers.length-1]+1; i < 10; i++) {
                answer += i;
            }
        }

        return answer;
    }
}