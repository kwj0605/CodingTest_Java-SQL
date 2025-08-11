import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        
        // 들어오는 간선, 나가는 간선 저장 Map(n, m) -> (n번 정점, 간선 m개)
        // 케이스에 맞춰 간선 갯수 확인
        
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
        
        int[] answer = new int[4];
        
        for(int[] edge : edges) {
            out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);
            in.put(edge[1], in.getOrDefault(edge[1], 0) + 1);
        }
        
        for(int node : out.keySet()) {
            if(out.get(node) >= 2) {
                if(!in.containsKey(node)) {
                    answer[0] = node;
                }
                else {
                    answer[3] += 1;
                }
            }
        }
        
        for(int node : in.keySet()) {
            if(!out.containsKey(node)) {
                answer[2] += 1;
            }
        }
        
        answer[1] = out.get(answer[0]) - answer[2] - answer[3];
        
        return answer;
    }
}

// 접근 방법: 생성한 정점 - 들어오는 간선 = 0 | 나가는 간선 >= 2
// 도넛 - 들어오는 간선 >= 1 | 나가는 간선 = 1
// 막대(마지막 정점) - 들어오는 간선 >= 1 | 나가는 간선 = 0
// 8자(정점) - 들어오는 간선 >= 2 | 나가는 간선 = 2개

// 생성된 정점에서 도넛, 막대, 8자로 들어오는 간선이 생길 수 있기 때문에 크거나 같다.