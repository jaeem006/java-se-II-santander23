package Ejemplo3;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        EventLoopSimple eventLoop = new EventLoopSimple(evento ->{
            if (evento instanceof String){
                System.out.println("String:" + evento);
            }
            else if(evento instanceof Number){
                System.out.println("Número: "+ evento);
            }
        });

        eventLoop.iniciar();
        eventLoop.registraEvento("Hola Mundo");

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e){}

        eventLoop.registraEvento(5);
        eventLoop.registraEvento("Adios");
        eventLoop.registraEvento(1000);

        eventLoop.detener();
    }
}
