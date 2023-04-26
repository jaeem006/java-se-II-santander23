package ejemplo1;

public class Holder<E> {

    private E valor;

    void hold(E valor){
        this.valor = valor;
    }

    public E release(){
        return valor;
    }
}
