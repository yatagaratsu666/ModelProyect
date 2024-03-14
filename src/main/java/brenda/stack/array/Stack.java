
package brenda.stack.array;

import brenda.array.Array;
import brenda.util.collection.Collection;
import brenda.util.iterator.Iterator;
import brenda.util.stack.AbstractStack;
import java.util.NoSuchElementException;
import java.util.function.Function;


public class Stack<E> extends AbstractStack<E> {
private Array<E> array;

    public Stack(int amtData) {
        array = new Array<>(amtData);
    }

    @Override
    public boolean reverse() {
        return array.reverse();
    }

    @Override
    public boolean clear() {
        return array.clear();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = size() - 1; // Empezamos desde el último elemento

            @Override
            public boolean hasNext() {
                return currentIndex >= 0;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No hay más elementos en la pila");
                }
                return array.get(currentIndex--);
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

    @Override
    public E peek() {
        if (isEmpty())
            return null;
        return array.get(size() - 1);
    }

    @Override
    public E pop() {
        E base = array.get(size() - 1);
        array.remove(size() - 1);
        array.defragment();
        array.dimension(array.size()-1);
        return base;
    }

    @Override
    public boolean push(E element) {
        return array.add(element);
    }
}
