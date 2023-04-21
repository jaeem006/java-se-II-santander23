package Ejemplo1;

import generator.RxJavaObservableGenerator;
import io.reactivex.Single;

public class Ejemplo1 {
    static Single<Integer> sumarSingle(){
        return RxJavaObservableGenerator
                .observableStream()
                .reduce(0,(a,b) -> a+b);
    }

    static Integer sumar(){
        return RxJavaObservableGenerator
                .observableStream()
                .reduce(0, (a,b) -> a+b)
                .blockingGet();
    }

    public static void main(String[] args) {
        Single<Integer> si = Ejemplo1.sumarSingle();
        Integer i = Ejemplo1.sumar();

        System.out.println("Single: "+ si.blockingGet());
        System.out.println("Integer: "+ i);
    }
}
