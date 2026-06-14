package Mapa;

import Personagens.*;
import java.util.Random;

/**
 * Representa uma sala de combate onde o jogador enfrenta um inimigo gerado aleatoriamente.
 */
public class EncontroHostil extends Local {
    Personagem inimigo;
    private static final Random aleatorio = new Random();

    private static final String[] nomes = {"Mister Chaves", "Sir Madruga", "Miss Chiquinha",
            "Mister Nhonhô", "Lord Barriga", "71's Witch", "Mister Kiko", "Lady Florinda", "Master Linguiça"};
    private static final String[] tipos = {"GUERREIRO", "ARQUEIRO", "CAVALEIRO", "LANCEIRO"};

    /**
     * Constrói o evento de combate e gera um inimigo com base no nível do andar.
     * * @param nivel O nível de dificuldade do inimigo.
     */
    protected EncontroHostil(int nivel) {
        super(nivel);
        this.inimigo = new Personagem(nomes[aleatorio.nextInt(9)], nivel, tipos[aleatorio.nextInt(4)]);
    }

    protected void executarEvento(Personagem jogador) {
        while (jogador.vivo() && inimigo.vivo()) {

            System.out.println("----------------------------------------------------------------------------------");
            System.out.println(jogador.getNome() + " vida Atual: " + jogador.getVidaAtual());
            System.out.println(inimigo.getNome() + " vida Atual: " + inimigo.getVidaAtual());
            System.out.println();

            System.out.println(jogador.getNome() + " ataca");
            inimigo.apanhar(jogador.getAtaque(), jogador.getTipo());
            System.out.println();

            System.out.println(inimigo.getNome() + " ataca");
            jogador.apanhar(inimigo.getAtaque(), inimigo.getTipo());
        }

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Embate chegou ao fim:");
        System.out.println(jogador.getNome() + " vida Atual: " + jogador.getVidaAtual());
        System.out.println(inimigo.getNome() + " vida Atual: " + inimigo.getVidaAtual());
        System.out.println("\n");

        if (jogador.vivo()) {
            System.out.println("Embate ganho, " + inimigo.getNome() + " faleceu...");
            System.out.println("+" + inimigo.getNivel() + " Nível(is) ganho(s).");
            jogador.subirNivel(inimigo.getNivel());
            jogador.registrarVitoria();
        } else {
            System.out.println("NOOB, tu morreu kkkkkkkkkkk.");
        }

        System.out.println("----------------------------------------------------------------------------------");
    }

    protected String getNome() {
        return "Encontro Hostil";
    }

    protected String getLog() {
        return " Encontro Hostil: enfrentou " + inimigo.getNome() + ".";
    }
}