package pruebasnose;

import java.util.function.Predicate;
import brenda.util.iterator.Iterator;
import brenda.listsingly.LinkedList;
import brenda.array.Array;
import brenda.stack.list.Stack;
import brenda.util.collection.Collection;
import java.util.Comparator;
import java.util.HashMap;
import static java.util.Locale.filter;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import javax.swing.JOptionPane;

public class hola {

    public static void main(String[] args) {
        
        Stack<Integer> stack = new Stack<>();
        
        stack.push(5);
        stack.push(3);
        stack.push(9);
        stack.pop();
        System.out.println(stack.peek());
        Iterator ite = stack.iterator();
        while (ite.hasNext()) {
            System.out.println(ite.next());
        }
        
//        LinkedList<Object> list1 = new LinkedList<>();
//        HashMap<Integer, Boolean> hash1 = new HashMap<>();
//        hash1.put(1, false);
//        list1.add(hash1);
//        LinkedList<Object> list = new LinkedList<>();
//        hash.put("chao", list1.get(1));
//        hash.put("vuelve", list1.get(1));
//        list.add(hash);
////        list.remove(hash);
//        Iterator ite = list.iterator();
//        while (ite.hasNext()) {
//            System.out.println(ite.next());
//        }
//        LinkedList<Datos> list = new LinkedList<>();
//        list.add(lista);
//        Object[] array = list.toArray();
//        Object[] array1 = array;
//        for(int i = 0; i < array1.length; i++){
//            System.out.println(array1[i]);
//        }
    }
}
//        Array<Integer> list = new Array(3);
//        list.add(23);
//        list.add(30);
//        list.add(20);
//        Integer[] expected = {23,30};
//        Iterator<Integer> it = list.iterator();
//        System.out.println(list.contains(expected));
//        
////        LinkedList<Integer> list = new LinkedList<>();
//        LinkedList<Integer> list1 = new LinkedList<>();
//        list1.add(99);
//        list1.add(994);
////        list.add(2);
////        list.add(5);
////        list.add(6);
////        list1.add(2);
////        list1.add(6);
//        Integer[] array1 = new Integer[2];
//        array1[0]=2;
//        array1[1]=7;
//        System.out.println(list.size());
////        Integer[] array2 = new Integer[2];
////        array2[0]=5;
////        array2[1]=99;
//        LinkedList<Integer> list2 = new LinkedList<>();
//        list2.add(4);
//        list2.add(9);
//        Predicate<Integer> comparator = i -> (i%2 == 0);
//        list.replace(list1, list2, comparator);
////          list1 = (LinkedList<Integer>) list.peekLastCollection(1);
////        LinkedList<Integer> list1 = new LinkedList<>();
////list.retain(list1);
////        list1.add(9);
////        list1.add(7);
////        list1.add(77);
////        list.retain(list1);
////        Object[] list1 = list.toArray();
////        for (int i = 0; i < array1.length; i++) {
////            System.out.println(array1[i]);
////        }
////        Predicate<Integer> filter = n -> n == 7;
////        list.remove(filter);
////        Iterator it = list1.iterator();
////        while (it.hasNext()) {
////            System.out.println(it.next());
////        }
//        System.out.println("-----------------------");
//        Iterator ite = list.iterator();
//        while (ite.hasNext()) {
//            System.out.println(ite.next());
//        }
//        System.out.println("-----------------------");
//    }
//}
//------------------- PRUEBA 11 --------------------
//        Array<Integer> array = new Array(4);
//        LinkedList<Integer> list = new LinkedList<>();
//        LinkedList<Integer> list1 = new LinkedList<>();
//        Integer[] array1 = new Integer[2];
//        array1[0]=8;
//        array1[1]=2;
//        array.add(0, array1);
//        array.add(67);
//        array.add(37);
//        array.set(0, 88);
//        list.add(array);
//        list1.add(2);
//        list1.add(37);
//        System.out.println(list.remove(list1));
        // Imprimir la lista para verificar los resultados
//        Integer[] array = new Integer[2];
//        LinkedList<Integer> list = new LinkedList<>();
////        Array<Integer> arrays = new Array(1);
//        for (int i = 0; i < array.length; i++) {
//            array[i] = Integer.valueOf(JOptionPane.showInputDialog("ingrese un numero: "));
//        }
//        list.add(5);
//        list.addFirst(array);
//        System.out.println("------------ ARRAY -----------");
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            System.out.println(iter.next());
//        }

//--------------------- PRUEBA 10 --------------------
//        LinkedList<Integer> list = new LinkedList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//
//        Function<Integer, Void> action = (Integer element) -> {
//            System.out.println(element + 2);
//            return null;
//        };
//        list.forEach(action);
//        LinkedList<Integer> list = new LinkedList<>();
//        Integer[] array = new Integer[3];
//        Integer[] miku = new Integer[2];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = Integer.valueOf(JOptionPane.showInputDialog("ingrese un numero: "));
//        }
////        Array miku = new Array(2);
////        miku.add(2);
////        miku.add(6);
////        for (int i = 0; i < miku.length; i++) {
////            miku[i] = Integer.valueOf(JOptionPane.showInputDialog("ingrese un numero: "));
////        }
//        list.add(array);
//        list.reverse();
//        System.out.println("------------ ARRAY -----------");
////        System.out.println(list.isEmpty());
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            System.out.println(iter.next());
//---------------------- PRUEBA 10 --------------------
//        list.addFirst(array);
//        System.out.println("-----------------------");
//        list.set("hola", "adios");
//        array1 = list.pollArray(2);
//        System.out.println("-----------------------");
//        for (int i = 0; i < array1.length; i++) {
//            System.out.println(array1[i]);
//        }
//        System.out.println("-----------------------");
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            System.out.println(iter.next());
//        }
//        System.out.println("-----------------------");
//        System.out.println(list.peek());
//        System.out.println(list.peekLast());
//    }
//}
//        LinkedList<String> list = new LinkedList<>();
//        String[] array1 = new String[2];
//        String[] array12 = new String[1];
//        for (int i = 0; i < array1.length; i++) {
//            array1[i] = "hola";
//        }
//        Array array = new Array(4);
//        array.add("hola");
//        array.add("holaa");
//        array.add("hola y chao");
//        array.add("chao");
//        list.add(array);
//        System.out.println("------------ peekarray -----------");
//        array12 = list.peekArray(1);
//        for (int i = 0; i < array12.length; i++) {
//            System.out.println(array12[i]);
//        }
//        System.out.println("------------ ARRAY -----------");
//        Iterator ite = list.iterator();
//        while (ite.hasNext()) {
//            System.out.println(ite.next());
//        }
//------------------- PRUEBA 9 ---------------
//        Array array2 = new Array(3);
//        Array<Integer> arrays = new Array(1);
//        arrays.add(5);
//
//        System.out.println("------------ ARRAY -----------");
////        Iterator iter = array1.iterator();
////        while (iter.hasNext()) {
////            System.out.println(iter.next());
////        }
//        System.out.println("------------ ARRAY -----------");
////        Predicate<Integer> filter = n -> n%2 == 0;
////        array.remove(filter);
////        Iterator it = array.iterator();
////        while (it.hasNext()) {
////            System.out.println(it.next());
////        }
////        array1.set(0, 9);
////        array1.clear();
//          array2.add(1, arrays);
//          Iterator iter = array2.iterator();
//        while (iter.hasNext()) {
//            System.out.println(iter.next());
//        }
//        System.out.println(array2.get(2));
//    }
//}
//------------------- PRUEBA 8 ---------------
//        Array array = new Array(3);
//        Array array1 = new Array(1);
//        Array array5 = new Array(2);
//        LinkedList<Integer> list = new LinkedList<>();
//        LinkedList<Integer> list1 = new LinkedList<>();
//        array.add(8);
//        array.add(7);
//        array.add(5);
//        
//        System.out.println("------------ ARRAY -----------");
//        list.addFirst(array);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            System.out.println(iter.next());
//        }
//        System.out.println("------------ ARRAY -----------");
//        array5.add(0,list.peekLastArray(2));
//        System.out.println(array5.size());
//        Iterator it = array5.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
//        System.out.println("------------ ARRAY -----------");
//        Iterator itera = list.iterator();
//        while (itera.hasNext()) {
//            System.out.println(itera.next());
//        }
//        System.out.println(list.size());
//----------------- PRUEBA 7 -----------------
//        Array array = new Array(3);
//        LinkedList<Integer> list = new LinkedList<>();
//        LinkedList<Integer> list1 = new LinkedList<>();
//        LinkedList<Integer> list2 = new LinkedList<>();
//        array.add(8);
//        array.add(7);
//        array.add(5);
//        
//        System.out.println("------------ ARRAY -----------");
//        Iterator i = array.iterator();
//        while (i.hasNext()) {
//            System.out.println(i.next());
//        }
//
//        list.addFirst(array);
//        System.out.println("------------ LIST -----------");
//        Iterator it = list.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
//        list1 = (LinkedList<Integer>) list.pollLastCollection(2);
//        System.out.println("------------ POLLLASTCOLLECTION -----------");
//        Iterator itera = list1.iterator();
//        while (itera.hasNext()) {
//            System.out.println(itera.next());
//        }
//        System.out.println("------------ CABEZA -----------");
//        System.out.println(list.peek());
//        System.out.println("------------ COLA -----------");
//        System.out.println(list.peekLast());
//        list2 = (LinkedList<Integer>) list.pollCollection(2);
//        System.out.println("------------ POLLLASTCOLLECTION -----------");
//        Iterator iterator = list2.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//        System.out.println("----------  LIST DESPUES -------------");
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            System.out.println(iter.next());
//----------------- PRUEBA 6 -----------------
//        LinkedList<Integer> list = new LinkedList<>();
//        Integer[] array = new Integer[3];
//        Object[] array1;
//        for (int i = 0; i < array.length; i++) {
//            array[i] = Integer.valueOf(JOptionPane.showInputDialog("ingrese un numero: "));
//        }
//        list.addFirst(array);
//        System.out.println(list.size());
//        System.out.println("-----------------------");
//        array1 = list.pollLastArray(2);
//        System.out.println("-----------------------");
//        for(int i = 0; i < array1.length; i++){
//            System.out.println(array1[i]);
//        }
//        System.out.println("-----------------------");
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            System.out.println(iter.next());
//        }
//        System.out.println("-----------------------");
//        System.out.println(list.peek());
//        System.out.println(list.peekLast());
//------------------ PRUEBA 5 -----------------
//        LinkedList<Integer> list = new LinkedList<>();
//        Integer[] array = new Integer[3];
//        Object[] array1;
//        for (int i = 0; i < array.length; i++) {
//            array[i] = Integer.valueOf(JOptionPane.showInputDialog("ingrese un numero: "));
//        }
//        list.addFirst(array);
//        array1 = list.peekArray(2);
//        System.out.println("-----------------------");
//        for(int i = 0; i < array1.length; i++){
//            System.out.println(array1[i]);
//        }
////        Iterator iter = list.iterator();
////        while (iter.hasNext()) {
////            System.out.println(iter.next());
////        }
//        System.out.println("-----------------------");
//        System.out.println(list.peek());
//        System.out.println(list.peekLast());
//------------------ PRUEBA 4 -----------------
//        LinkedList<Integer> list = new LinkedList<>();
//        Integer[] array = new Integer[3];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = Integer.valueOf(JOptionPane.showInputDialog("ingrese un numero: "));
//        }
//        list.addFirst(array);
//        list.pollArray(2);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            System.out.println(iter.next());
//        }
//        System.out.println("-----------------------");
//        System.out.println(list.peek());
//        System.out.println(list.size());
//        while (iter.hasNext()) {
//            System.out.println(iter.next());
//        }
//        System.out.println("-----------------------");
//        list.poll();
////        System.out.println(list.size());
//      Iterator itera = list.iterator();
//        while (itera.hasNext()) {
//            System.out.println(iter.next());
//        }
//        System.out.println("-----------------------");
//       System.out.println(list.peek());
//       System.out.println("-----------------------");
//       list.pollLast();
//       System.out.println("-----------------------");
//       Iterator itera = list.iterator();
//        while (itera.hasNext()) {
//            System.out.println(iter.next());
//        }
//        System.out.println("-----------------------");
//        System.out.println(list.peek());
//        System.out.println(list.peekLast());
//------------------ PRUEBA 3 -----------------
//        LinkedList<Integer> list = new LinkedList<>();
//        Integer[] array = new Integer[2];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = Integer.valueOf(JOptionPane.showInputDialog("ingrese un numero: "));
//        }
//        list.addFirst(array);
//
//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            System.out.println(iter.next());
//        }

//------------------ PRUEBA 2 -----------------
//        LinkedList<Integer> list = new LinkedList<>();
//        list.addFirst(5);
//        list.addFirst(7);
//        Iterator iter = list.iterator();
//        while (iter.hasNext()){
//            System.out.println(iter.next());
//      }
// ----------------- PRUEBA 1 ------------------
//        LinkedList<Integer> list = new LinkedList<>();
//        Integer[] array = new Integer[2];
//        for(int i=0 ; i < 2; i++){
//            array[i] = 2;
//            System.out.println(array[i]);
//        }
//        list.add(array);
////        System.out.println(list.size());
////        
////        if(list.size() == array.length){
////            System.out.println("bien");
////        }
//        Iterator iter = list.iterator();
//        if(iter.hasNext() == true){
//            System.out.println("si sirve");
//        }
//        while (iter.hasNext()){
//            System.out.println(iter.next());
//        }
