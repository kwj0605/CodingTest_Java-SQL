import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = new int[]{1, 2, 3, 4, 5};
        int[] two = new int[]{2,1,2,3,2,4,2,5};
        int[] three = new int[]{3,3,1,1,2,2,4,4,5,5};
        
        int max = -1;
        int[] count = new int[3];
        for(int i=0; i<answers.length; i++) {
            if(answers[i]==one[i%5]) {
                count[0]++;
                max = Math.max(max, count[0]);
            }
            if(answers[i]==two[i%8]) {
                count[1]++;
                max = Math.max(max, count[1]);
            }
            if(answers[i]==three[i%10]) {
                count[2]++;
                max = Math.max(max, count[2]);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<3; i++) {
            if(max == count[i]) {
                list.add(i+1);
            }
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}