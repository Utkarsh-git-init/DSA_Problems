package Strivers_dsa.Heap;

import java.util.*;

public class TaskScheduler621 {
    public int leastInterval(char[] tasks, int n) {
        return 0;
    }
    static void main() {
        char[] tasks={'A','A','A','D','D','F','B','B','B','C'};
        int n=2;
        TaskScheduler621 obj=new TaskScheduler621();
        System.out.println(obj.leastInterval(tasks,n));
    }
}


/*
public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> followers=new HashMap<>();
        for(char ch:tasks)
            followers.put(ch,followers.getOrDefault(ch,0)+1);
        PriorityQueue<Character> priorityQueue=new PriorityQueue<>(Comparator.comparingInt(followers::get).reversed());
        priorityQueue.addAll(followers.keySet());
        int count=0;
        Queue<Character> queue=new ArrayDeque<>();
        while(!followers.isEmpty()){
            Character temp=priorityQueue.poll();
            if(temp!=null) {
                followers.put(temp,followers.get(temp)-1);
                if(followers.get(temp).equals(0)) {
                    followers.remove(temp);
                    queue.offer(' ');
                }
                else
                    queue.offer(temp);
            }
            else
                queue.offer(' ');
            count++;
            if(queue.size()>n){
                if(!Objects.equals(queue.peek(),' ')) {
                    priorityQueue.add(queue.peek());
                }
                queue.poll();
            }
        }
        return count;
    }
 */