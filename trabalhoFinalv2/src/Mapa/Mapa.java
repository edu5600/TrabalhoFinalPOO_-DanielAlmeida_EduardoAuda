package Mapa;

import Exceptions.*;
import Personagens.*;

/**
 * Gerencia a estrutura de andares e salas do jogo, controlando a progressão do jogador.
 */
public class Mapa {
    private Local[][] mapa;
    int andarFinal = 0;
    int andarAtual = 0;

    /**
     * Constrói o mapa preenchendo as matrizes de salas até o andar final.
     * * @param andares A quantidade total de andares da masmorra.
     */
    public Mapa(int andares) {
        this.andarFinal = andares - 1;
        this.mapa = new Local[andares][2];
        gerarMapa();
    }

    /**
     * Preenche o mapa com encontros hostis e enfermarias. O último andar contém apenas chefes.
     */
    private void gerarMapa() {
        for (int i = 0; i < andarFinal; i++) {
            mapa[i][0] = new EncontroHostil(i + 1);
            mapa[i][1] = new Enfermaria(i + 1);
        }

        mapa[andarFinal][0] = new EncontroHostil(this.andarFinal + 1);
        mapa[andarFinal][1] = new EncontroHostil(this.andarFinal + 1);
    }

    /**
     * Verifica se o jogador ultrapassou o último andar do mapa.
     * * @return true se o mapa chegou ao fim, false caso contrário.
     */
    public boolean fim() {
        if (andarAtual > andarFinal) return true;
        return false;
    }

    /**
     * Movimenta o jogador para a sala escolhida e executa o evento da mesma.
     * * @param escolhaJogador O índice da coluna selecionada (0 ou 1).
     * @param jogador A instância do personagem que está progredindo.
     * @throws MovimentoInvalidoException Se o índice da porta não for 0 ou 1.
     */
    public void escolherSala(int escolhaJogador, Personagem jogador) throws MovimentoInvalidoException {
        if (escolhaJogador != 0 && escolhaJogador != 1) {
            throw new MovimentoInvalidoException("");
        }
        mapa[andarAtual][escolhaJogador].executarEvento(jogador);
        andarAtual++;
    }

    /**
     * Imprime no console as opções de sala disponíveis no andar atual.
     */
    public void imprimeEscolha() {
        System.out.println();
        System.out.println("Andar: " + (andarAtual + 1));
        System.out.println("Escolha uma sala:");
        System.out.println("1. " + mapa[andarAtual][0].getNome());
        System.out.println("2. " + mapa[andarAtual][1].getNome());
        System.out.println();
    }

    /**
     * Recupera o nome da sala especificada na matriz.
     * * @param i O índice da linha (andar).
     * @param j O índice da coluna (sala).
     * @return O nome do local.
     */
    public String getNomeSala(int i, int j) {
        return mapa[i][j].getNome();
    }

    /**
     * Recupera o log descritivo da sala especificada na matriz.
     * * @param i O índice da linha (andar).
     * @param j O índice da coluna (sala).
     * @return O log do local.
     */
    public String getLogSala(int i, int j) {
        return mapa[i][j].getLog();
    }
}