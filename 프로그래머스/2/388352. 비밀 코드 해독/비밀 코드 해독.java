import java.util.*;

class Solution {
    
    int N;
    List<Integer> list = new ArrayList<>();
    int answer = 0;
    int[] ANS;
    int[][] Q;
    
    public int solution(int n, int[][] q, int[] ans) {
        N = n;
        ANS = ans;
        Q = q;
        
        dfs(1,0);
        
        return answer;
    }
    
    void dfs(int cur, int cnt) {
        if (cnt == 5) {
            int sum = 0;
            if(check()) answer++;
            return;
        }
        
        for (int i=cur; i<=N; i++) {
            list.add(i);
            dfs(i+1, cnt+1);
            list.remove(list.size()-1);
        }
    }
    
    boolean check() {
        for (int i=0; i<Q.length; i++) {
            int cnt = 0;
            for (int j=0; j<5; j++) {
                for (int num : list) {
                    if (num == Q[i][j]) cnt++;
                }
            }
            if (cnt != ANS[i]) return false;
        }
        
        return true;
    }
}