import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> pb = new HashMap<>();
        
        for(int i=0; i<phone_book.length; i++) {
            pb.put(phone_book[i], 1);
        }
        
        for(int i=0; i<phone_book.length; i++) {
            for(int j=0; j<phone_book[i].length(); j++) {
                if(pb.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }
        
        return answer;
    }
}