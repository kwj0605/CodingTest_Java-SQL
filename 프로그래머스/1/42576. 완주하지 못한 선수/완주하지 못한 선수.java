import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i=0; i<completion.length; i++) {
            if(!completion[i].equals(participant[i])) {
                return participant[i];
            }
        }
        answer = participant[participant.length-1];
        
        return answer;
    }
}
// Arrays.sort로 정렬
// 둘 다 하나씩 빼면서 비교 -> 다르면 그 선수 이름임.(완주 못한 선수가 1명이니까)