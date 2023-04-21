package ejemplo1;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void obtenerPromedio(Stream<Integer> ids){
        LocalTime inicio = LocalTime.now();
        double promedio = ids
                .mapToDouble(id -> new SistemaMedicion().leer(id))
                .average()
                .orElse(0);
        Duration tiempo = Duration.between(inicio, LocalTime.now());
        System.out.println(Math.round(promedio) + " en " + tiempo.toMillis()+ "ms");
    }

    public static void main(String[] args) {
        List<Integer> ids = IntStream.range(1, 1000)
                .boxed()
                .collect(Collectors.toList());

        obtenerPromedio(ids.stream());//SECUENCIAL
        obtenerPromedio(ids.parallelStream());
    }


}
