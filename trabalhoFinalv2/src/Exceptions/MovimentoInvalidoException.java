package Exceptions;

/**
 * Exceção lançada quando o jogador tenta acessar uma sala ou caminho inexistente no mapa.
 */
public class MovimentoInvalidoException extends RuntimeException {
    /**
     * Constrói a exceção com uma mensagem detalhada.
     * * @param message A mensagem explicativa do erro.
     */
    public MovimentoInvalidoException(String message) {
        super(message);
    }
}