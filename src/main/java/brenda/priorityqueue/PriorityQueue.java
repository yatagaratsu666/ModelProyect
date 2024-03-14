package brenda.priorityqueue;

import brenda.array.Array;
import brenda.list.queue.Queue;
import brenda.util.iterator.Iterator;
import brenda.util.priorityqueue.AbstractPriorityQueue;

public class PriorityQueue<E> extends AbstractPriorityQueue<E> {

    private Array<Queue<E>> priority;
    private int prioridades;
    private int size = 0;

    public PriorityQueue(int imtData) {
        this.size = 0;
        this.priority = new Array<>(imtData);
        this.prioridades = imtData;
        for (int i = 0; i < imtData; i++) {
            priority.add(new Queue<>());
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
        size = 0;
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int priorityIndex = 0;
            private Iterator<E> currentIterator = priority.get(priorityIndex).iterator();

            @Override
            public boolean hasNext() {
                if (currentIterator.hasNext()) {
                    return true;
                } else {
                    while (priorityIndex < prioridades - 1) {
                        priorityIndex++;
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
        priority.get(prioridades - 1).insert(element);
        size++;
        return true;
    }

    @Override
    public boolean insert(int index, E element) {
        priority.get(index).insert(element);
        size++;
        return true;
    }

    @Override
    public E peek() {
        for (int i = 0; i < prioridades; i++) {
            if (priority.get(i).size() != 0) {
                return priority.get(i).peek();
            }
        }
        return null;
    }

    @Override
    public E extract() {
        for (int i = 0; i < prioridades; i++) {
            if (priority.get(i).size() != 0) {
                size--;
                return priority.get(i).extract();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}

