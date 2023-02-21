public class Credenziali {
    private String username;
    private String password;
    private int cliente;

    public Credenziali(String username, String password, int c) {
        this.username = username;
        this.password=password;
        cliente=c;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getCliente() {
        return cliente;
    }
}
