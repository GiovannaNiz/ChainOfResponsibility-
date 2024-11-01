package refactoring_guru.chain_of_responsibility.example.middleware;

/*O código define a classe UserExistsMiddleware, que estende Middleware e verifica se
um usuário existe no servidor. O método check confere se o email está registrado e se a 
senha é válida. Se o email não estiver registrado, imprime "This email is 
not registered!" e retorna false. Se a senha estiver incorreta, imprime 
"Wrong password!" e também retorna false. Se ambos estiverem corretos, a verificação 
prossegue para o próximo objeto na cadeia.*/

import refactoring_guru.chain_of_responsibility.example.server.Server;

public class UserExistsMiddleware extends Middleware {
    private Server server;

    public UserExistsMiddleware(Server server) {
        this.server = server;
    }

    public boolean check(String email, String password) {
        if (!server.hasEmail(email)) {
            System.out.println("This email is not registered!");
            return false;
        }
        if (!server.isValidPassword(email, password)) {
            System.out.println("Wrong password!");
            return false;
        }
        return checkNext(email, password);
    }
}
