package brenda.priorityqueue;

import brenda.array.Array;
import brenda.list.queue.Queue;
import brenda.util.iterator.Iterator;
import brenda.util.priorityqueue.AbstractPriorityQueue;

public class PriorityQueue<E> extends AbstractPriorityQueue<E> {
    
    private Array<Queue<E>> priority;
    private int prioridades;

    public PriorityQueue(int amtData) {
        this.prioridades = amtData;
        this.priority = new Array<>(amtData);
        for (int i = 0; i < amtData; i++) {
            this.priority.add(new Queue<>());
        }
    }

    @Override
    public boolean reverse() {
        boolean reversed = true;
        Iterator<Queue<E>> iterator = this.priority.iterator();
        while (iterator.hasNext()) {
            Queue<E> queue = iterator.next();
            reversed &= queue.reverse();
        }
        return reversed;
    }

    @Override
    public boolean clear() {
        for (int i = this.prioridades - 1; i >= 0; i--) {
            this.priority.get(i).clear();
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int priorityIndex = prioridades - 1;
            private Iterator<E> currentIterator = priority.get(priorityIndex).iterator();

            @Override
            public boolean hasNext() {
                if (currentIterator.hasNext()) {
                    return true;
                } else {
                    while (priorityIndex > 0) {
                        priorityIndex--;
                        currentIterator = priority.get(priorityIndex).iterator();
                        if (currentIterator.hasNext()) {
                            return true;
                        }
                    }
                    return false;
                }
            }

            @Override
            public E next() {
                return currentIterator.next();
            }
        };
    }

    @Override
    public boolean insert(E element) {
        return this.priority.get(this.priority.size() - 1).insert(element);
    }

    @Override
    public boolean insert(int index, E element) {
        if (index >= 0 && index < this.priority.size()) {
            Queue<E> targetQueue = this.priority.get(index);
            targetQueue.insert(element);
            return true;
        } else {
            return false; // Índice fuera de rango
        }
    }

    @Override
    public E peek() {
        return this.priority.get(0).peek();
    }

    @Override
    public E extract() {
        for (int i = 0; i < this.priority.size(); i++) {
            Queue<E> current = this.priority.get(i);
            if (!current.isEmpty()) {
                return current.extract();
            }
        }
        return null;
    }
    
    @Override
    public int size(){
        return this.priority.size();
    }
}