package Mapa;

import Personagens.*;

/**
 * Classe abstrata que representa um espaço genérico no mapa do jogo.
 */
public abstract class Local {
    int nivel;

    /**
     * Construtor base para os locais.
     * * @param nivel O nível de dificuldade ou profundidade da sala.
     */
    protected Local(int nivel) {
        this.nivel = nivel;
    }

    /**
     * Executa a ação principal da sala quando o jogador entra nela.
     * * @param jogador O personagem que aciona o evento.
     */
    abstract protected void executarEvento(Personagem jogador);

    /**
     * @return O nome do local.
     */
    abstract protected String getNome();

    /**
     * @return O log descritivo do que ocorreu no local.
     */
    abstract protected String getLog();
}