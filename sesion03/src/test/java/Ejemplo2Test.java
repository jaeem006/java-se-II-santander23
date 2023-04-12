import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class Ejemplo2Test {

    private final List<Integer> CONJUNTO = Arrays.asList(1,2,3,4,5);

    @Test
    void multiplica5 (){
        Ejemplo2 ej = new Ejemplo2();

        Function<Integer, Integer> foo = n -> n*5;

        List<Integer> res = ej.transformar(CONJUNTO,foo);

        assertThat(res).containsExactly(5,10,15,20,25);
    }

    @Test
    void suma1 (){
        Ejemplo2 ej = new Ejemplo2();

        List<Integer> res = ej.transformar(CONJUNTO,n -> n + 1);

        assertThat(res).containsExactly(2,3,4,5,6);
    }

}