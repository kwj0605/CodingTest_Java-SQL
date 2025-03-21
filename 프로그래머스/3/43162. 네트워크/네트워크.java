class Solution {
    boolean[] visited;
    void dfs(int node, int n, int[][] computers) {
        visited[node]=true;
        for(int i=0; i<n; i++) {
            if(!visited[i] && computers[node][i] == 1) {
                dfs(i, n, computers);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        // DFS로 컴퓨터를 순서대로 들림.
        // 안들린 곳이 있으면 answer++
        visited = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                answer++;
                dfs(i, n, computers);
            }
        }
        return answer;
    }
}