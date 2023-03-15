package Allenamento;

import java.util.ArrayList;
import java.util.Scanner;

public class ProgrammaAllenamento {
    private ArrayList<Esercizio> esercizi= new ArrayList<>();
    private int nEsercizi=0;
    private String durata;

    public ProgrammaAllenamento(String durata) {
        this.durata = durata;
    }

    public void addEsercizio(Esercizio e){
        esercizi.add(e);
        nEsercizi++;
    }

    public void removeEsercizio(Esercizio e){
        esercizi.remove(e);
        nEsercizi--;
    }
    public void visualizzaEsercizio(int pos, Scanner sc){
        System.out.print(esercizi.get(pos).getNome()+" : ");
        System.out.print(esercizi.get(pos).getSerie()+"X"+esercizi.get(pos).getReps()+" con ");
        System.out.print(esercizi.get(pos).getTempoRecupero()+" secondi di recupero");
        System.out.print(" con "+esercizi.get(pos).getCarico()+"kg ");
        if (esercizi.get(pos).getNote()!=null){
            System.out.print("note: ");
            System.out.println(esercizi.get(pos).getNote());
        }else System.out.println();
        System.out.println("Vuoi modificare il carico dell'esercizio? (si/no)");
        String risposta=sc.nextLine();
        if (risposta=="si"){
            System.out.println("Inserisci il nuovo carico");
            int carico=sc.nextInt();
            sc.nextLine();
            esercizi.get(pos).setCarico(carico);
        }else if (risposta=="no"){
            System.out.println("ok");
        }else System.out.println("risposta non valida");
    }

    public void visualizzaProgramma(Scanner sc){
        for (int i=0;i<nEsercizi;i++){
            visualizzaEsercizio(i,sc);
        }
        System.out.println(" durata programma "+durata);
    }

    public ArrayList<Esercizio> getEsercizi() {
        return esercizi;
    }

    public int getnEsercizi() {
        return nEsercizi;
    }

     Esercizio getEsercizio(int pos){
        return esercizi.get(pos);
    }

}
