
package brenda.util.collection;

import java.util.function.Function;
import brenda.util.iterator.Iterator;

    public abstract class AbstractCollection<E> implements Collection<E>, Cloneable {
        
    protected int amtData;

    public AbstractCollection(){
    }

    @Override
    public abstract boolean reverse();
    
    @Override
    public abstract boolean clear();

    @Override
    public abstract Iterator<E> iterator();

    @Override
    public int size(){
        return amtData;
    }

    @Override
    public void forEach(Function<E, Void> action){
        Iterator<E> iter = this.iterator();
        while(iter.hasNext()){
            action.apply(iter.next());
        }
    }

    @Override
    public boolean contains(E element){
        Iterator<E> iter = this.iterator();
        while(iter.hasNext()){

            if(iter.next() == element){
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean contains(E[] array) {
        for(E element: array ){
            if(this.contains(element) == false){
                return false;
            }
        }
        return true;
    }


    @Override
    public boolean contains(Collection<E> collection) {
        Iterator<E> iter = collection.iterator();
        while(iter.hasNext()){
            if(this.contains(iter.next()) == false){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isEmpty(){
        Iterator<E> iter = this.iterator();
        while(iter.hasNext()){
            if(iter.next() != null){
                return false;
            }
        }
        return true;
    }
}
