package refactoring_guru.chain_of_responsibility.example.middleware;

/*O c�digo define a classe UserExistsMiddleware, que estende Middleware e verifica se
um usu�rio existe no servidor. O m�todo check confere se o email est� registrado e se a 
senha � v�lida. Se o email n�o estiver registrado, imprime "This email is 
not registered!" e retorna false. Se a senha estiver incorreta, imprime 
"Wrong password!" e tamb�m retorna false. Se ambos estiverem corretos, a verifica��o 
prossegue para o pr�ximo objeto na cadeia.*/

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
