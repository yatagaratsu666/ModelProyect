package brenda.array.queue;

import brenda.array.Array;
import brenda.util.collection.Collection;
import brenda.util.iterator.Iterator;
import brenda.util.queue.AbstractQueue;
import java.util.function.Function;

public class Queue<E> extends AbstractQueue<E> {
    
    Array<E> array;
    int head;
    int tail;
    int dimension;

    public Queue(int amtData) {
        array = new Array<>(amtData);
        head = 0;
        tail = 0;
        dimension = amtData;
    }
    
    @Override
    public E peek() {
        return array.get(head);
    }

    @Override
    public E extract() {
        E element = array.get(head);
        if (array.remove(head++) && element != null) {
            head %= dimension;
            return element;
        }
        return null;
    }


    @Override
    public boolean insert(E element) {
        if (array.add(element)) {
            tail = (tail + 1) % dimension;
            return true;
        }
        return false;
    }
    
    @Override
    public boolean reverse() {
        if (isEmpty()) {
            return false;
        }
        head = (head - 1 + array.size()) % array.size();
        return true;
    }


    @Override
    public boolean clear() {
        array.clear();
        array.defragment();
        head = 0;
        tail = 0;
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int count = 0;
            int apuntador = head;
            @Override
            public boolean hasNext() {
                return count++ < array.size();
            }

            @Override
            public E next() {
                if (apuntador >= dimension) {
                    apuntador=0;
                }
                return array.get(apuntador++);
            }
        };
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public void forEach(Function<E, Void> action) {
        array.forEach(action);
    }

    @Override
    public boolean contains(E element) {
        return array.contains(element);
    }

    @Override
    public boolean contains(E[] array) {
        return this.array.contains(array);
    }

    @Override
    public boolean contains(Collection<E> collection) {
        return array.contains(collection);
    }
}
