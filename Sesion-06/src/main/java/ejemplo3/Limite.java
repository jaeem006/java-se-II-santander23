package ejemplo3;

public class Limite<E extends Number> {

    public boolean esMayorQue(E n, E m){
        return n.doubleValue() > m.doubleValue();
    }

}
