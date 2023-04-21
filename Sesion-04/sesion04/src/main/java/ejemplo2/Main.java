package ejemplo2;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    static void obtenerPromedio(Stream<Integer> ids){
        LocalTime inicio = LocalTime.now(); //registramos el tiempo de inicio
        double promedio = ids
                .mapToDouble(id -> new SistemaMedicion().leer(id)) //pasamos el stream de números a nuestro sensor
                .average()      //calcula el promedio de los valores
                .orElse(0); // retorna 0 si no pudo obtener los valores
        Duration tiempo = Duration.between(inicio, LocalTime.now());    //registramos el tiempo de fin
        System.out.println((Math.round(promedio * 100.) / 100.) + " en " + tiempo.toMillis() + "ms"); //imprimimos el resultado;
    }

    public static void main(String[] args) {
        List<Integer> ids = IntStream.range(1,101)
                .mapToObj(i -> i)
                .collect(Collectors.toList());

        obtenerPromedio(ids.stream());//SECUENCIAL

        //PARALELO
        List<CompletableFuture<Double>> futuros = ids.stream()
                .map(id -> CompletableFuture.supplyAsync(() -> new SistemaMedicion().leer(id)))
                .collect(Collectors.toList());

        LocalTime inicio = LocalTime.now();
        double promedio = futuros.stream()
                .mapToDouble(cf -> cf.join())
                .average()
                .orElse(0);
        Duration tiempo = Duration.between(inicio, LocalTime.now());
        System.out.println(Math.round(promedio) + " en " + tiempo.toMillis() + "ms");

    }
}
