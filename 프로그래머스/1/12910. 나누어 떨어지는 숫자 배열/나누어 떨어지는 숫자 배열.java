import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer;
        int count =0;
        List<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) {
                list.add(arr[i]);
                count++;
            }
        }
        if(count == 0) list.add(-1);

        answer = list.stream().mapToInt(i->i).toArray();
        Arrays.sort(answer);
        
        return answer;
    }
}