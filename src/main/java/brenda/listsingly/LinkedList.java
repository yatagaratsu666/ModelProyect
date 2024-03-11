package brenda.listsingly;

import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.logging.Level;
import java.util.logging.Logger;
import brenda.util.collection.Collection;
import brenda.util.iterator.Iterator;
import brenda.util.list.AbstractList;
import brenda.util.list.List;
import brenda.nodesingly.LinkedNode;

/**
 *
 * @author BRENDA
 * @param <E>
 */
public class LinkedList<E> extends AbstractList<E> {

    private LinkedNode<E> head;
    private LinkedNode<E> tail;
    private LinkedNode<E> inode;
    
    public LinkedList(){
        super();
        head = null;
        tail = null;
        inode = null;
    }
    
    public LinkedList(E element){
        super();
        add(element);
    }
    
    @Override
    public boolean add(E element) {//verified
        try {
            if (isEmpty()) {
                LinkedNode<E> node = new LinkedNode<>(element);
                node.set(element);
                head = node;
                tail = node;
                size++;
            } else {
                LinkedNode<E> node = new LinkedNode(element);
                node.set(element);
                tail.setNext(node);
                tail = node;
                size++;
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    @Override
    public boolean clear() { //verified
        head = null;
        tail = null;
        inode = null;
        size = 0;
        return true;
    }

    @Override
    public boolean contains(E element) { //verified
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
    public boolean contains(E[] array) { //verified
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
    public boolean contains(Collection<E> collection) { //verified
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
    public boolean isEmpty() {//verified
        return head == null && tail == null && inode == null && size == 0;
    }

    @Override
    public boolean reverse() { //verified
        if (isEmpty() || size() == 1) {
            return true; 
        }
        LinkedNode<E> previous = null;
        LinkedNode<E> current = head;
        LinkedNode<E> next;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);

            previous = current;
            current = next;
        }
        tail = head;
        head = previous;
        return true;
    }

    @Override
    public int size() {//verified
        return size;
    }

    @Override
    public void forEach(Function<E, Void> action) {//verified
        Iterator<E> iter = this.iterator();

        while(iter.hasNext()){
            action.apply(iter.next()); 
        }   
    }

    @Override
    public Iterator<E> iterator() {//verified (no lee nulos)
        inode = head;
        return new Iterator<E>(){
            @Override
            public boolean hasNext() {
                return inode != null; 
            }

            @Override
            public E next() {
                if(!hasNext()){
                    throw new NoSuchElementException("no more elements in the list :<");
                }
                E element = inode.get();
                inode = inode.getNext();
                return element;
            }
        };
    }

    @Override
    public boolean add(E[] array) {//verified
        if (array.length <= 0) {
            return false;
        }
        else{
        for (int i = 0; i < array.length; i++) {
            add(array[i]);
            }          
        }
        return true;
    }

    @Override
    public boolean add(Collection<E> collection) {//verified
        if (collection.size() <= 0){
            return false;
        }
        else{
           Iterator<E> iter = collection.iterator();
           while(iter.hasNext() == true){
               add(iter.next());
           }
           return true;
        } 
    }
    @Override
    public boolean addFirst(E element){//verified
        LinkedNode<E> node = new LinkedNode<>(element);
        if(isEmpty()){
            node.set(element);
            head=node;
            tail = node;
            size++;
        } else{
            node.set(element);
            node.setNext(head);
            head = node;
            size++;
        }
        return true;
    }
    @Override
    public boolean addFirst(E[] array){//verified
        if (array.length <= 0) {
            return false;
        }
        else{
        for (int i = 0; i < array.length; i++) {
            addFirst(array[i]);
            }  
        return true;        
        }
    }

    @Override
    public boolean addFirst(Collection<E> collection) {//verified
        if (collection.isEmpty()) {
            return false;
        }

        Iterator<E> iter = collection.iterator();
        while (iter.hasNext()) {
            addFirst(iter.next());
        }
        return true;
    }

    @Override
    public E peek() {//verified
        if (isEmpty()) {
            return null;
        }
        return head.get();
    }

    @Override
    public E peekLast() {//verified
        if (isEmpty()) {
            return null;
        }
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
            save[i] = current.get();
        }
        return save;
    }

    @Override
    public List<E> peekCollection(int index) {//verified
        E data = (E) head;
        LinkedList list = new LinkedList<>();
        LinkedNode<E> node = new LinkedNode<>(data);
        node.set((E) head);
        for (int i = 0; i < index; i++) {
            list.add(data);
            data = (E) head.getNext();
            node.set((E) head);
        }
        return list;
    }

    @Override
    public List<E> peekLastCollection(int index) {//verified
        try {
            LinkedNode<E> current = head;
            LinkedList list = new LinkedList<>();
            for (int e = 0; e < size - index - 1; e++) {
                current = current.getNext();
            }
            for (int i = 0; i < index; i++) {
                current = current.getNext();
                list.add(current.get());
            }
            return list;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    @Override
    public E poll() {//verified
        if (isEmpty()) {
            return null; 
        }
        E data = head.get();
        head = head.getNext();
        size--;
        return data;
    }

    @Override
    public E pollLast() {//verified
        if (isEmpty()) {
            return null;
        }

        E data = tail.get();

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            LinkedNode<E> previousToTail = head;
            while (previousToTail.getNext() != tail) {
                previousToTail = previousToTail.getNext();
            }
            previousToTail.setNext(null);
            tail = previousToTail;
        }
        size--;
        return data;
    }

    @Override
    public E[] pollArray(int n) {//verified
        if (n <= 0 || n > size || isEmpty()) {
            throw new IndexOutOfBoundsException("Invalid index or list is empty");
        }

        E[] arrayCopy = (E[]) new Object[n];
        for (int i = 0; i < n; i++) {
            if (head == null) {
                break; // No hay más elementos para recoger
            }
            arrayCopy[i] = head.get();
            head = head.getNext();
            size--;
        }
        return arrayCopy;
    }

//        E data = (E) head;
//        E[] arrayCopy = (E[]) new Object[index];
//        LinkedNode<E> node = new LinkedNode<>(data);
//        node.set((E) head);
//        for (int i = 0; i < index; i++) {
//            arrayCopy[i] = (E) data;
//            head = head.getNext();
//            node.setNext(head.getNext());
//            data = (E) head;
//            node.set((E) head);
//            size--;
//        }
//        return arrayCopy;
//        }

    @Override
    public E[] pollLastArray(int index) {//verified
        try {
            LinkedNode<E> current = head;
            for (int e = 0; e < size - index - 1; e++) {
                current = current.getNext();
            }
            LinkedNode<E> newTail = current;
            E[] save = (E[]) new Object[index];
            for (int i = 0; i < index; i++) {
                current = current.getNext();
                save[i] = current.get();
                size--;
            }
            if (size == 0) {
                head = null;
                tail = null;
            } else {
                newTail.setNext(null);
                this.tail = newTail;
            }
            return save;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<E> pollCollection(int index) {//verified
        E data = (E) head;
        LinkedList ayuda = new LinkedList<>();
        LinkedNode<E> node = new LinkedNode<>(data);
        node.set((E) head);
        for (int i = 0; i < index; i++) {
            ayuda.add(data);
            head = head.getNext();
            node.setNext(head.getNext());
            data = (E) head;
            node.set((E) head);
            size--;
        }
        return ayuda;
    }

    @Override
    public List<E> pollLastCollection(int index) {//verified
        LinkedList ayuda = new LinkedList();
        try {
            LinkedNode<E> current = head;
            for (int e = 0; e < size - index - 1; e++) {
                current = current.getNext();
            }
            LinkedNode<E> newTail = current;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
                ayuda.add(current.get());
                size--;
            }
            if (size == 0) {
                head = null;
                tail = null;
            } else {
                newTail.setNext(null);
                this.tail = newTail;
            }
            return ayuda;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }

    @Override
    public boolean remove(E element) {//verified
        if (isEmpty()) {
            return false;
        }
        if (head.get().equals(element)) {
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
            return true;
        }
        LinkedNode<E> current = head;
        while (current.getNext() != null) {
            if (current.getNext().get().equals(element)) {
                if (current.getNext() == tail) {
                    tail = current;
                }
                current.setNext(current.getNext().getNext());
                return true;
            }
            current = current.getNext();
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
        boolean data = false;
        Iterator<E> iter = collection.iterator();
        if (collection.isEmpty()) {
            return false;
        }
        while (iter.hasNext()) {
            E element = iter.next();
            if (remove(element)) {
                data = true;
            }
        }
        return data;
    }

    @Override
    public boolean replace(E[] array, E[] newArray, Predicate<E> comparator) {//verified
        boolean replaced = false;
        for (int j = 0; j < array.length; j++) {
            if (comparator.test(array[j])) {
                if (replace(array[j], newArray[j], comparator)) {
                    replaced = true;
                }
            }
        }
        return replaced;
    }

    @Override
    public boolean replace(Collection<E> collection, Collection<E> newCollection, Predicate<E> comparator) {//verified
        if (collection.isEmpty() || newCollection.isEmpty()) {
            return false;
        }
        boolean replaced = false;
        Iterator<E> iterator = collection.iterator();
        Iterator<E> iteratora = newCollection.iterator();
        while (iterator.hasNext() && iteratora.hasNext()) {
            E element = iterator.next();
            E elemento = iteratora.next();
            if (comparator.test(element)) {
                if (replace(element, elemento, comparator)) {
                    replaced = true;
                }
            }
        }
        return replaced;
    }

    @Override
    public boolean retain(E[] array) {//verified
        if (isEmpty()) {
            return false;
        }

        boolean modified = false;
        LinkedNode<E> current = head;
        LinkedNode<E> prev = null;

        while (current != null) {
            boolean found = false;
            for (E element : array) {
                if (current.get().equals(element)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                if (prev != null) {
                    prev.setNext(current.getNext());
                } else {
                    head = current.getNext();
                }
                if (current == tail) {
                    tail = prev;
                }
                modified = true;
            } else {
                prev = current;
            }
            current = current.getNext();
        }

        return modified;
    }

    @Override
    public boolean retain(Collection<E> collection) {//verified
        if (isEmpty()) {
            return false;
        }
        boolean modified = false;
        LinkedNode<E> current = head;
        LinkedNode<E> prev = null;

        while (current != null) {
            boolean found = false;
            Iterator<E> iterator = collection.iterator();
            while (iterator.hasNext()) {
                E element = iterator.next();
                if (current.get().equals(element)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                if (prev != null) {
                    prev.setNext(current.getNext());
                } else {
                    head = current.getNext();
                }
                if (current == tail) {
                    tail = prev;
                }
                modified = true;
            } else {
                prev = current;
            }
            current = current.getNext();
        }
        return modified;
    }

    @Override
    public boolean set(E index, E element) {//verified
        if (isEmpty()) {
            return false; 
        }

        LinkedNode<E> current = head;
        while (current != null) {
            if (current.get().equals(index)) {
                current.set(element);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public boolean sort(ToIntFunction<E> toInt) {//idk
        if(size <=1){
            return false;   
        }
        boolean base;
        do{
            base = false;
            LinkedNode<E> current = head;
            LinkedNode<E> next = head.getNext();
            LinkedNode<E> previous = null;
            while(next != null){
                int currentInt = toInt.applyAsInt(current.get());
                int nextInt = toInt.applyAsInt(next.get());
                if(currentInt > nextInt){
                    if(previous == null){
                        head = next;
                    }else{
                        previous.setNext(next);
                    }
                    current.setNext(next.getNext());
                    next.setNext(current);
                    if(current.getNext() == null){
                        tail = current;
                    }
                    base = true;
                }
                previous = current;
                current = next;
                next = next.getNext();
            }
        }while(base);
        tail.setNext(null);
        return true;
//        if (isEmpty()) {
//            return false;
//        }
//        LinkedNode<E> current = head.getNext();
//        while (current != null) {
//            E key = current.get();
//            LinkedNode<E> next = current.getNext();
//            LinkedNode<E> prev = head;
//            while (prev != current && toInt.applyAsInt(prev.get()) <= toInt.applyAsInt(key)) {
//                prev = prev.getNext();
//            }
//            while (next != null && toInt.applyAsInt(next.get()) < toInt.applyAsInt(key)) {
//                next.set(prev.get());
//                prev = prev.getNext();
//                next = next.getNext();
//            }
//            if (prev == current) {
//                head.set(key);
//            } else {
//                prev.set(key);
//            }
//            current = current.getNext();
//        }
//        return true;
    }

    @Override
    public List<E> subList(E fromE, E toE) {//verified
        LinkedList<E> list = new LinkedList<>();
        boolean BaseDeFromE = false;
        LinkedNode<E> current = head;
        while (current != null) {
            if (!BaseDeFromE && current.get().equals(fromE)) {
                BaseDeFromE = true;
            }
            if (BaseDeFromE) {
                if (current.get().equals(toE) == false) {
                    list.add(current.get());
                }
            }
            current = current.getNext();
        }
        return list;
    }

    @Override
    public E[] toArray() {//verified
        LinkedNode Ayuda = head;
        E[] Muerte = (E[]) new Object[size];
        for(int i = 0; i < size; i++){
            Muerte[i] = (E) Ayuda.get();
            Ayuda = Ayuda.getNext(); 
        }
        return Muerte;
    }

    @Override
    public boolean remove(Predicate<E> filter) {//verified
        boolean answer = false;
        LinkedNode<E> current = head;
        LinkedNode<E> prev = null;

        while (current != null) {
            if (filter.test(current.get())) {
                if (prev == null) {
                    head = current.getNext();
                    if (head == null) {
                        tail = null;
                    }
                } else {
                    prev.setNext(current.getNext());
                    if (current.getNext() == null) {
                        tail = prev;
                    }
                }
                size--;
                answer = true;
            } else {
                prev = current;
            }
            current = current.getNext();
        }
        return answer;
//        boolean answer = false;
//        Iterator<E> iter = this.iterator();
//        while(iter.hasNext()){
//            E data = iter.next();
//            if(filter.test(data)){
//                remove(data);
//                answer = true;
//                return answer;
//            }
//        }
//        return answer;
    }

    @Override
    public boolean replace(E element, E newElement, Predicate<E> comparator) {//verified
        if(isEmpty()){
            return false;
        }
        LinkedNode<E> ayuda = head;
        boolean replaced = false;
        while(ayuda != null){
            if(comparator.test((E)ayuda.get())&& ayuda.get().equals(element)){
                ayuda.set(newElement);
                replaced = true;
            }
            ayuda = ayuda.getNext();
        }
        return replaced;
    }
}

