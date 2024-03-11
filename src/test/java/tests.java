
import brenda.array.Array;
import brenda.circularlist.LinkedList;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class tests {
    @Test
    void containsArray1(){
        LinkedList<Integer> current = new LinkedList<>();
        current.add(5);
        current.add(10);
        current.add(15);
        Object[] expected = {15};
        Object[] recieved = current.pollLastArray(1);
        assertEquals(expected[0], recieved[0]);
        assertEquals(2, current.size());
    }
}
