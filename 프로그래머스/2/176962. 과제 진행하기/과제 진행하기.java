import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        
        Queue<Task> tasks = new PriorityQueue<>((t1, t2) -> t1.start - t2.start);
        for(String[] plan : plans) {
            tasks.offer(new Task(plan[0], convertToMinute(plan[1]), Integer.parseInt(plan[2])));
        }
        
        Stack<Task> stopTask = new Stack<>();
        List<String> endTask = new ArrayList<>();
        
        Task now = tasks.poll();
        int time = now.start + now.pt;
        
        while(!tasks.isEmpty()) {
            Task next = tasks.peek();
            
            if(time > next.start) {
                now.pt = time - next.start;
                stopTask.push(now);
            } else {
                endTask.add(now.name);
                if(!stopTask.isEmpty()) {
                    now = stopTask.pop();
                    time += now.pt;
                    continue;
                }
            }
            
            now = tasks.poll();
            time = now.start + now.pt;
        }
        
        endTask.add(now.name);
        while(!stopTask.isEmpty()) {
            now = stopTask.pop();
            endTask.add(now.name);
        }
        
        return endTask.toArray(new String[0]);
    }
    
    private int convertToMinute(String start) {
        String[] time = start.split(":");
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
    
    class Task {
        String name;
        int start;
        int pt;
        
        public Task(String name, int start, int pt) {
            this.name = name;
            this.start = start;
            this.pt = pt;
        }
    }
}

// 1. Task 클래스로 객체 정의
// 2. Task를 Queue에 넣어서 start 별로 오름차순 정의
// 3. 다음과제의 start < 현재과제의 start + playtime : 남은 시간은 현제 과제의 playtime 저장
// 4. 멈춘 과제는 stack에 저장
// 5. 다음과제의 start >= 현재과제의 start + playtime : 멈춘 과제가 있으면 가져오고 다시 3번으로 시작.
// 6. 끝난 과제는 List에 저장