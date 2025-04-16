class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        
        // 1. s단어 하나씩 꺼내서 
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            // 2. index만큼/ skip과 비교하며, skip 단어와 같으면 넘김 --> 50*20*10 = 시간복잡도 괜찮을듯
            int idx=1;
            for(int j=0; j<index; j++) {
                c+=idx;
                if(c>'z') c-=26;
                c = skip(c, skip);
            }
            // 3. result에 StringBuiler에 append
            sb.append(c);
        }        
        
        return sb.toString();
    }
    char skip(char c, String skip) {
        for(int k=0; k<skip.length(); k++) {
            if(c==skip.charAt(k)) {
                c+=1;
                if(c > 'z') c-=26;
                c = skip(c, skip);
            }
        }
        
        return c;
    }
}