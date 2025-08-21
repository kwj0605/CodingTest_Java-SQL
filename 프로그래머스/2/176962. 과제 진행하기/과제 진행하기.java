import java.util.*;

class Task {
    String name;
    int start;
    int left;
    
    Task(String name, int start, int left) {
        this.name = name;
        this.start = start;
        this.left = left;
    }
}

class Solution {
    private int convertToMinute(String minute) {
        String[] time = minute.split(":");
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
    
    public String[] solution(String[][] plans) {
        LinkedList<Task> tasks = new LinkedList<>();
        for(String[] plan : plans) {
            tasks.offer(new Task(plan[0], convertToMinute(plan[1]), Integer.parseInt(plan[2])));
        }
        // 시작시간별 정렬
        tasks.sort((t1, t2) -> t1.start - t2.start);
        
        // 남은 과제는 Stack에 저장
        // 다한 과제는 List에 저장
        Stack<Task> stopTask = new Stack<>();
        List<String> endTask = new ArrayList<>();
        
        Task now = tasks.poll();
        int time = now.start + now.left;
        while(!tasks.isEmpty()) {
            Task next = tasks.peek();
            
            if(time > next.start) {
                now.left = time - next.start;
                stopTask.push(now);
            } else {
                endTask.add(now.name);
                if(!stopTask.isEmpty()) {
                    now = stopTask.pop();
                    time = time + now.left; // 시간은 현재 과제가 끝난 시간 + 멈춘 과제의 해야할 시간
                    continue;
                }
            }
            
            now = tasks.poll();
            time = now.start + now.left;
        }
        
        endTask.add(now.name);
        
        while(!stopTask.isEmpty()) {
            endTask.add(stopTask.pop().name);
        }
        
        return endTask.toArray(new String[0]);
    }
}