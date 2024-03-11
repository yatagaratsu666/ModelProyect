
package brenda.util.iterator;


public interface IteratorDoubly<E> {

    public boolean hasNext();

    public E next();
    
    public E prev();
    
    public boolean hasPrevious();
}
