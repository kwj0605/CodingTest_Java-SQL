import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        // map으로 달리기 선수, 등수 정리
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<players.length; i++) {
            map.put(players[i], i);
        }
        
        // calling 당하면 map에서 추월한 선수와 추월당한 선수 등수 변경
        for(String calling : callings) {
            // 추월한 선수의 등수
            int rank = map.get(calling); // 이걸 map으로 가져오면서 palyers를 완탐해야하는 일이 사라짐.
            
            // 추월당한 선수의 이름 = players[추월한 선수의 등수 - 1]
            String player = players[rank-1];
            
            // players에 추월후 반영
            players[rank] = player; // 추월당한 선수
            players[rank-1] = calling; // 추월한 선수
            
            // map에 추월후 반영
            map.put(player, rank); // 추월당한 선수
            map.put(calling, rank-1); // 추월한 선수
        }
        
        // map의 value순으로 key 출력
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            answer[entry.getValue()] = entry.getKey();
        }
        
        return answer;
    }
}