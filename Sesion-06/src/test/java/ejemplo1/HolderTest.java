package ejemplo1;

import ejemplo1.Holder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HolderTest {

    @Test
    void entero(){
        Integer entero = 1729;
        Holder<Integer> holder = new Holder<>();
        holder.hold(entero);

        assertEquals(entero, (Integer) holder.release());
    }

}