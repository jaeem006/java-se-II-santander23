package ejemplo1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HolderTest {

    @Test
    void entero(){
        Integer entero = 1729;
        Holder<Integer> holder = new Holder<>();
        holder.hold(entero);

        assertEquals(entero, holder.release());
    }

    @Test
    void cadena(){
        String cadena = "hola";
        Holder<String> holder = new Holder<>();
        holder.hold(cadena);

        assertEquals(cadena,holder.release());
    }

    private class Clase {
        private String nombre;

        Clase(String nombre){
            this.nombre=nombre;
        }
    }

    @Test
    void clase(){
        Clase clase = new Clase("Javier");
        Holder<Clase> holder = new Holder<>();
        holder.hold(clase);

        assertEquals(clase, holder.release());
    }

}