package Exceptions;

/**
 * Exceção lançada quando o jogador fornece uma entrada de texto ou formato inválido via teclado.
 */
public class EntradaInvalidaException extends RuntimeException {
    /**
     * Constrói a exceção com uma mensagem detalhada.
     * * @param message A mensagem explicativa do erro.
     */
    public EntradaInvalidaException(String message) {
        super(message);
    }
}