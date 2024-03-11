
package brenda.circularlist;

import brenda.nodecircular.LinkedNode;
import brenda.util.collection.Collection;
import brenda.util.iterator.Iterator;
import brenda.util.list.AbstractList;
import brenda.util.list.List;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LinkedList<E> extends AbstractList<E> {
    
    private LinkedNode<E> head;

    public LinkedList() {
        super();
        this.head = null;
    }

    public LinkedList(E element) {
        super();
        add(element);
    }

    public LinkedList(E[] array) {
        super();
        for (E element : array) {
            add(element);
        }
    }

    @Override
    public boolean add(E element) {
         try {
            LinkedNode<E> newNode = new LinkedNode<>(element, null);
            if (head == null) {
                head = newNode;
                head.setNext(head);
            } else {
                LinkedNode<E> current = head;
                while (current.getNext() != head) {
                    current = current.getNext();
                }
                current.setNext(newNode);
                newNode.setNext(head);
            }
            size++;
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean add(E[] array) {
        for (E elemento : array) {
            add(elemento);
        }
        return true;
    }

    @Override
    public boolean add(Collection<E> collection) {
        if (isEmpty()) {
            Iterator<E> iterator = collection.iterator();
            if (iterator.hasNext()) {
                head = new LinkedNode<>(iterator.next(), null);
                head.setNext(head);
                size++;
            }
        } else {
            LinkedNode<E> current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            Iterator<E> iterator = collection.iterator();
            while (iterator.hasNext()) {
                E element = iterator.next();
                current.setNext(new LinkedNode<>(element, head));
                current = current.getNext();
                size++;
            }
        }
        return true;
    }

    @Override
    public boolean addFirst(E element) {//verified
    LinkedNode<E> newNode = new LinkedNode<>(element, head);
        if (head == null) {
            head = newNode;
            newNode.setNext(head);
        } else {
            LinkedNode<E> current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            current.setNext(newNode);
            head = newNode;
        }

        size++;
        return true;
    }

    @Override
    public boolean addFirst(E[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            head = new LinkedNode<>(array[i], head);
            size++;
        }
        return true;
    }

    @Override
    public boolean addFirst(Collection<E> collection) {
        try {
            Iterator<E> iterator = collection.iterator();
            LinkedNode<E> reversed = null;
            while (iterator.hasNext()) {
                E element = iterator.next();
                LinkedNode<E> newNode = new LinkedNode<>(element, reversed);
                reversed = newNode;
            }
            LinkedNode<E> current = reversed;
            while (current != null) {
                addFirst(current.get());
                current = current.getNext();
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    } 

    @Override
    public E peek() {//verified
        return head.get();
    }

    @Override
    public E peekLast() {//verified
        LinkedNode<E> current = head;
        while (current.getNext() != head) {
            current = current.getNext();
        }
        return current.get();
    }

    @Override
    public E[] peekArray(int index) {//verified
        E[] array = (E[]) new Object[index];

        LinkedNode<E> current = head;
        for (int i = 0; i < index; i++) {
            array[i] = current.get();
            current = current.getNext();
        }
        return array;
    }

    @Override
    public E[] peekLastArray(int index) {//verified
        E[] array = (E[]) new Object[index];

        LinkedNode<E> current = head;
        for (int i = 0; i < size - index; i++) {
            current = current.getNext();
        }
        for (int i = 0; i < index; i++) {
            array[i] = current.get();
            current = current.getNext();
        }
        return array;
    }

    @Override
    public List<E> peekCollection(int index) {//verified
        LinkedNode<E> current = head;
        LinkedNode<E> previous = null;
        LinkedList<E> save = new LinkedList<>();
        
        for (int i = 0; i < index && !(current == head && previous != null); i++) {
            save.add(current.get());
            previous = current;
            current = current.getNext();
        }
        return save;
    }

    @Override
    public List<E> peekLastCollection(int index) {//verified
        LinkedNode<E> current = head;
        LinkedNode<E> previous = null;
        LinkedList<E> save = new LinkedList<>();
        
        for (int e = 0; e < size - index; e++) {
            previous = current;
            current = current.getNext();
        }
        for (int i = 0; i < index && !(current == head && previous != null); i++) {
            save.add(current.get());
            previous = current;
            current = current.getNext();
        }
        return save;
    }

    @Override
    public E poll() {//verified
        E base = head.get();
        LinkedNode<E> current = head;
        while (current.getNext() != head) {
            current = current.getNext();
        }
        head = head.getNext();
        current.setNext(head);
        size--;
        return base;
    }

    @Override
    public E pollLast() {//verified
        E base;
        LinkedNode<E> previous = null;
        LinkedNode<E> current = head;
        while (current.getNext() != head) {
            previous = current;
            current = current.getNext();
        }
        base = current.get();
        previous.setNext(head);
        size--;
        return base;
    }

    @Override
    public E[] pollArray(int index) {//verified
        E[] save = peekArray(index);
        for (int i = 0; i < index; i++) {
            remove(head.get());
        }
        return save;
    }

    @Override
    public E[] pollLastArray(int index) {//verified
        LinkedNode<E> current = head;
        int i = 0;
        E[] save = peekLastArray(index);
        do {
            if (i >= (size - index)) {
                remove((E) current.get());
            }
            current = current.getNext();
            i++;
        } while (current != head);
        if (current != head) {
            current.setNext(head);
        }
        return save;
    }

    @Override
    public List<E> pollCollection(int index) {//verified
        LinkedList<E> save = new LinkedList<>();
        if (index < size) {
            for (int i = 0; i < index; i++) {
                save.add(poll());
            }
        } else {
            for (int i = 0; i < size; i++) {
                save.add(poll());
            }
            head = null;
            size = 0;
        }
        return save;
    }

    @Override
    public List<E> pollLastCollection(int index) {//verified
        LinkedList<E> save = new LinkedList<>();
        if (index < size) {
            for (int i = 0; i < index; i++) {
                save.add(pollLast());
            }
        } else {
            for (int i = 0; i < size; i++) {
                save.add(pollLast());
            }
            head = null;
            size = 0;
        }
        return save;
    }

    @Override
    public boolean remove(E element) {//verified
        LinkedNode<E> current = head;
        LinkedNode<E> previous = null;

        while (!current.get().equals(element)) {
            previous = current;
            current = current.getNext();
        }
        if (current == null) {
            return false;
        }
        if (current == head) {
            if (head.getNext() == head) {
                head = null;
            } else {
                head = head.getNext();
                previous = head;
                while (previous.getNext() != current) {
                    previous = previous.getNext();
                }
                previous.setNext(head);
            }
        } else {
            previous.setNext(current.getNext());
        }
        size--;
        return true;
    }

    @Override
    public boolean remove(E[] array) {//verified
        boolean removed = true;
        for (int i = 0; i < array.length; i++) {
            if (!contains(array[i])) { 
                continue;
            }
            if (!remove(array[i])) {
                removed = false;
                break;
            }
        }
        return removed;
    }

    @Override
    public boolean remove(Collection<E> collection) {//verified
        boolean removed = false;
        Iterator<E> iterator = collection.iterator();
        while (iterator.hasNext()) {
            E element = iterator.next();
            if (!contains(element)) {
                continue;
            }
            if (!remove(element)) {
                removed = false;
                break;
            }
        }
        return removed;
    }

    @Override
    public boolean remove(Predicate<E> filter) {//verified
        boolean removed = false;
        if (isEmpty()) {
            return false;
        }
        LinkedNode<E> current = head;
        LinkedNode<E> previous = null;
        do {
            if (filter.test(current.get())) {
                if (current == head) {
                    if (size == 1) {
                        head = null;
                    } else {
                        head = head.getNext();
                        LinkedNode<E> last = head;
                        while (last.getNext() != current) {
                            last = last.getNext();
                        }
                        last.setNext(head);
                    }
                } else {
                    previous.setNext(current.getNext());
                }
                size--;
                removed = true;
            } else {
                previous = current;
            }
            current = current.getNext();
        } while (current != head);

        return removed;
    }

    @Override
    public boolean replace(E element, E newElement, Predicate<E> comparator) {
        LinkedNode<E> current = head;
        boolean replaced = false;
        do {
            if (comparator.test((E) current.get()) && current.get().equals(element)) {
                current.set(newElement);
                replaced = true;
            }
            current = current.getNext();
        } while (current != head);
        return replaced;
    }

    @Override
    public boolean replace(E[] array, E[] newArray, Predicate<E> comparator) {//verified
        if (isEmpty() || array.length != newArray.length) {
            return false;
        }

        boolean replaced = false;
        LinkedNode<E> current = head;

        do {
            if (comparator.test(current.get())) {
                for (int i = 0; i < array.length; i++) {
                    if (current.get().equals(array[i])) {
                        current.set(newArray[i]);
                        replaced = true;
                    }
                }
            }
            current = current.getNext();
        } while (current != head);
        return replaced;
    }

    @Override
    public boolean replace(Collection<E> collection, Collection<E> newCollection, Predicate<E> comparator) {//verified
        boolean replaced = false;
        Iterator<E> iterator = collection.iterator();
        Iterator<E> newIterator = newCollection.iterator();

        while (iterator.hasNext() && newIterator.hasNext()) {
            E currentElement = iterator.next();
            E newElement = newIterator.next();
            for (LinkedNode<E> current = head; current != null; current = current.getNext()) {
                if (comparator.test(current.get()) && current.get().equals(currentElement)) {
                    current.set(newElement);
                    replaced = true;
                    break; 
                }
            }
        }
        return replaced;
    }

    @Override
    public boolean retain(E[] array) {
        if (isEmpty()) {
            return false;
        }
        LinkedList<E> retainedElements = new LinkedList<>();
        for (E element : array) {
            if (contains(element)) {
                retainedElements.add(element);
            }
        }
        clear();
        for (E element : retainedElements.toArray()) {
            add(element);
        }
        return true;
    }

    @Override
    public boolean retain(Collection<E> collection) {//verified
        LinkedList<E> newList = new LinkedList<>();
        LinkedNode<E> current = head;
        LinkedNode<E> previous = null;
        while (!(current == head && previous != null)) {
            if (collection.contains(current.get())) {
                newList.add(current.get());
                previous = current;
            } else {
                if (previous != null) {
                    previous.setNext(current.getNext());
                } else {
                    head = current.getNext();
                }
            }
            current = current.getNext();
        }
        head = newList.head;
        size = newList.size;
        return !newList.isEmpty();
    }

    @Override
    public boolean set(E index, E element) {//verified
        boolean set = false;
        LinkedNode<E> current = head;
        while (current.get() != index && !set) {
            current = current.getNext();
        }
        current.set(element);
        return true;
    }

    @Override
    public boolean sort(ToIntFunction<E> toInt) {//unverified
        if (size <= 1) {
            return true;
        }
        boolean swapped;
        do {
            swapped = false;
            LinkedNode<E> current = head;
            do {
                LinkedNode<E> nextNode = current.getNext();
                if (toInt.applyAsInt(current.get()) > toInt.applyAsInt(nextNode.get())) {
                    E temp = current.get();
                    current.set(nextNode.get());
                    nextNode.set(temp);
                    swapped = true;
                }
                current = nextNode;
            } while (current.getNext() != head);
        } while (swapped);

        return true;
    }

    @Override
    public List<E> subList(E from, E to) {//verified
        LinkedNode<E> current = head;
        LinkedList<E> newList = new LinkedList<>();
        while (current != null && !current.get().equals(from)) {
            current = current.getNext();
        }
        do {
            newList.add(current.get());
            current = current.getNext();
        } while (current.get() != to);
        return newList;
    }

    @Override
    public E[] toArray() {//verified
        E[] array = (E[]) new Object[size];
        LinkedNode<E> current = head;
        int index = 0;
        do {
            array[index++] = current.get();
            current = current.getNext();
        } while (current != head);

        return array;
    }

    @Override
    public boolean clear() {//verified
        head.setNext(null);
        head = null;
        size = 0;
        return true;
    }

    @Override
    public boolean contains(E element) {//verified
        boolean found = false;
        LinkedNode<E> current = head;

        for (int i = 0; i < size && !found; i++) {
            if (current.get().equals(element)) {
                found = true;
            }
            current = current.getNext();
        }
        return found;
    }

    @Override
    public boolean contains(E[] array) {//verified
        if (isEmpty() || array.length == 0) {
            return false;
        }
        for (E element : array) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean contains(Collection<E> collection) {//verified
        if (isEmpty() || collection.isEmpty()) {
            return false;
        }
        Iterator<E> iterator = collection.iterator();
        while (iterator.hasNext()) {
            E element = iterator.next();
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean reverse() {//verified
        LinkedNode<E> current = head;
        Iterator<E> iterator = this.iterator();
        E[] reverso = (E[]) new Object[size];
        int i = 1;
        while (iterator.hasNext()) {
            E element = iterator.next();
            reverso[size - i] = element;
            i++;
        }
        for (E element : reverso) {
            current.set(element);
            current = current.getNext();
        }
        return true;
    }

    @Override
    public void forEach(Function<E, Void> action) {//verified
        Iterator<E> iter = this.iterator();
        while (iter.hasNext()) {
            action.apply(iter.next());
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private LinkedNode<E> current = head;
            private LinkedNode<E> next;

            {
                if (head != null) {
                    next = head.getNext();
                }
            }

            @Override
            public boolean hasNext() {
                if (size == 0) {
                    return false;
                }
                return !(current == head);
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements to list");
                }
                E element = current.get();
                current = current.getNext();
                next = next.getNext();
                return element;
            }
        };
    }
}
