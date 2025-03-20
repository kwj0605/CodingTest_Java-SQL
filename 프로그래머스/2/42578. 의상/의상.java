import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        // 1. HashMap으로 clothesKind<옷의 종류, 옷 개수>
        Map<String, Integer> clothesKind = new HashMap<>();
        for(String[] cloth : clothes) {
            clothesKind.put(cloth[1], clothesKind.getOrDefault(cloth[1], 0)+1);
        }
        
        // 2. 옷의 개수+1 모두 곱하기연산
        for(String key : clothesKind.keySet()) {
            answer *= clothesKind.get(key)+1;
        }
        
        // 3. -1( 모두 안 입는 경우 )
        return answer-1;
    }
}
// 1. HashMap으로 clothesKind<옷의 종류, 옷 개수>
// 2. 옷의 개수+1 모두 곱하기연산
// 3. -1( 모두 안 입는 경우 )