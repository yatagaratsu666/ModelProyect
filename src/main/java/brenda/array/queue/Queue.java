package brenda.array.queue;

import brenda.array.Array;
import brenda.util.collection.Collection;
import brenda.util.iterator.Iterator;
import brenda.util.queue.AbstractQueue;
import java.util.function.Function;

public class Queue<E> extends AbstractQueue<E> {
    
    private Array<E> array;
    private int head;
    private int tail;
    private int dimension;
    private int base;

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
        if (isEmpty()) {
            return null;
        }
        E element = array.get(head);
        array.remove(0);
        array.defragment();
        array.dimension(array.size());
        dimension--;
        base--;
        return element;
    }

    @Override
    public boolean insert(E element) {
        base++;
        array.add(element);
        tail = (tail + 1) % dimension;
        return true;
    }

    @Override
    public boolean reverse() {
        array.reverse();
        return true;
    }

    @Override
    public boolean clear() {
        array.clear();
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
                return count++ < base;
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
    public boolean contains(E[] elements) {
        return array.contains(elements);
    }

    @Override
    public boolean contains(Collection<E> collection) {
        return array.contains(collection);
    }
}

