package refactoring_guru.chain_of_responsibility.example.middleware;

/*Esse código define a classe RoleCheckMiddleware, que estende Middleware. O método 
check verifica se o email é “admin@example.com”. Se for, imprime “Hello, admin!” 
e retorna true. Caso contrário, imprime “Hello, user!” e chama checkNext para passar 
a verificação para o próximo objeto na cadeia*/

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