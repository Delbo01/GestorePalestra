package Allenamento;

import java.util.ArrayList;
import java.util.Scanner;

public class Scheda {
    private final ArrayList<ProgrammaAllenamento> programma=new ArrayList<>();
    private int nProg=0;
    private final String istruttore;
    private final String obbiettivo;

    public Scheda(String istruttore, String obbiettivo) {
        this.obbiettivo = obbiettivo;
        this.istruttore=istruttore;
    }

    public void addProgramma(ProgrammaAllenamento p){
        programma.add(p);
        nProg++;
    }
    public void removeProgramma(ProgrammaAllenamento p){
        programma.remove(p);
        nProg--;
    }
    public void visualizzaProgramma(int pos, Scanner sc){
        programma.get(pos).visualizzaProgramma(sc);
    }
    public void visualizzaScheda(Scanner sc){
        System.out.println("Obbiettivo scheda: "+obbiettivo);
        System.out.println("numero di programmi della scheda: "+nProg);
        for (int i=0;i<nProg; i++){
            System.out.println("Programma "+(i+1)+":");
            programma.get(i).visualizzaProgramma(sc);
        }
    }
    public void setCarico(int prog,int es, float carico){
        programma.get(prog).getEsercizio(es).setCarico(carico);
    }

    public void startTimer(int prog, int es) throws InterruptedException{
        programma.get(prog).getEsercizio(es).startTimer();
    }
}
