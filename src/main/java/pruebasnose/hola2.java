
package pruebasnose;

import brenda.circularlist.LinkedList;
import brenda.util.collection.Collection;
import brenda.util.iterator.Iterator;
import java.util.function.Function;
import java.util.function.Predicate;


public class hola2 {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        list.add(9990);
        list.add(99);
        list.addFirst(5);
        Function<Integer, Void> square = (number) -> {
            int result = number * number;
            System.out.println("El cuadrado de " + number + " es: " + result);
            return null;
        };
        list.forEach(square);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
