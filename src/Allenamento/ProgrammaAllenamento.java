package Allenamento;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ProgrammaAllenamento {
    private final ArrayList<Esercizio> esercizi= new ArrayList<>();
    private int nEsercizi=0;
    private final  String durata;

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
    public void visualizzaEsercizio(int id,int p,int pos, Scanner sc){
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
        if (Objects.equals(risposta, "si")){
            System.out.println("Inserisci il nuovo carico");
            int carico=sc.nextInt();
            sc.nextLine();
            esercizi.get(pos).updateCarico(carico,p,id);
        }else if (Objects.equals(risposta, "no")){
            System.out.println("ok");
        }else System.out.println("risposta non valida");
        System.out.println("Vuoi far partite il timer? (si/no)");
        String risposta1=sc.nextLine();
        if (Objects.equals(risposta1, "si")){
            try {
                esercizi.get(pos).startTimer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else if (Objects.equals(risposta1, "no")) {
            System.out.println("ok");
        }else System.out.println("risposta non valida");
    }

    public void visualizzaProgramma(Scanner sc,int id){
        System.out.println("Programma di allenamento con "+getnEsercizi());
        for (int i=0;i<nEsercizi;i++){
            visualizzaEsercizio(id,i+1,i,sc);
        }
        System.out.println(" durata programma "+durata);
    }

    public int getnEsercizi() {
        return nEsercizi;
    }
     public Esercizio getEsercizio(int pos){
        return esercizi.get(pos);
    }

}
