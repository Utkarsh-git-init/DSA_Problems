//146. LRU Cache

package Strivers_dsa.Stack_and_Queue;

import java.util.LinkedHashMap;

public class LRUCache {
    LinkedHashMap<Integer,Integer> lhmap=new LinkedHashMap<>();
    int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }
    public int get(int key) {
        if(lhmap.containsKey(key)){
            lhmap.putLast(key,lhmap.get(key));
            return lhmap.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(lhmap.size()==capacity&&!lhmap.containsKey(key)){
            lhmap.remove(lhmap.keySet().iterator().next());
        }
        lhmap.putLast(key,value);
    }

    static void main() {
        LRUCache obj=new LRUCache(2);
        obj.get(2);
        obj.put(2,6);
        obj.get(1);
        obj.put(1,5);
        obj.put(1,6);
        System.out.println(obj.lhmap);
    }
}

/*
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */