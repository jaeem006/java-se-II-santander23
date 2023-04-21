import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class Ejemplo3Test {
    @Test
    void negativos(){
        Ejemplo3 ej = new Ejemplo3();

        List<Integer> conj = Arrays.asList(1,4,-5,8,3,-2,1);

        Integer expected = -24;

        assertThat(ej.manipular(conj, n -> n < 0 ? n : -n)).isEqualTo(expected);
    }

    @Test
    void suma(){
        Ejemplo3 ej = new Ejemplo3();

        List<Integer> conj = Arrays.asList(1,2,3,4,5);

        Integer expected = 15;

        assertThat(ej.manipular(conj, n -> n)).isEqualTo(expected);
    }

}