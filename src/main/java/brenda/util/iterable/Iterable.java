package brenda.util.iterable;

import java.util.function.Function;

import brenda.util.iterator.Iterator;

public interface Iterable<E> {
  

  public void forEach(Function<E, Void> action);

  public Iterator<E> iterator();
}
