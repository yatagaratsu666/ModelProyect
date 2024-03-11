
package io;

import brenda.array.Array;
import java.io.Serializable;

public class AbstractSerializableArray<E extends Serializable> extends Array<E> implements Serializable {
    
    protected static final long serialVersionUID = 1L;

    protected AbstractSerializableArray(int amtData) {
        super(amtData);
    }  
}
