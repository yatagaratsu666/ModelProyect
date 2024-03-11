
package models;

import brenda.array.Array;
import brenda.doublycircularlist.LinkedListDoubly;
import brenda.listsingly.LinkedList;
import brenda.util.iterator.Iterator;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    
    @Test
    void prueba(){
    LinkedList<Integer> miku = new LinkedList<>();
    miku.add(5);
    miku.add(4);
    miku.add(3);
    Array<Integer> miku1 = new Array(2);
    miku1.add(4);
    miku1.add(3);
    assertTrue(miku.remove(miku1));
    }
    
    @Test
    void testReplaceArray() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(23);
        list.add(30);
        list.add(20);

        assertTrue(list.replace(new Integer[]{23, 30}, new Integer[]{25, 35}, e -> e > 22));
        Integer[] expected = {25, 35, 20};
        int i = 0;
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(expected[i++], it.next());
        }
    }
    
    @Test
    void toArray(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(23);
        list.add(30);
        list.add(20);
        Object[] array;
        array = list.toArray();
        Object[] expected = {23,30,20};
        for (int i = 0; i < list.size(); i++) {
            assertEquals(expected[i], array[i]);
        }
        int i = 0;
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            assertEquals(array[i++], it.next());
        }
    }
    
    @Test
    void containsConArray(){
        Array<Integer> list = new Array(3);
        list.add(23);
        list.add(30);
        list.add(20);
        Integer[] expected = {23,30};
        list.contains(expected);
        Iterator<Integer> it = list.iterator();
        assertTrue(list.contains(expected));
    }
    
    @Test
    void containsArray(){
        Array<Integer> list = new Array(3);
        list.add(23);
        list.add(30);
        list.add(20);
        assertTrue(list.contains(30));
    }
   
    
    @Test
    void containsArrayconCollection(){
        Array<Integer> list = new Array(3);
        list.add(23);
        list.add(30);
        list.add(20);
        Array<Integer> list1 = new Array(3);
        list1.add(23);
        list1.add(20);
        assertTrue(list.contains(list1));
    }
    @Test
    void testPollLastArray() {
        LinkedListDoubly<Integer> list = new LinkedListDoubly<>();
        list.add(23);
        list.add(30);
        list.add(20);
        Object[] expected = {30, 20};
        assertEquals(3, list.size());
        Object[] receive = list.pollLastArray(2);
        assertEquals(1, list.size());
        int i = 0;
        for (Object e : receive) {
            assertEquals(expected[i++], e);
        }
        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertEquals(23, it.next());
        }
    }
     void testPollArray1() {
        // Crear una lista y agregar algunos elementos
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(2);

        // Crear un array esperado con los elementos que se eliminarán de la lista
        Object[] expected = {5, 2};

        // Obtener los elementos eliminados de la lista
        Object[] received = list.pollArray(2);

        // Comprobar si los elementos recibidos coinciden con los esperados
        assertArrayEquals(expected, received);

        // Comprobar si el tamaño de la lista se actualiza correctamente después de eliminar los elementos
        assertEquals(0, list.size());
        
        
    }
    
}
