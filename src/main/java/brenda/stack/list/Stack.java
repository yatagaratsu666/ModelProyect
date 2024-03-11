
package brenda.stack.list;

import brenda.listsingly.LinkedList;
import brenda.util.collection.Collection;
import brenda.util.iterator.Iterator;
import brenda.util.stack.AbstractStack;
import java.util.function.Function;

public class Stack<E> extends AbstractStack<E> {
    
    LinkedList<E> linkedlist;
    
    public Stack(){
        linkedlist = new LinkedList<>();
    }
    
    @Override
    public boolean isEmpty(){
        return linkedlist.isEmpty();
    }

    @Override
    public boolean reverse() {
        return linkedlist.reverse();
    }

    @Override
    public boolean clear() {
        return linkedlist.clear();
    }

    @Override
    public Iterator iterator() {
        return linkedlist.iterator();
    }

    @Override
    public E peek() {
        return linkedlist.peekLast();
    }

    @Override
    public E pop() {
        return linkedlist.pollLast();
    }

    @Override
    public boolean push(E element) {
        return linkedlist.add(element);
    }
    
    @Override
    public int size(){
        return linkedlist.size();
    }

    @Override
    public void forEach(Function<E, Void> action){
        linkedlist.forEach(action);
    }

    @Override
    public boolean contains(E element){
        return linkedlist.contains(element);
    }


    @Override
    public boolean contains(E[] array) {
        return linkedlist.contains(array);
    }


    @Override
    public boolean contains(Collection<E> collection) {
        return linkedlist.contains(collection);
    }
}
