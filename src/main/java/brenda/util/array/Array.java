
package brenda.util.array;

import java.util.function.Predicate;
import brenda.util.collection.Collection;

public interface Array<E>{
    
    public boolean remove(int index);//

    public int indexOf(E element);//preguntar

    public int lastIndexOf(E element);//preguntar
    
    public boolean add(E element);//
    
    public boolean add(int index, E[] array);//
    
    public boolean add(int index, Collection<E> collection);//preguntar
    
    public void defragment();//preguntar
    
    public E get(int index);//
    
    public boolean remove(int fromIndex, int toIndex);//
    
    public boolean dimension(int newDimension);//preguntar
    
    public boolean set(int index, E element);//
    
    public boolean remove(Predicate<E> filter);//preguntar

}
