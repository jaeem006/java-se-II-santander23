package Ejemplo2;

import Ejemplo1.Ejemplo1;
import generator.ReactorFluxGenerator;
import reactor.core.publisher.Mono;

public class Ejemplo2 {

    static Mono<Integer> sumarMono(){
        return ReactorFluxGenerator
                .fluxStream()
                .reduce(0,(a,b) -> a+b);
    }

    static Integer sumar(){
        return ReactorFluxGenerator
                .fluxStream()
                .reduce(0,(a,b)->a+b)
                .block();
    }

    public static void main(String[] args) {
        Mono<Integer> mi = sumarMono();
        Integer i = sumar();

        System.out.println("MONO: "+ mi.block());
        System.out.println("INT: "+ i);
    }
}
