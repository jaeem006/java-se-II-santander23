public class Ejemplo1 {

    private final StringToInteger parser = s -> Integer.parseInt(s);

    Integer sumar(String a, String b){
        return parser.convertir(a) + parser.convertir(b);
    }
}
