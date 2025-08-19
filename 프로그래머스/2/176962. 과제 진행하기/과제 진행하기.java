import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        LinkedList<Task> tasks = new LinkedList<>();
        
        for(String[] plan : plans) {
            tasks.offer(new Task(plan[0], convertToMinute(plan[1]), Integer.parseInt(plan[2])));
        }
        
        tasks.sort((t1, t2) -> t1.start - t2.start);
        
        Stack<Task> stopTask = new Stack<>();
        List<String> endTask = new ArrayList<>();
        
        Task now = tasks.poll();
        int time = now.start;
        
        while(!tasks.isEmpty()) {
            time += now.left;
            Task next = tasks.peek();
            
            if(time > next.start) {
                now.left = time - next.start;
                stopTask.push(now);
            } else {
                endTask.add(now.name);
                if(!stopTask.isEmpty()) {
                    now = stopTask.pop();
                    continue;
                }
            }
            
            now = tasks.poll();
            time = now.start;
        }
        
        endTask.add(now.name);
        
        while(!stopTask.isEmpty()) {
            endTask.add(stopTask.pop().name);
        }
        
        return endTask.toArray(new String[0]);
    }
    
    private int convertToMinute(String start) {
        String[] t = start.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
    
    class Task {
        String name;
        int start;
        int left;
        
        public Task(String name, int start, int left) {
            this.name = name;
            this.start = start;
            this.left = left;
        }
    }
}