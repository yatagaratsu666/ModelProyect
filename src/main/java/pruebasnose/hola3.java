
package pruebasnose;

import brenda.doublycircularlist.LinkedListDoubly;
import brenda.listdoubly.DoublyLinkedList;
import brenda.listsingly.LinkedList;
import brenda.util.iterator.Iterator;
import java.util.function.Function;
import java.util.function.Predicate;



public class hola3 {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list1 = new DoublyLinkedList<>();
        list1.add(5);
        list1.add(10);
        list1.add(15);
        list1.addFirst(0);
        list1.pollLast();
//        DoublyLinkedList<Integer> list2 = new DoublyLinkedList<>();
//        list2.add(12);
//        list2.add(34);
//        list2.add(345);
//        Function<Integer, Void> action = (Integer element) -> {
//            System.out.println(element + 2);
//            return null;
//        };
//        for(int i = 0; i < array.length; i++ ){
//            System.out.println(array[i]);
//        }           
//        Iterator iterator = list1.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
        Iterator iterato = list1.iterator();
        while (iterato.hasNext()) {
            System.out.println(iterato.next());
        }
    }
}
