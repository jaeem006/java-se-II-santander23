import java.util.concurrent.TimeUnit;

public class MiHilo extends Thread {

    String parametro;

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public MiHilo(String parametro){
        this.parametro = parametro;
    }

    @Override
    public void run(){
        while (!"terminar".equals(parametro)){
            mostrarInformacion();
            pausarUnSegundo();
        }

        mostrarInformacion();
    }

    private void mostrarInformacion(){
        String tipoHilo = isDaemon() ? "daemon" : "usuario";
        System.out.println(tipoHilo + "\t| Nombre: " + getName() + "\t| ID: " + getId() + "\t| Parametro: " + parametro);
    }

    public static void pausarUnSegundo() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MiHilo hilo1 = new MiHilo("UNO");
        hilo1.start();

        MiHilo hilo2 = new MiHilo("DOS");
        hilo2.setDaemon(true);
        hilo2.start();

        MiHilo.pausarUnSegundo();
        hilo1.setParametro("terminar");
        System.out.println("**FINAL**");
    }
}
