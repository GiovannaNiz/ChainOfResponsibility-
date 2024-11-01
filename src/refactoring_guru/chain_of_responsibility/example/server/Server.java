package refactoring_guru.chain_of_responsibility.example.server;

import refactoring_guru.chain_of_responsibility.example.middleware.Middleware;

import java.util.HashMap;
import java.util.Map;

/*O c�digo define a classe Server, que gerencia usu�rios e autentica��o. Ele armazena 
usu�rios em um mapa e usa Middleware para verificar credenciais. O m�todo setMiddleware 
define a cadeia de responsabilidade, logIn autentica usu�rios e imprime uma mensagem de
sucesso, e register adiciona novos usu�rios. Os m�todos hasEmail e isValidPassword 
verificam a exist�ncia de um email e a validade da senha, respectivamente.*/

public class Server {
    private Map<String, String> users = new HashMap<>();
    private Middleware middleware;

    public void setMiddleware(Middleware middleware) {
        this.middleware = middleware;
    }

    public boolean logIn(String email, String password) {
        if (middleware.check(email, password)) {
            System.out.println("Authorization have been successful!");

            return true;
        }
        return false;
    }

    public void register(String email, String password) {
        users.put(email, password);
    }

    public boolean hasEmail(String email) {
        return users.containsKey(email);
    }

    public boolean isValidPassword(String email, String password) {
        return users.get(email).equals(password);
    }
}