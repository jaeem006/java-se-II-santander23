package ejemplo2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EchoClassTest {

    @Test
    void echoString(){
        String input = "Hola Mundo";
        assertEquals(input, EchoClass.echo(input));
    }

    @Test
    void echoNumber(){
        Integer input = 1729;
        assertEquals(input, EchoClass.echo(input));
    }

    private class Clase{
        private String name;
        Clase(String name){
            this.name=name;
        }
    }

    @Test
    void echoClase(){
        Clase input = new Clase("Javier");
        assertEquals(input, EchoClass.echo(input));
    }

}