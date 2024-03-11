
package brenda.array.queue;

import brenda.array.Array;
import brenda.util.collection.Collection;
import brenda.util.iterator.Iterator;
import brenda.util.queue.AbstractQueue;
import java.util.function.Function;


public class Queue<E> extends AbstractQueue<E> {
    
    Array<E> array;

    public Queue(int amtData) {
        array = new Array<>(amtData);
    }

    @Override
    public E peek() {
        return array.get(0);
    }

    @Override
    public E extract() {
        E data = array.get(0);
        array.remove(0);
        array.defragment();
        array.dimension(array.size());
        return data;
    }

    @Override
    public boolean insert(E element) {
        return array.add(element);
    }

    @Override
    public boolean reverse() {
        return array.remove(0);
    }

    @Override
    public boolean clear() {
        array.clear();
        array.defragment();
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return array.iterator();
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
