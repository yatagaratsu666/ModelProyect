package brenda.list.queue;

import brenda.listsingly.LinkedList;
import brenda.util.collection.Collection;
import brenda.util.iterator.Iterator;
import brenda.util.queue.AbstractQueue;
import java.util.function.Function;

public class Queue<E> extends AbstractQueue<E> {
    
    private LinkedList<E> linkedlist;
    
    public Queue(){
        this.linkedlist = new LinkedList<>();
    }

    @Override
    public E peek() {
        return this.linkedlist.peek();
    }

    @Override
    public E extract() {
        return this.linkedlist.poll();
    }

    @Override
    public boolean insert(E element) {
        return this.linkedlist.add(element);
    }

    @Override
    public boolean reverse() {
        return this.linkedlist.reverse();
    }

    @Override
    public boolean clear() {
        return this.linkedlist.clear();
    }

    @Override
    public Iterator<E> iterator() {
        return this.linkedlist.iterator();
    }
    
    @Override
    public boolean isEmpty(){
        return this.linkedlist.isEmpty();
    }
    
    @Override
    public int size(){
        return this.linkedlist.size();
    }

    @Override
    public void forEach(Function<E, Void> action){
        this.linkedlist.forEach(action);
    }

    @Override
    public boolean contains(E element){
        return this.linkedlist.contains(element);
    }

    @Override
    public boolean contains(E[] array) {
        return this.linkedlist.contains(array);
    }

    @Override
    public boolean contains(Collection<E> collection) {
        return this.linkedlist.contains(collection);
    }
}
