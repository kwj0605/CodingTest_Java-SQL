import java.util.*;

class Solution {
    class Room {
        int start;
        int end;
        Room(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public int solution(String[][] book_time) {        
        PriorityQueue<Room> books = new PriorityQueue<>((o1, o2) -> o1.start - o2.start);
        
        for(String[] book : book_time) { 
            books.offer(new Room(transMinute(book[0]), transMinute(book[1])+10));
        }
        
        PriorityQueue<Room> rooms = new PriorityQueue<>((o1, o2) -> o1.end - o2.end);
        
        while(!books.isEmpty()) {
            Room now = books.poll();
            
            if(rooms.isEmpty()) {
                rooms.offer(now); 
            } else {
                if(rooms.peek().end <= now.start) { // 들어갈 수 있음 -> 교체
                    rooms.poll();
                    rooms.offer(now);
                } else { // 새로운 방
                    rooms.offer(now);
                }
            }
        }
        
        return rooms.size();
    }
    
    private int transMinute(String time) {
        String[] str = time.split(":");
        
        return Integer.parseInt(str[0])*60 + Integer.parseInt(str[1]);
    }
}

// 시작 시간순으로 정렬 PriotyQueue
// 끝나는 시간 + 10 뒤에 가까운 시작 대실있으면 교체
// 끝나기 전 시작 대실 있으면 추가