package Abbonamento;



import java.util.ArrayList;
import java.util.Objects;


public class GestoreAbbonamenti {
    private ArrayList<Abbonamento> abbonamenti= new ArrayList<>();

    public void addAbbonamenti(int durata, String nome, int prezzo,String dataInizio){
        Abbonamento abbonamento= new Abbonamento(durata,nome,prezzo,dataInizio,false);
        abbonamenti.add(abbonamento);
    }
    public Boolean rimuoviAbbonamenti(int durata, String nome, int prezzo){
        for (int i=0;i<abbonamenti.size();i++){
            if (abbonamenti.get(i).getDurata()==durata && Objects.equals(abbonamenti.get(i).getNome(), nome) && abbonamenti.get(i).getPrezzo()==prezzo){
                abbonamenti.remove(i);
                return true;
            }
        }
        return false;
    }
    public void vediAbbonamenti(){
        int i=1;
        for (Abbonamento a:abbonamenti){
            System.out.println("Abbonamento n:"+i);
            a.visualizzaAbbonamento();
            i++;
        }
    }
    public Abbonamento getAbbonamento(int index, boolean corsi){
        if(index<0 || index>=abbonamenti.size())
            return null;
        Abbonamento abbonamento= new Abbonamento(abbonamenti.get(index));
        abbonamento.setCorsi(corsi);
        return abbonamento;
    }

}
