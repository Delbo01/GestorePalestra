import java.util.ArrayList;
import java.util.List;

public class ListaCredenziali {
    private List<Credenziali> elencoCredenziali=new ArrayList<>();

    public void addCredenziali(String username, String password, int clinete){
        Credenziali c= new Credenziali(username,password,clinete);
        elencoCredenziali.add(c);
    }

    public void removeCredenziali(String username, String password) {
        for (int i = 0; i < elencoCredenziali.size(); i++) {
            if (elencoCredenziali.get(i).getUsername() == username & elencoCredenziali.get(i).getPassword() == password)
                elencoCredenziali.remove(i);
        }
    }

    public boolean chechkCredenziali(String username, String password){
        for (int i=0; i<elencoCredenziali.size();i++){
            if (elencoCredenziali.get(i).getUsername()==username & elencoCredenziali.get(i).getPassword()==password)
                return true;
        }
        return false;
    }

    public Integer getCliente(String username, String password){
        for (int i=0; i<elencoCredenziali.size();i++) {
            if (elencoCredenziali.get(i).getUsername()==username & elencoCredenziali.get(i).getPassword()==password)
                return elencoCredenziali.get(i).getCliente();
        }
        return null;
    }
}
