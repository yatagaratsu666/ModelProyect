package pruebasnose;

import brenda.priorityqueue.PriorityQueue;
import brenda.util.iterator.Iterator;

public class hola4 {
    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(3);
        System.out.println(priorityQueue.size());
        priorityQueue.insert(0, "Miku");
        priorityQueue.insert(2, "Rin");
        priorityQueue.insert(1, "Len");
        
        System.out.println(priorityQueue.size());
        Iterator<String> iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            String task = iterator.next();
            System.out.println(task);
        }
        System.out.println(priorityQueue.extract());
//        System.out.println(priorityQueue.extract());
//        System.out.println(priorityQueue.extract());
        System.out.println(priorityQueue.size());
        while (iterator.hasNext()) {
            String task = iterator.next();
            System.out.println(task);
        }
    }
}

