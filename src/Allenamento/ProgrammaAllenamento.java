package Allenamento;

import java.util.ArrayList;

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
    public void visualizzaEsercizio(int pos){
        System.out.print(esercizi.get(pos).getNome()+" : ");
        System.out.print(esercizi.get(pos).getSerie()+"X"+esercizi.get(pos).getReps()+" con ");
        System.out.print(esercizi.get(pos).getTempoRecupero()+" secondi di recupero ");
        if (esercizi.get(pos).getNote()!=null){
            System.out.print("note: ");
            System.out.println(esercizi.get(pos).getNote());
        }else System.out.println();
    }

    public void visualizzaProgramma(){
        for (int i=0;i<nEsercizi;i++){
            visualizzaEsercizio(i);
        }
        System.out.println(" durata programma "+durata);
    }

    public ArrayList<Esercizio> getEsercizi() {
        return esercizi;
    }

    public int getnEsercizi() {
        return nEsercizi;
    }

}
