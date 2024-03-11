
package brenda.listdoubly;

import brenda.nodedoubly.LinkedNode;
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


public class DoublyLinkedList<E> extends AbstractList<E> {

    LinkedNode<E> head;
    LinkedNode<E> tail;

    public DoublyLinkedList() {
        super();
        this.head = null;
        this.tail = null;
    }

    @Override
    public boolean add(E element) {//verified
        try {
            LinkedNode<E> newNode = new LinkedNode<>(element);
            if (size == 0) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.setPrevious(tail);
                tail.setNext(newNode);
                tail = newNode;
                tail.setNext(null);
            }
            size++;
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean add(E[] array) {//verified
        if (array == null || array.length == 0) {
            return false;
        }

        for (E element : array) {
            add(element);
        }

        return true;
    }

    @Override
    public boolean add(Collection<E> collection) {//verified
        if (collection == null || collection.isEmpty()) {
            return false;
        }

        boolean added = false;
        Iterator<E> iterator = collection.iterator();
        while (iterator.hasNext()) {
            add(iterator.next());
            added = true;
        }
        return added;
    }

    @Override
    public boolean addFirst(E element) {//verified
        try {
            LinkedNode<E> newNode = new LinkedNode<>(element);
            if (size == 0) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.setNext(head);
                head.setPrevious(newNode);
                head = newNode;
                head.setPrevious(null);
            }
            size++;
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean addFirst(E[] array) {//verified
        if (array == null || array.length == 0) {
            return false;
        }
        for (int i = array.length - 1; i >= 0; i--) {
            addFirst(array[i]);
        }
        return true;
    }

    @Override
    public boolean addFirst(Collection<E> collection) {//verified
        try {
            Iterator<E> iterator = collection.iterator();

            LinkedNode<E> reversedList = null;
            while (iterator.hasNext()) {
                E element = iterator.next();
                LinkedNode<E> newNode = new LinkedNode<>(element, reversedList, null);
                reversedList = newNode;
            }

            LinkedNode<E> current = reversedList;
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
        return tail.get();
    }

    @Override
    public E[] peekArray(int index) {//verified
        E data = (E) head.get();
        E[] arrayCopy = (E[]) new Object[index];
        LinkedNode<E> node = new LinkedNode<>(data);
        node.set((E) head.get());
        for (int i = 0; i < index; i++) {
            arrayCopy[i] = (E) data;
            data = (E) head.getNext();
            node.set((E) head.get());
        }
        return arrayCopy;
    }

    @Override
    public E[] peekLastArray(int index) {//verified
        LinkedNode<E> current = head;
        for (int e = 0; e < size - index - 1; e++) {
            current = current.getNext();
        }
        E[] save = (E[]) new Object[index];
        for (int i = 0; i < index; i++) {
            current = current.getNext();
            if(size == index){
                throw new NoSuchElementException("No more elements to list");
            }else{
                save[i] = current.get();
            }
        }
        return save;
    }

    @Override
    public List<E> peekCollection(int index) {//verified
        LinkedNode<E> current = head;
        DoublyLinkedList<E> save = new DoublyLinkedList<>();
        for (int i = 0; i < index && current != null; i++) {
            save.add(current.get());
            current = current.getNext();
        }
        return save;
    }

    @Override
    public List<E> peekLastCollection(int index) {//verified
        if (index > size) {
                index = size;
            }
            LinkedNode<E> current = this.head;
            DoublyLinkedList<E> save = new DoublyLinkedList<>();
            for (int e = 0; e < size - index; e++) {
                current = current.getNext();
            }
            for (int i = 0; i < index && current != null; i++) {
                save.add(current.get());
                current = current.getNext();
            }
            return save;
    }

    @Override
    public E poll() {//verified
        if (size == 0) {
            return null;
        } else {
            E entrega = head.get();
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                LinkedNode<E> next = head.getNext();
                next.setPrevious(null);
                head.setNext(null);
                head = next;
            }
            size--;
            return entrega;
        }
    }

    @Override
    public E pollLast() {//verified
        if (size == 0) {
            return null;
        } else {
            E entrega = tail.get();
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                LinkedNode<E> previous = tail.getPrevious();
                previous.setNext(null);
                tail.setPrevious(null);
                tail = previous;
            }
            size--;
            return entrega;
        }
    }

    @Override
    public E[] pollArray(int index) {//verified
        E[] save = (E[]) new Object[index];
        if (index < size) {
            for (int i = 0; i < index; i++) {
                save[i] = poll();
            }
        } else {
            System.arraycopy(toArray(), 0, save, 0, size);
            head = null;
            tail = null;
            size = 0;
        }
        return save;
    }

    @Override
    public E[] pollLastArray(int index) {//verified
        LinkedNode<E> current = head;
        int i = 0;
        E[] save = peekLastArray(index);
        while (current != null) {
            if (i >= (size - index)) {
                remove((E) current.get());
            }
            current = current.getNext();
            i++;
        }
        if (current != null) {
            current.setNext(null);
        }
        return save;
    }

    @Override
    public List<E> pollCollection(int index) {//verified
        LinkedNode<E> current = head;
        DoublyLinkedList<E> save = new DoublyLinkedList<>();
        for (int i = 0; i < index && current != null; i++) {
            save.add(current.get());
            current = current.getNext();
            size--;
        }
        if (size == 0) {
            head = null;
            tail = null;
        } else {
            if (size == 1) {
                head = current;
                head.setNext(null);
                head.setPrevious(null);
                tail = current;
                tail.setNext(null);
                tail.setPrevious(null);
            } else {
                head = current;
                head.setPrevious(null);
            }
        }
        return save;
    }

    @Override
    public List<E> pollLastCollection(int index) {//verified
        DoublyLinkedList<E> list = new DoublyLinkedList<>();
        if (index < size) {
            for (int i = index - 1; i >= 0; i--) {
                list.addFirst(pollLast());
            }
        } else {
            for (int i = 0; i < size; i++) {
                list.addFirst(pollLast());
            }
            head = null;
            tail = null;
            size = 0;
        }
        return list;
    }

    @Override
    public boolean remove(E element) {//verified
        try {
            LinkedNode<E> current = head;
            LinkedNode<E> previous = null;
            while (current != null && !current.get().equals(element)) {
                previous = current;
                current = current.getNext();
            }
            if (current == null) {
                return false;
            }
            if (current == head) {
                head = current.getNext();
                head.setPrevious(null);
            } else {
                if (current == tail) {
                    previous.setNext(current.getNext());
                    tail = previous;
                    tail.setNext(null);
                } else {
                    previous.setNext(current.getNext());
                    current.getNext().setPrevious(previous);
                }
            }
            size--;
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean remove(E[] array) {//verified
        boolean removed = false;
        for (E element : array) {
            if (remove(element)) {
                removed = true;
            }
        }
        return removed;
    }

    @Override
    public boolean remove(Collection<E> collection) {//verified
        Iterator<E> iterator = collection.iterator();
        boolean removed = false;
        while (iterator.hasNext()) {
            E element = iterator.next();
            if (remove(element)) {
                removed = true;
            }
        }
        return removed;
    }

    @Override
    public boolean remove(Predicate<E> filter) {//verified
        if (isEmpty()) {
            return false;
        }

        boolean removed = false;
        LinkedNode<E> current = head;
        while (current != null) {
            if (filter.test(current.get())) {
                LinkedNode<E> previous = current.getPrevious();
                LinkedNode<E> next = current.getNext();

                if (previous == null) {
                    head = next;
                } else {
                    previous.setNext(next);
                }

                if (next == null) {
                    tail = previous;
                } else {
                    next.setPrevious(previous);
                }
                size--;
                removed = true;
            }
            current = current.getNext();
        }
        return removed;
    }

    @Override
    public boolean replace(E element, E newElement, Predicate<E> comparator) {//verified
        LinkedNode<E> current = head;
        boolean replaced = false;
        while (current != null) {
            if (comparator.test((E) current.get()) && current.get().equals(element)) {
                current.set(newElement);
                replaced = true;
            }
            current = current.getNext();
        }
        return replaced;
    }

    @Override
    public boolean replace(E[] array, E[] newArray, Predicate<E> comparator) {//verified
        LinkedNode<E> current = head;
        boolean elementsReplaced = false;
        while (current != null) {
            if (comparator.test(current.get())) {
                for (int i = 0; i < array.length; i++) {
                    if (current.get().equals(array[i])) {
                        current.set(newArray[i]);
                        elementsReplaced = true;
                        break;
                    }
                }
            }
            current = current.getNext();
        }
        return elementsReplaced;
    }

    @Override
    public boolean replace(Collection<E> collection, Collection<E> newCollection, Predicate<E> comparator) {//verified
        if (isEmpty()) {
            return false;
        }

        boolean elementsReplaced = false;
        Iterator<E> iterator = collection.iterator();
        LinkedNode<E> current = head;
        while (current != null && iterator.hasNext()) {
            E currentElement = current.get();
            if (comparator.test(currentElement) && collection.contains(currentElement)) {
                Iterator<E> newIterator = newCollection.iterator();
                while (newIterator.hasNext()) {
                    E newElement = newIterator.next();
                    if (!collection.contains(newElement)) {
                        current.set(newElement);
                        elementsReplaced = true;
                        break;
                    }
                }
            }
            current = current.getNext();
        }
        return elementsReplaced;
    }
        

    @Override
    public boolean retain(E[] array) {//verified
        LinkedNode<E> current = head;
        LinkedNode<E> previous = null;
        boolean elementsRetained = false;
        while (current != null) {
            boolean elementContained = false;
            for (E arrayElement : array) {
                if (arrayElement.equals(current.get())) {
                    elementContained = true;
                }
            }
            if (!elementContained) {
                if (previous == null) {
                    head = current.getNext();
                    head.setPrevious(null);
                } else {
                    previous.setNext(current.getNext());
                }
                if (current == tail) {
                    tail = previous;
                    tail.setNext(null);
                }
                current = current.getNext();
                elementsRetained = true;
                size--;
            } else {
                previous = current;
                current = current.getNext();
            }
        }
        return elementsRetained;
    }

    @Override
    public boolean retain(Collection<E> collection) {//verified
        LinkedNode<E> current = head;
        LinkedNode<E> previous = null;
        boolean elementsRetained = false;
        while (current != null) {
            if (!collection.contains(current.get())) {
                if (previous == null) {
                    head = current.getNext();
                    head.setPrevious(null);
                } else {
                    previous.setNext(current.getNext());
                }
                if (current == tail) {
                    tail = previous;
                    tail.setNext(null);
                }
                current = current.getNext();
                elementsRetained = true;
                size--;
            } else {
                previous = current;
                current = current.getNext();
            }
        }
        return elementsRetained;
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
    public boolean sort(ToIntFunction<E> toInt) {//idk
        if (size <= 1) {
            return true;
        }
        boolean swapped;
        do {
            swapped = false;
            LinkedNode<E> current = head;
            LinkedNode<E> next = head.getNext();
            LinkedNode<E> previous = null;
            while (next != null) {
                int currentIntValue = toInt.applyAsInt((E) current.get());
                int nextIntValue = toInt.applyAsInt((E) next.get());
                if (currentIntValue > nextIntValue) {
                    if (previous == null) {
                        head = next;
                    } else {
                        previous.setNext(next);
                    }
                    current.setNext(next.getNext());
                    next.setNext(current);
                    if (current.getNext() == null) {
                        tail = current;
                    }
                    swapped = true;
                }
                previous = current;
                current = next;
                next = next.getNext();
            }
        } while (swapped);
        tail.setNext(null);
        return true;
    }

    @Override
    public List<E> subList(E from, E to) {//verified
        LinkedNode<E> current = head;
        DoublyLinkedList<E> newList = new DoublyLinkedList<>();
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
        LinkedNode current = head;
        int i = 0;
        while (current != null) {
            array[i] = (E) current.get();
            current = current.getNext();
            i++;
        }
        return array;
    }

    @Override
    public boolean clear() {//verified
        head.setNext(null);
        tail.setPrevious(null);
        head = null;
        tail = null;
        size = 0;
        return true;
    }

    @Override
    public boolean contains(E element) {//verified
        LinkedNode<E> current = head;
        while (current != null) {
            if (current.get().equals(element)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public boolean contains(E[] array) {//verified
        if (isEmpty() || array.length == 0) {
            return false;
        }
        for (E element : array) {
            boolean found = false;
            LinkedNode<E> current = head;
            while (current != null) {
                if (current.get().equals(element)) {
                    found = true;
                    break;
                }
                current = current.getNext();
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean contains(Collection<E> collection) {//verified
        if (isEmpty()) {
            return false;
        }

        Iterator<E> iter = collection.iterator();
        while (iter.hasNext()) {
            E element = iter.next();
            boolean found = false;
            LinkedNode<E> current = head;
            while (current != null) {
                if (current.get().equals(element)) {
                    found = true;
                    break;
                }
                current = current.getNext();
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isEmpty() {//verified
        return head == null && tail == null && size == 0;
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
            E element = (E) action.apply(current.get());
            current.set(element);
            current = current.getNext();
        }
    }

    @Override
    public Iterator<E> iterator() {//verified
        return new Iterator<E>() {
            LinkedNode<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements to list");
                }
                E element = current.get();
                current = current.getNext();
                return element;
            }
        };
    }
    
    public DoublyLinkedList(E element) {
        super();
        add(element);
    }

    public DoublyLinkedList(E[] array) {
        super();
        for (E element : array) {
            add(element);
        }
    }
}
