public class Main {
        public static void main(String[] args) {
            ListaCredenziali listaCredenziali = new ListaCredenziali();

            GestoreLogin gestoreLogin= new GestoreLogin(listaCredenziali);

            gestoreLogin.registra("marco","Abcjh4_20",1);
            gestoreLogin.registra("gianni","Mafg_00",2);
            gestoreLogin.registra("matteo","Qwerty",3);

            Integer c=gestoreLogin.login("marco","Abcjh4_20");
            Integer c2=gestoreLogin.login("matteo","Qwerty");
            Integer c3=gestoreLogin.login("leo","Qwerty");
        }

}