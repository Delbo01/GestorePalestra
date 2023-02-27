package GestoreLogin;

import IstruttoreCalendario.Istruttore;

public class CredenzialiIstruttore {
    private String username;
    private String password;
    private Istruttore istruttore;

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
