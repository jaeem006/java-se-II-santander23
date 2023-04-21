import java.util.List;
import java.util.function.IntUnaryOperator;

public class Ejemplo3 {

    Integer manipular(List<Integer> conjunto, IntUnaryOperator trans){
        return conjunto.stream().mapToInt(s -> s).map(trans).sum();
    }
}
