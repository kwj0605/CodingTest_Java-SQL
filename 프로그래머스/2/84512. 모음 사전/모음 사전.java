class Solution {
    String[] mouem = {"A", "E", "I", "O", "U"};
    int answer =0, count=0;
    
    void dfs(String comp, String word) {
        if(word.equals(comp)) {
            answer = count;
            return;
        }
        if(comp.length() == 5) {
            return;
        }
        
        for(int i=0; i<mouem.length; i++) {
            count++;
            dfs(comp+mouem[i], word);
            if(answer>0) return;
        }
    }
    public int solution(String word) {
        dfs("", word);
        return answer;
    }
}