package refactoring_guru.chain_of_responsibility.example.middleware;

/*Esse c�digo implementa o padr�o Chain of Responsibility, onde a classe Middleware 
//define a estrutura b�sica para manipuladores na cadeia. O m�todo link cria a cadeia 
//de objetos Middleware, e os m�todos check e checkNext permitem realizar verifica��es 
//espec�ficas e passar a solicita��o para o pr�ximo objeto na cadeia, respectivamente. 
Em resumo, ele facilita a cria��o de uma sequ�ncia flex�vel de verifica��es encadeadas.
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
