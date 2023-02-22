package GestoreLogin;

public class CredenzialiIstruttore {
    private String username;
    private String password;
    private int istruttore;

    public CredenzialiIstruttore(String username, String password, int istruttore) {
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

    public int getIstruttore() {
        return istruttore;
    }
}
