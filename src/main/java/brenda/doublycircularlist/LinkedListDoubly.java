
package brenda.doublycircularlist;

import brenda.nodedoubly.LinkedNode;
import brenda.util.collection.Collection;
import brenda.util.iterator.Iterator;
import brenda.util.list.AbstractList;
import brenda.util.list.List;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.logging.Logger;


public class LinkedListDoubly<E> extends AbstractList<E> {

    private LinkedNode<E> head;

    public LinkedListDoubly() {
        super();
        this.head = null;
    } 

    @Override
    public boolean add(E element) {//verified
        LinkedNode<E> newNode = new LinkedNode<>(element);
            if (head == null) {
                head = newNode;
                head.setNext(head);
                head.setPrevious(head);
            } else {
                LinkedNode<E> current = head;
                while (current.getNext() != head) {
                    current = current.getNext();
                }
                current.setNext(newNode);
                newNode.setPrevious(current);
                newNode.setNext(head);
                head.setPrevious(newNode);
            }
            size++;
            return true;
    }

    @Override
    public boolean add(E[] array) {//verified
        for (E elemento : array) {
            add(elemento);
        }
        return true;
    }

    @Override
    public boolean add(Collection<E> collection) {
        Iterator<E> iterator = collection.iterator();
        while (iterator.hasNext()) {
            E element = iterator.next();
            add(element);
        }
        return true;
    }

    @Override
    public boolean addFirst(E element) {//verified
        LinkedNode<E> newNode = new LinkedNode<>(element);
        if (head == null) {
            head = newNode;
            newNode.setNext(head);
            head.setPrevious(head);
        } else {
            LinkedNode<E> current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            current.setNext(newNode);
            newNode.setPrevious(current);
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean addFirst(E[] array) {//verified
        for (int i = array.length - 1; i >= 0; i--) {
            addFirst(array[i]);
        }
        return true;
    }

    @Override
    public boolean addFirst(Collection<E> collection) {//verified
        Iterator<E> iterator = collection.iterator();
        LinkedNode<E> reversed = null;
        while (iterator.hasNext()) {
            E element = iterator.next();
            LinkedNode<E> newNode = new LinkedNode<>(element, reversed, null);
            reversed = newNode;
        }
        LinkedNode<E> current = reversed;
        while (current != null) {
            addFirst(current.get());
            current = current.getNext();
        }
        return true;
    }

    @Override
    public E peek() {
        return head.get();
    }

    @Override
    public E peekLast() {
        LinkedNode<E> current = head;
        while (current.getNext() != head) {
            current = current.getNext();
        }
        return current.get();
    }

    @Override
    public E[] peekArray(int index) {
        E[] array = (E[]) new Object[index];

        LinkedNode<E> current = head;
        for (int i = 0; i < index; i++) {
            array[i] = current.get();
            current = current.getNext();
        }
        return array;
    }

    @Override
    public E[] peekLastArray(int index) {
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
    public List<E> peekCollection(int index) {
        LinkedNode<E> current = head;
        LinkedNode<E> previous = null;
        LinkedListDoubly<E> save = new LinkedListDoubly<>();
        for (int i = 0; i < index && !(current == head && previous != null); i++) {
            save.add(current.get());
            previous = current;
            current = current.getNext();
        }
        return save;
    }

    @Override
    public List<E> peekLastCollection(int index) {
        LinkedNode<E> current = head;
        LinkedNode<E> previous = null;
        LinkedListDoubly<E> save = new LinkedListDoubly<>();
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
        E element = head.get();

        if (head.getNext() == head) {
            head = null;
        } else {
            head.getPrevious().setNext(head.getNext());
            head.getNext().setPrevious(head.getPrevious());
            head = head.getNext();
        }
        size--;
        return element;
    }

    @Override
    public E pollLast() {//verified
        E element = head.getPrevious().get();

        if (size == 1) {
            head = null;
        } else {
            head.getPrevious().getPrevious().setNext(head);
            head.setPrevious(head.getPrevious().getPrevious());
        }
        size--;

        return element;
    }

    @Override
    public E[] pollArray(int index) {//verified
        E[] array = (E[]) new Object[index];
        LinkedNode<E> current = head;

        for (int i = 0; i < index; i++) {
            array[i] = current.get();
            current = current.getNext();
        }
        for (int i = 0; i < index; i++) {
            poll();
        }
        return array;
    }

    @Override
    public E[] pollLastArray(int index) {//verified
    if (index <= 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        LinkedNode<E> current = head;
        for (int i = 0; i < size - index; i++) {
            current = current.getNext();
        }

        E[] result = (E[]) new Object[index];
        for (int i = 0; i < index; i++) {
            result[i] = current.get();
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
            current = current.getNext();
            size--;
        }
        head = current;
        return result;
    }

    @Override
    public List<E> pollCollection(int index) {//verified
        LinkedNode<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        LinkedListDoubly<E> extracted = new LinkedListDoubly<>();
        for (int i = 0; i < index; i++) {
            extracted.add(current.get());
            current = current.getNext();
            poll();
        }

        return extracted;
    }

    @Override
    public List<E> pollLastCollection(int index) {//verified
        LinkedNode<E> current = head.getPrevious();

        for (int i = 0; i < index; i++) {
            current = current.getPrevious();
        }

        LinkedListDoubly<E> extracted = new LinkedListDoubly<>();

        for (int i = 0; i < index; i++) {
            extracted.addFirst(current.get());
            current = current.getNext();
        }
        for (int i = 0; i < index; i++) {
            pollLast();
        }
        return extracted;
    }

    @Override
    public boolean remove(E element) {//verified
        LinkedNode<E> current = head;

        while (current != null) {
            if (current.get().equals(element)) {
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
                if (current == head) {
                    head = current.getNext();
                }
                size--;
                return true;
            }
            current = current.getNext();
            if (current == head) {
                break;
            }
        }
        return false;
    }

    @Override
    public boolean remove(E[] array) {//verified
        boolean removed = false;

        for (E element : array) {
            LinkedNode<E> current = head;
            boolean found = false;
            while (current != null) {
                if (current.get().equals(element)) {
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                    if (current == head) {
                        head = current.getNext();
                    }
                    size--;
                    removed = true;
                    found = true;
                    break;
                }
                current = current.getNext();
                if (current == head) {
                    break;
                }
            }
            if (!found) {
                removed = false;
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
            LinkedNode<E> current = head;
            boolean found = false;
            while (current != null) {
                if (current.get().equals(element)) {
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                    if (current == head) {
                        head = current.getNext();
                    }
                    size--;
                    removed = true;
                    found = true;
                    break;
                }
                current = current.getNext();
                if (current == head) {
                    break;
                }
            }
            if (!found) {
                removed = false;
            }
        }
        return removed;
    }

    @Override
    public boolean remove(Predicate<E> filter) {//verified
        boolean removedAny = false;
        LinkedNode<E> current = head;

        do {
            LinkedNode<E> nextNode = current.getNext();
            if (filter.test(current.get())) {
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
                if (current == head) {
                    head = current.getNext();
                }
                size--;
                removedAny = true;
            }
            current = nextNode;
        } while (current != head);
        return removedAny;
    }

    @Override
    public boolean replace(E element, E newElement, Predicate<E> comparator) {//verified
        boolean replacedAny = false;
        LinkedNode<E> current = head;

        do {
            LinkedNode<E> nextNode = current.getNext();
            if (comparator.test(current.get()) && current.get().equals(element)) {
                current.set(newElement);
                replacedAny = true;
            }
            current = nextNode;
        } while (current != head);
        return replacedAny;
    }

    @Override
    public boolean replace(E[] array, E[] newArray, Predicate<E> comparator) {//verified
        boolean replacedAny = false;

        for (int i = 0; i < array.length; i++) {
            boolean replaced = replace(array[i], newArray[i], comparator);
            if (replaced) {
                replacedAny = true;
            }
        }
        return replacedAny;
    }

    @Override
    public boolean replace(Collection<E> collection, Collection<E> newCollection, Predicate<E> comparator) {//verified
        boolean replacedAny = false;

        Iterator<E> collectionIterator = collection.iterator();
        Iterator<E> newCollectionIterator = newCollection.iterator();

        while (collectionIterator.hasNext()) {
            E element = collectionIterator.next();
            E newElement = newCollectionIterator.next();

            boolean replaced = replace(element, newElement, comparator);
            if (replaced) {
                replacedAny = true;
            }
        }

        return replacedAny;
    }

    @Override
    public boolean retain(E[] array) {//verified
        LinkedListDoubly<E> retainedElements = new LinkedListDoubly<>();

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
        boolean modified = false;
        LinkedNode<E> current = head;

        while (current != null) {
            LinkedNode<E> nextNode = current.getNext();
            if (!collection.contains(current.get())) {
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
                if (current == head) {
                    head = current.getNext();
                }
                size--;
                modified = true;
            }
            current = nextNode;
            if (current == head) {
                break;
            }
        }
        return modified;
    }

    @Override
    public boolean set(E index, E element) {//verified
        LinkedNode<E> current = head;

        do {
            if (current.get().equals(index)) {
                current.set(element);
                return true;
            }
            current = current.getNext();
        } while (current != head);
        return false;
    }

    @Override
    public boolean sort(ToIntFunction<E> toInt) {//verified
        E[] array = toArray();

        for (int i = 1; i < array.length; i++) {
            E key = array[i];
            int j = i - 1;
            int keyValue = toInt.applyAsInt(key);

            while (j >= 0 && toInt.applyAsInt(array[j]) > keyValue) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        clear();
        for (E element : array) {
            add(element);
        }
        return true;
    }

    @Override
    public List<E> subList(E from, E to) {//verified
        LinkedListDoubly<E> subList = new LinkedListDoubly<>();
        boolean base = false;

        LinkedNode<E> current = head;

        while (current != null) {
            if (current.get().equals(from)) {
                base = true;
            }
            if (base) {
                subList.add(current.get());
            }
            if (current.get().equals(to)) {
                break;
            }
            current = current.getNext();
            if (current == head) {
                break;
            }
        }
        return subList;
    }

    @Override
    public E[] toArray() {//verified
        E[] array = (E[]) new Object[size];
        LinkedNode<E> current = head;
        int index = 0;

        while (current != null) {
            array[index++] = current.get();
            current = current.getNext();
            if (current == head) {
                break;
            }
        }

        return array;
    }

    @Override
    public boolean clear() {//verified
        head = null;
        size = 0;
        return true;
    }

    @Override
    public boolean contains(E element) {//verified
        LinkedNode<E> current = head;

        while (true) {
            if (current.get().equals(element)) {
                return true;
            }
            current = current.getNext();
            if (current == head) {
                break;
            }
        }
        return false;
    }

    @Override
    public boolean contains(E[] array) {//verified
        for (E element : array) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean contains(Collection<E> collection) {//verified
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
    public boolean isEmpty() {//verified
        return size == 0 && head == null;
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
        LinkedNode<E> current = head;

        while (current != null) {
            action.apply(current.get());
            current = current.getNext();
            if (current == head) {
                break;
            }
        }
    }

    @Override
    public Iterator<E> iterator() {//verified
       return new Iterator<E>() {
            private LinkedNode<E> previous = null;
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
                return !(current == head && previous != null);
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements to list");
                }
                E element = current.get();
                previous = current;
                current = current.getNext();
                next = next.getNext();
                return element;
            }
        };
    }
}
