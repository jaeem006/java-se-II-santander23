import java.util.concurrent.TimeUnit;

public class MiRunnable implements Runnable {

    private String parametro, nombre;

    public MiRunnable(String nombre){
        this.nombre = nombre;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    @Override
    public void run() {
        while (!"terminar".equals(parametro)){
            mostrarInformacion();
            pausarUnSegundo();
        }

        mostrarInformacion();
    }

    public static void pausarUnSegundo() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void mostrarInformacion() {
        System.out.println("Hilo: " + nombre + "\t| Parametro: " + parametro);
    }

    public static void main(String[] args) {
        MiRunnable run1 = new MiRunnable("UNO");
        MiRunnable run2 = new MiRunnable("DOS");

        Thread t1 = new Thread(run1);
        t1.start();

        Thread t2 = new Thread(run2);
        t2.setDaemon(true);
        t2.start();

        MiRunnable.pausarUnSegundo();

        run2.setParametro("terminar");
    }
}


