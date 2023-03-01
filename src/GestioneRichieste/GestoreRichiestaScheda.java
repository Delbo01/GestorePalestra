package GestioneRichieste;

import java.util.ArrayList;

public class GestoreRichiestaScheda {
    private ArrayList<Richiesta> richieste= new ArrayList<>();

    public Richiesta ottieniRichiesta(){
        if (richieste.size()>0)
            return richieste.remove(0);
        return null;
    }

    public void addRichiesta(Richiesta richiesta){
        richieste.add(richiesta);
    }
}
