package GestoreLogin;

import Istruttore.Istruttore;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListaCredenzialiIstruttore {
    private List<CredenzialiIstruttore> elencoCredenziali=new ArrayList<>();

    public void addCredenziali(String username, String password, Istruttore i){
        CredenzialiIstruttore c= new CredenzialiIstruttore(username,password,i);
        elencoCredenziali.add(c);
    }

    public void removeCredenziali(String username, String password) {
        for (int i = 0; i < elencoCredenziali.size(); i++) {
            if (Objects.equals(elencoCredenziali.get(i).getUsername(), username) & Objects.equals(elencoCredenziali.get(i).getPassword(), password))
                elencoCredenziali.remove(i);
        }
    }

    public boolean checkCredenziali(String username, String password){
        for (CredenzialiIstruttore credenziali : elencoCredenziali) {
            if (Objects.equals(credenziali.getUsername(), username) & Objects.equals(credenziali.getPassword(), password))
                return true;
        }
        return false;
    }

    public Istruttore getIstruttore(String username, String password){
        for (CredenzialiIstruttore credenziali : elencoCredenziali) {
            if (Objects.equals(credenziali.getUsername(), username) & Objects.equals(credenziali.getPassword(), password))
                return credenziali.getIstruttore();
        }
        return null;
    }
}
