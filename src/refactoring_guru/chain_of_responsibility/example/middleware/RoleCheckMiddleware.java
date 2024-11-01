package refactoring_guru.chain_of_responsibility.example.middleware;

/*Esse c�digo define a classe RoleCheckMiddleware, que estende Middleware. O m�todo 
check verifica se o email � �admin@example.com�. Se for, imprime �Hello, admin!� 
e retorna true. Caso contr�rio, imprime �Hello, user!� e chama checkNext para passar 
a verifica��o para o pr�ximo objeto na cadeia*/

public class RoleCheckMiddleware extends Middleware {
    public boolean check(String email, String password) {
        if (email.equals("admin@example.com")) {
            System.out.println("Hello, admin!");
            return true;
        }
        System.out.println("Hello, user!");
        return checkNext(email, password);
    }
}