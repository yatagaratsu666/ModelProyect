
package io;

import java.io.Serializable;

public class Array<E extends Serializable> extends AbstractSerializableArray<E> {
    
    public Array(int amtData) {
        super(amtData);
    }
    
}
