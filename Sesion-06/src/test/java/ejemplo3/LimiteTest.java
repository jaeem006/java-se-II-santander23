package ejemplo3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LimiteTest {

    @Test
    void integer(){
        Limite<Integer> lim = new Limite<>();
        assertTrue(lim.esMayorQue(7,2));
    }

    @Test
    void doble(){
        Limite<Double> lim = new Limite<>();
        assertTrue(lim.esMayorQue(7.67,2.23));
    }

    @Test
    void number(){
        Limite<Number> lim = new Limite<>();
        assertTrue(lim.esMayorQue(30,5.6));
    }

}