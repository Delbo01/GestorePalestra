package GestoreLogin;

import Istruttore.Istruttore;

public class CredenzialiIstruttore {
    private final String username;
    private final String password;
    private final Istruttore istruttore;

    public CredenzialiIstruttore(String username, String password, Istruttore istruttore) {
        this.password=password;
        this.istruttore=istruttore;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Istruttore getIstruttore() {
        return istruttore;
    }
}
