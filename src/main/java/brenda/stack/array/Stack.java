
package brenda.stack.array;

import brenda.array.Array;
import brenda.util.collection.Collection;
import brenda.util.iterator.Iterator;
import brenda.util.stack.AbstractStack;
import java.util.function.Function;


public class Stack<E> extends AbstractStack<E> {
    
    Array<E> array;
    
    public Stack(int amtData){
        array = new Array(amtData);
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
        return array.iterator();
    }
    
    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }
    
        @Override
    public int size(){
        return array.size();
    }

    @Override
    public void forEach(Function<E, Void> action){
        array.forEach(action);
    }

    @Override
    public boolean contains(E element){
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

    @Override
    public E peek() {
        return array.get(0);
    }

    @Override
    public E pop() {
        E base = array.get(0);
        array.remove(0);
        array.defragment();
        array.dimension(array.size()-1);
        return base;
    }

    @Override
    public boolean push(E element) {
        return array.add(element);
    }  
}
