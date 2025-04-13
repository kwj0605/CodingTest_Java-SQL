import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        // 1. gifts 정리
        // giveMap 생성
        Map<String, Integer> giveMap = new HashMap<>();
        // takeMap 생성
        Map<String, Integer> takeMap = new HashMap<>();
        
        // gifts 파싱
        for(int i=0; i<gifts.length; i++) {
            String[] a = gifts[i].split(" ");
            
            // A는 giveMap으로 B는 takeMap으로
            giveMap.put(a[0], giveMap.getOrDefault(a[0], 0)+1);
            takeMap.put(a[1], takeMap.getOrDefault(a[1], 0)+1);
        }
        
        // 2. countArr에 받을 선물 정리
        int[] countArr = new int[friends.length];
        
        // 3. friends 전탐하며 (자신 빼고) 각 친구별로 받을 선물
        for(int i=0; i<friends.length; i++) {
            for(int j=0; j<friends.length; j++) {
                if(i==j) continue; // 같은 이름 X
                
                // A보다 B가 많이 줬을 떄
                int b = AandB(friends[i], friends[j], gifts);
                if(b>0) countArr[i]++;
                
                // 선물 준적이 없거나, 같은 횟수를 줬을 때 
                if(b==0) {
                    // 선물지수가 높은 사람이 선물을 받음
                    int giftNum = calGiftNum(friends[i], friends[j], giveMap, takeMap);
                    if(giftNum>0) countArr[i]++;
                    // 선물지수가 같을 때 선물을 주지 않음
                }
            }
        }
        // 4. max값 return
        int max = -1;
        for(int count : countArr) {
            max = Math.max(max, count);
        }
        return max;
    }
    int AandB(String A, String B, String[] gifts) {
        String arrA = A + " " + B;
        String arrB = B + " " + A;
        int a = 0;
        // A가 B보다 선물을 많이 줬으면 a는 양수, 아니면 음수, 같으면 0
        for(String gift : gifts) {
            if(gift.equals(arrA)) a++;
            if(gift.equals(arrB)) a--;
        }
        
        return a;
    }
    // 선물지수를 계산 -> A선물지수 - B선물지수 반환
    int calGiftNum(String A, String B, Map<String, Integer> giveMap, Map<String, Integer> takeMap) {
        // 선물 준 횟수 - 받은 횟수
        // A의 선물지수
        int a = giveMap.getOrDefault(A, 0) - takeMap.getOrDefault(A, 0);
        // B의 선물지수
        int b = giveMap.getOrDefault(B, 0) - takeMap.getOrDefault(B, 0);
        
        return a-b;
    }
}