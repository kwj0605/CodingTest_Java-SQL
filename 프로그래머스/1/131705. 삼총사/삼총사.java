class Solution {
    int[] arr;
    int count=0;
    public int solution(int[] number) {
        arr = number;
        
        dfs(0, 0, 0);
        return count;
    }
    void dfs(int depth, int idx, int sum) {
        if(depth == 3) {
            if(sum == 0) {
                count++;
            }
            return;
        }
        
        for(int i=idx; i<arr.length; i++) {
            dfs(depth+1, i+1, sum+arr[i]);
        }
    }
}

// dfs 응용