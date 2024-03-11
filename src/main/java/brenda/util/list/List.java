
package brenda.util.list;

import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import brenda.util.collection.Collection;

public interface List<E> {
    public boolean add(E element);
    public boolean add(E[] array);
    public boolean add(Collection<E> collection);
    public boolean addFirst(E element);
    public boolean addFirst(E[] array);
    public boolean addFirst(Collection<E> collection);
    public E peek();
    public E peekLast();
    public E[] peekArray(int index);
    public E[] peekLastArray(int index);
    public List<E> peekCollection(int index);
    public List<E> peekLastCollection(int index);
    public E poll();
    public E pollLast();
    public E[] pollArray(int index);
    public E[] pollLastArray(int index);
    public List<E> pollCollection(int index);
    public List<E> pollLastCollection(int index);
    public boolean remove(E element);
    public boolean remove(E[] array);
    public boolean remove(Collection<E> collection);
    public boolean remove(Predicate<E> filter);
    public boolean replace(E element, E newElement, Predicate<E> comparator);
    public boolean replace(E[] array, E[] newArray, Predicate<E> comparator);
    public boolean replace(Collection<E> collection, Collection<E> newCollection, Predicate<E> comparator);
    public boolean retain(E[] array);
    public boolean retain(Collection<E> collection);
    public boolean set(E index, E element);
    public boolean sort(ToIntFunction<E> toInt);
    public List<E> subList(E from, E to);
    public E[] toArray();
    
    
}
