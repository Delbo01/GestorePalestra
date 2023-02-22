package GestoreLogin;

import Cliente.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListaCredenzialiCliente {
    private List<CredenzialiCliente> elencoCredenziali=new ArrayList<>();

    public void addCredenziali(String username, String password, Cliente clinete){
        CredenzialiCliente c= new CredenzialiCliente(username,password,clinete);
        elencoCredenziali.add(c);
    }

    public void removeCredenziali(String username, String password) {
        for (int i = 0; i < elencoCredenziali.size(); i++) {
            if (Objects.equals(elencoCredenziali.get(i).getUsername(), username) & Objects.equals(elencoCredenziali.get(i).getPassword(), password))
                elencoCredenziali.remove(i);
        }
    }

    public boolean checkCredenziali(String username, String password){
        for (CredenzialiCliente credenziali : elencoCredenziali) {
            if (Objects.equals(credenziali.getUsername(), username) & Objects.equals(credenziali.getPassword(), password))
                return true;
        }
        return false;
    }

    public Cliente getCliente(String username, String password){
        for (CredenzialiCliente credenziali : elencoCredenziali) {
            if (Objects.equals(credenziali.getUsername(), username) & Objects.equals(credenziali.getPassword(), password))
                return credenziali.getCliente();
        }
        return null;
    }
}
