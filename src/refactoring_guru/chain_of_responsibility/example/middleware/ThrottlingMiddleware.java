package refactoring_guru.chain_of_responsibility.example.middleware;

/*O c�digo define a classe ThrottlingMiddleware, que estende Middleware para limitar 
o n�mero de requisi��es por minuto. O m�todo check verifica se um minuto se passou 
desde a �ltima contagem, reinicia essa contagem se necess�rio, incrementa o contador 
de requisi��es e, se o limite for excedido, imprime "Request limit exceeded!" e 
interrompe a execu��o. Caso contr�rio, permite que a verifica��o prossiga para o 
pr�ximo objeto na cadeia.*/

public class ThrottlingMiddleware extends Middleware{
	private int requestPerMinute;
    private int request;
    private long currentTime;

    public ThrottlingMiddleware(int requestPerMinute) {
        this.requestPerMinute = requestPerMinute;
        this.currentTime = System.currentTimeMillis();
    }
    public boolean check(String email, String password) {
        if (System.currentTimeMillis() > currentTime + 60_000) {
            request = 0;
            currentTime = System.currentTimeMillis();
        }

        request++;
        
        if (request > requestPerMinute) {
            System.out.println("Request limit exceeded!");
            Thread.currentThread().stop();
        }
        return checkNext(email, password);
    }
}
    
