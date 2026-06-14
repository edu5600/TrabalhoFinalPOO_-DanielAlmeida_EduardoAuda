package Mapa;

import Personagens.*;

/**
 * Representa uma área segura no mapa onde o jogador recupera pontos de vida.
 */
public class Enfermaria extends Local {
    int cura;

    /**
     * Constrói a enfermaria escalando a cura com base no nível atual.
     * * @param nivel O andar onde a enfermaria está localizada.
     */
    protected Enfermaria(int nivel) {
        super(nivel);
        this.cura = nivel * 20;
    }

    protected void executarEvento(Personagem jogador) {
        jogador.curar(cura);
    }

    protected String getNome() {
        return "Enfermaria";
    }

    protected String getLog() {
        return " Enfermaria: curou " + cura + " pontos de vida.";
    }
}