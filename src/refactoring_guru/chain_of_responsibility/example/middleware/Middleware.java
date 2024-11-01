package refactoring_guru.chain_of_responsibility.example.middleware;

/*Esse código implementa o padrão Chain of Responsibility, onde a classe Middleware 
//define a estrutura básica para manipuladores na cadeia. O método link cria a cadeia 
//de objetos Middleware, e os métodos check e checkNext permitem realizar verificações 
//específicas e passar a solicitação para o próximo objeto na cadeia, respectivamente. 
Em resumo, ele facilita a criação de uma sequência flexível de verificações encadeadas.
*/

public abstract class Middleware {
    private Middleware next;

    public static Middleware link(Middleware first, Middleware... chain) {
        Middleware head = first;
        for (Middleware nextInChain: chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public abstract boolean check(String email, String password);

    protected boolean checkNext(String email, String password) {
        if (next == null) {
            return true;
        }
        return next.check(email, password);
    }
}
