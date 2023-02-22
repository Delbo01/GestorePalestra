public class GestoreLogin {
    private ListaCredenziali listaCredenziali;

    public GestoreLogin(ListaCredenziali listaCredenziali) {
        this.listaCredenziali = listaCredenziali;
    }

    public Integer login(String username, String password){
        if(listaCredenziali.chechkCredenziali(username, password)==true){
            int cliente=listaCredenziali.getCliente(username, password);
            System.out.println("credenziali giuste"+" "+cliente);
            return cliente;
        }
        else System.out.println("credenziali non trovate");
        return null;
    }

    public void registra(String username, String password, int cliente){
        listaCredenziali.addCredenziali(username, password, cliente);
    }

    public void remove(String username, String password){
        listaCredenziali.removeCredenziali(username,password);
    }
}

