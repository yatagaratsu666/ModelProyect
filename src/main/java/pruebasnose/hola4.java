
package pruebasnose;

import brenda.priorityqueue.PriorityQueue;
import brenda.util.iterator.Iterator;

public class hola4 {
    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(3);
        System.out.println(priorityQueue.size());
        priorityQueue.insert(0, "High Priority Task 1");
        priorityQueue.insert(2, "Low Priority Task 1");
        priorityQueue.insert(1, "Medium Priority Task 1");
        
        System.out.println(priorityQueue.size());
        Iterator<String> iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            String task = iterator.next();
            System.out.println(task);
        }
        priorityQueue.extract();
        priorityQueue.extract();
        priorityQueue.extract();
//        System.out.println(priorityQueue.extract());
//        System.out.println(priorityQueue.extract());
//        System.out.println(priorityQueue.extract());
        System.out.println(priorityQueue.size());
        while (iterator.hasNext()) {
            String task = iterator.next();
            System.out.println(task);
        }
    }
}
