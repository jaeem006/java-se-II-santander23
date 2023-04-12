import java.sql.Time;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MiRunnablePool implements Runnable{

    private String nombre;

    public MiRunnablePool(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run (){
        try {
            while (true){
                System.out.println(nombre + " en ejecución ...");
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println(nombre + " fue interrumpido ...");
        }
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();

        String [] nombres = {"UNO","DOS","TRES","CUATRO"};
        for (String nombre : nombres){
            pool.execute(new MiRunnablePool(nombre));
        }

        pool.shutdown();

        try{
            long tiempoLimiteMs = 100;
            boolean terminaron = pool.awaitTermination(tiempoLimiteMs, TimeUnit.MILLISECONDS);

            if(!terminaron){
                List<Runnable> pendientes = pool.shutdownNow();
                terminaron = pool.awaitTermination(tiempoLimiteMs,TimeUnit.MILLISECONDS);

                if(!terminaron){
                    System.out.println("No han terminado");
                }
                System.out.println("Si terminado");

            }
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
