package Personagens;

import java.util.*;

/**
 * Enumeração que define as classes disponíveis no jogo e suas respectivas
 * estatísticas iniciais e vantagens táticas.
 */
public enum TipoCombate {
    GUERREIRO(80,10),
    ARQUEIRO(50,16),
    CAVALEIRO(70,12),
    LANCEIRO(60,14);

    private final int vida;
    private final int ataque;

    TipoCombate(int vida, int ataque){
        this.vida = vida;
        this.ataque = ataque;
    }

    private static final Map<TipoCombate, TipoCombate> vantagens = new HashMap<>();

    static{
        vantagens.put(GUERREIRO, LANCEIRO);
        vantagens.put(LANCEIRO,CAVALEIRO);
        vantagens.put(CAVALEIRO,ARQUEIRO);
        vantagens.put(ARQUEIRO,GUERREIRO);
    }

    /**
     * Verifica se este tipo de combate possui vantagem contra outro.
     * * @param outro O tipo de combate adversário.
     * @return true se houver vantagem, false caso contrário.
     */
    protected boolean temVantagemContra(TipoCombate outro){
        return vantagens.get(this) == outro;
    }

    protected int getVidaInicial(){
        return this.vida;
    }

    protected int getAtaqueInicial(){
        return this.ataque;
    }
}