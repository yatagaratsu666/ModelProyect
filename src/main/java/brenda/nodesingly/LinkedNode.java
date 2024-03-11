
package brenda.nodesingly;

import brenda.util.node.AbstractNode;

public class LinkedNode<E> extends AbstractNode<E> {
    
    private LinkedNode<E> next;
    
    public LinkedNode() {
        super();
        next = null;
    }
    
    public LinkedNode<E> getNext() {
        return next;
    }

    public LinkedNode(E element) {
        super(element);
        next = null;
    }
    
    public void setNext(LinkedNode<E> next){
        this.next = next;
    }
    
}
