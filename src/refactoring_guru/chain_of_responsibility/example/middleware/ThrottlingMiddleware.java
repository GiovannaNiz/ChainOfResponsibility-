package refactoring_guru.chain_of_responsibility.example.middleware;

/*O código define a classe ThrottlingMiddleware, que estende Middleware para limitar 
o número de requisições por minuto. O método check verifica se um minuto se passou 
desde a última contagem, reinicia essa contagem se necessário, incrementa o contador 
de requisições e, se o limite for excedido, imprime "Request limit exceeded!" e 
interrompe a execução. Caso contrário, permite que a verificação prossiga para o 
próximo objeto na cadeia.*/

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
    
