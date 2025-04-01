import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++) {
            int f = commands[i][0];
            int s = commands[i][1];
            int k = commands[i][2];
            
            int[] clone = new int[s-f+1];
            int q=0;
            for(int j=f-1; j<s; j++) {
                clone[q] = array[j];
                q++;
            }
            Arrays.sort(clone);
            
            answer[i] = clone[k-1];
        }
        return answer;
    }
}