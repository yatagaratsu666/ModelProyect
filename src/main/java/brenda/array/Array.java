package brenda.array;

import java.util.function.Function;
import java.util.function.Predicate;
import brenda.util.array.AbstractArray2;
import brenda.util.collection.Collection;
import brenda.util.iterator.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Array<E> extends AbstractArray2<E> {

    protected E elements[];

    public Array(int amtData) {
        elements = (E[]) new Object[amtData];
    }
    
    public Array(E[] data){
        elements = (E[]) new Object[data.length];
        add(0, data);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                if (i < elements.length) {
                    return true;
                } else {
                    return false;
                }
            }
            @Override
            public E next() {
                return elements[i++];
            }
        };
    }

    @Override
    public boolean add(E element) {//verified
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                elements[i] = element;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(int index, E[] array) {//verified
        for (int i = 0; i < array.length; i++) {
            if (index >= 0 && index < elements.length) {
                for (int j = elements.length - 1; j > index; j--) {
                    elements[j] = elements[j - 1];
                }
                elements[index] = array[i];
            } else if (index == elements.length) {
                elements[index - 1] = array[i];
            } else {
                break;
            }
            index++;
        }
        return true;
    }

    @Override
    public boolean add(int index, Collection<E> collection) {
    Iterator<E> iterator = collection.iterator();
    try {
        while (iterator.hasNext()) {
            E element = iterator.next();
            if (index >= 0 && index < elements.length) {
                for (int i = elements.length - 1; i > index; i--) {
                    elements[i] = elements[i - 1];
                }
                elements[index] = element;
            } else if (index == elements.length) {
                elements[index - 1] = element;
            } else {
                break;
            }
            index++;
        }
        return true;
    } catch (Exception e) {
        Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
    }
    return false;
//        Iterator<E> iterator = collection.iterator();
//        if(index == 0){
//            return false;
//        }
//        else{
//            while(iterator.hasNext()){
//                if(index < elements.length){
//                    elements[index]=iterator.next();
//                    index++;
//                }
//            }
//            return true;
//        }
    }

    @Override
    public void defragment() {//verified
        int base = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                elements[base++] = elements[i];
            }
        }
        for (int i = base; i < elements.length; i++) {
            elements[i] = null;
        }
    }

    @Override
    public E get(int index) {//verified
        try{
            return elements[index];
        }catch (Exception e){
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return elements[index];
    }

    @Override
    public boolean remove(int index) {//verified
        if(elements[index] != null){
            elements[index] = null;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean remove(Predicate<E> filter) {//verified
        boolean removed = false;
        for(int i = 0; i < elements.length; i++){
            E element = elements[i];
            if(element != null && filter.test(element)){
                remove(i);
                removed = true;
                i--;
            }
        }
        return removed;
    }

    @Override
    public boolean remove(int fromIndex, int toIndex) {//verified
        for (int i = fromIndex; i < toIndex; i++) {
            elements[i] = null;
        }
        return true;
    }

    @Override
    public boolean dimension(int newDimension) {//verified
        E[] modified =(E[]) new Object[newDimension];
        int start = 0;
        for (int i = 0; i < newDimension; i++) {
            modified[start]=elements[i];
            start++;
            if(newDimension < elements.length){
            }
        }
        elements = modified;
        return true;
    }

    @Override
    public boolean set(int index, E element) {//verified
        if (elements[index] != null) {
            elements[index] = element;
            return true;
        }
        return false;
    }

    @Override
    public boolean clear() {//verified
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
        return true;
    }

    @Override
    public boolean reverse() {//verified
        E aux;
        for (int i=0; i<elements.length;i++){
            for (int j = i+1; i < j && j < elements.length; j++) {
                aux = elements[i];
                elements[i] = elements[j];
                elements[j] = aux;
            }
        }
        return true;
    }
    
    @Override
    public void forEach(Function<E, Void> action){//verified
        for(int i = 0; i < elements.length; i++){
            action.apply(elements[i]);
        }    
    }

    @Override
    public int indexOf(E element){//verified
        for(int i = 0; i < elements.length; i++){
            if(elements[i]== element){
                return i;
            }
        }
        return -1;
    } 
    
    @Override
    public int lastIndexOf(E element){//verified
        for(int i = elements.length-1; i > -1; i--){
            if(elements[i].equals(element)){
                return i;
            }
            else{
            }
        }
        return -1;
    } 

    @Override
    public boolean contains(E element){//verified
        for (int i = 0; i < elements.length; i++){
            if(elements[i] == element){
            }
        }
        return true;
    }

    @Override
    public boolean contains(E[] array) {
        for (int i = 0; i < array.length; i++) {
            if (!this.contains(array[i])) {
                return false;
            }
        }
        return true;
    }
//        int aux = 0;
//        boolean returned = false;
//        for(int i = 0; i < elements.length; i++){
//            if(this.add(array[i]) == true){
//                aux++;
//                returned = true;
//            }
//        }
//        if(aux == array.length){
//            returned = true;
//        }
//        return returned;
    
    @Override
    public boolean contains(Collection<E> collection) {//verified
        Iterator<E> iterator = collection.iterator();
        while(iterator.hasNext()){
            if(this.contains(iterator.next()) == false){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isEmpty(){//verified
        int c = 0;
        for(int i = 0; i < elements.length; i++){
            if(elements[i]== null){
                c++;
            }
        }
        if(c == elements.length){
            return true;
        }
        return false;
    }


    @Override
    public int size(){//verified
        return elements.length;
    }
}
