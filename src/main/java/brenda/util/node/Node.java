
package brenda.util.node;

public interface Node<E> {
    
    public void set (E element);
    
    public E get();
    
    @Override
    public String toString();
    
}
