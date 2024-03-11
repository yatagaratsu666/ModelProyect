package brenda.priorityqueue;

import brenda.array.Array;
import brenda.list.queue.Queue;
import brenda.util.iterator.Iterator;
import brenda.util.priorityqueue.AbstractPriorityQueue;

public class PriorityQueue<E> extends AbstractPriorityQueue<E> {

    private Array<Queue<E>> priority;
    private int prioridades;
    private int size = 0;
    private int inode = 0;

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
        if (this.priority.size() > inode) {
            size++;
            inode++;
            return this.priority.get(0).insert(element);
        } else {
            return false;
        }
    }

    @Override
    public boolean insert(int index, E element) {
        if (index >= 0 && index < this.priority.size() && this.size < this.prioridades) {
            size++;
            Queue<E> targetQueue = this.priority.get(index);
            targetQueue.insert(element);
            return true;
        } else {
            return false;
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
                size--;
                return current.extract();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
