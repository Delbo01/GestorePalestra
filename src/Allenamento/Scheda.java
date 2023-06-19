package Allenamento;

import java.util.ArrayList;
import java.util.Scanner;

public class Scheda {
    private final ArrayList<ProgrammaAllenamento> programma=new ArrayList<>();
    private int nProg=0;
    private final String nomeIstruttore;
    private final String obbiettivo;

    public Scheda(String istruttore, String obbiettivo) {
        this.obbiettivo = obbiettivo;
        this.nomeIstruttore = istruttore;
    }

    public void addProgramma(ProgrammaAllenamento p){
        programma.add(p);
        nProg++;
    }
    public void removeProgramma(ProgrammaAllenamento p){
        programma.remove(p);
        nProg--;
    }
    public void visualizzaScheda(Scanner sc){
        System.out.println("Obbiettivo scheda: "+obbiettivo);
        System.out.println("numero di programmi della scheda: "+nProg);
        for (int i=0;i<nProg; i++){
            System.out.println("Programma "+(i+1)+":");
            programma.get(i).visualizzaProgramma(sc,i+1);
        }
    }
    public int getnProg() {
        return nProg;
    }


}
