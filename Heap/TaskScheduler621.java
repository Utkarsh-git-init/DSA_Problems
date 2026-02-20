package Strivers_dsa.Heap;

import java.util.*;

public class TaskScheduler621 {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:tasks)
            map.put(ch,map.getOrDefault(ch,0)+1);
        ArrayList<Character> characters = new ArrayList<>(map.keySet());
        characters.sort(Comparator.comparingInt(map::get));
        int count=0;
        return count;
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
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:tasks)
            map.put(ch,map.getOrDefault(ch,0)+1);
        PriorityQueue<Character> priorityQueue=new PriorityQueue<>(Comparator.comparingInt(map::get).reversed());
        priorityQueue.addAll(map.keySet());
        int count=0;
        Queue<Character> queue=new ArrayDeque<>();
        while(!map.isEmpty()){
            Character temp=priorityQueue.poll();
            if(temp!=null) {
                map.put(temp,map.get(temp)-1);
                if(map.get(temp).equals(0)) {
                    map.remove(temp);
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