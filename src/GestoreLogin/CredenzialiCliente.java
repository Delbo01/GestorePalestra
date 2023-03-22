package GestoreLogin;

import Cliente.Cliente;

public class CredenzialiCliente {
    private final String username;
    private final String password;
    private final Cliente cliente;

    public CredenzialiCliente(String username, String password, Cliente c) {
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

    public Cliente getCliente() {
        return cliente;
    }
}
