
package brenda.util.array;

import java.util.function.Function;
import brenda.util.collection.Collection;
import brenda.util.iterator.Iterator;

public abstract class AbstractArray2<E> implements Array<E>, Collection<E> {
    
    protected int amtData;
    
    protected AbstractArray2(){
    }

    public AbstractArray2 (int amtData){
        this.amtData = amtData;
    }
}
