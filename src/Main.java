public class Main {
        public static void main(String[] args) {
            ListaCredenzialiCliente listaCredenziali = new ListaCredenzialiCliente();
            ListaCredenzialiIstruttore listaCredenzialiIstruttore= new ListaCredenzialiIstruttore();

            GestoreLogin gestoreLogin= new GestoreLogin(listaCredenziali, listaCredenzialiIstruttore);

            gestoreLogin.registraCliente("marco","Abcjh4_20",1);
            gestoreLogin.registraCliente("gianni","Mafg_00",2);
            gestoreLogin.registraCliente("matteo","Qwerty",3);
            gestoreLogin.registraIstruttore("gianni", "hjgyucajcaye", 4);
            gestoreLogin.registraIstruttore("franco", "xzxzxz", 5);
            gestoreLogin.registraIstruttore("vvvv", "a", 6);



            Integer c=gestoreLogin.loginCliente("marco","Abcjh4_20");
            Integer c2=gestoreLogin.loginCliente("matteo","Qwerty");
            Integer c3=gestoreLogin.loginCliente("leo","Qwerty");
            Integer i= gestoreLogin.loginIstruttore("vvvv","a");
            Integer i2= gestoreLogin.loginIstruttore("vvvv","qwertyuugugiop");

        }

}