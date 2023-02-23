package Allenamento;

public class Timer implements Runnable {
    private int durata;

    public Timer(int durata) {
        this.durata = durata;
    }

    @Override
    public void run() {
        try{
            System.out.println("Timer avviato");
            for (int i=durata; i>0; i--){
                System.out.println(i);
                Thread.sleep(1000);
            }
            System.out.println("Timer finito");
        }catch (InterruptedException e){
            System.out.println("Timer finito");
        }
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public int getDurata() {
        return durata;
    }
}
