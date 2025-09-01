import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = {};
        
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> (o1 - o2));
        
        List<Integer> list = new ArrayList<>();
        
        for(int sc : score) {
            q.offer(sc);
            if(q.size() > k) {
                q.poll();
            }
            
            list.add(q.peek());
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}