package Ejemplo1;

import generator.RxJavaObservableGenerator;
import io.reactivex.Single;

import java.util.Collections;
import java.util.List;

public class Ejemplo1 {
    static Single<List<Integer>> sumarSingle(){
        List<Integer> mt = Collections.emptyList();
        return RxJavaObservableGenerator
                .observableStream()
                .reduce(mt ,(a, b) -> {a.add(b);return a;});
    }

    static Integer sumar(){
        return RxJavaObservableGenerator
                .observableStream()
                .reduce(0, (a,b) -> a+b)
                .blockingGet();
    }

    public static void main(String[] args) {
        Single<List<Integer>> si = Ejemplo1.sumarSingle();
        Integer i = Ejemplo1.sumar();

        System.out.println("Single: "+ si);
        System.out.println("Integer: "+ i);
    }
}
