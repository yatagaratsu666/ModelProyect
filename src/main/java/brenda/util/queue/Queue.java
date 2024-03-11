
package brenda.util.queue;


public interface Queue<E> {
    
    public E peek();
    public E extract();
    public boolean insert(E element);

    
}
