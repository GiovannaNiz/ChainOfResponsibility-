package refactoring_guru.chain_of_responsibility.example.server;

import refactoring_guru.chain_of_responsibility.example.middleware.Middleware;

import java.util.HashMap;
import java.util.Map;

/*O código define a classe Server, que gerencia usuários e autenticação. Ele armazena 
usuários em um mapa e usa Middleware para verificar credenciais. O método setMiddleware 
define a cadeia de responsabilidade, logIn autentica usuários e imprime uma mensagem de
sucesso, e register adiciona novos usuários. Os métodos hasEmail e isValidPassword 
verificam a existência de um email e a validade da senha, respectivamente.*/

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