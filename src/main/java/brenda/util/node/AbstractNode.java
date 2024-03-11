
package brenda.util.node;

public abstract class AbstractNode<E> implements Node<E>, Cloneable {
    protected E element;
    
    public AbstractNode(){
        this.element = null;
    }

    public AbstractNode(E element) {
        this.element = element;
    }
    
    @Override
    public void set(E element){
        this.element = element;
    }
    
    @Override
    public E get(){
        return element;
    }
    
    @Override
    public String toString(){
        return element.toString();
    }
}
