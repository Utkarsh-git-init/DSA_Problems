package Strivers_dsa.Heap.FindMedianFromStream295;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> fHalf;
    PriorityQueue<Integer> sHalf;
    public MedianFinder() {
        fHalf=new PriorityQueue<>(Comparator.reverseOrder());
        sHalf=new PriorityQueue<>();
    }
    public void addNum(int num) {
        if(fHalf.isEmpty()){
            fHalf.add(num);
            return;
        }
        if(fHalf.size()==sHalf.size()){
            if(num<fHalf.peek()){
                fHalf.add(num);
            }else
                sHalf.add(num);
        }else{
            if(fHalf.size()>sHalf.size()){
                if(num< fHalf.peek()){
                    sHalf.add(fHalf.poll());
                    fHalf.add(num);
                }else
                    sHalf.add(num);
            }else{
                if(num<sHalf.peek()){
                    fHalf.add(num);
                }else{
                    fHalf.add(sHalf.poll());
                    sHalf.add(num);
                }
            }
        }
    }

    public double findMedian() {
        if(fHalf.size()==sHalf.size())
            return (fHalf.peek()+sHalf.peek())/2.0;
        else if(fHalf.size()>sHalf.size())
            return fHalf.peek();
        else{
            return sHalf.peek();
        }
    }
}
