import Exceptions.*;
import Mapa.*;
import Personagens.*;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.io.*;

/**
 * Classe principal responsável por inicializar o jogo, gerenciar o laço de repetição
 * principal e exportar os logs da partida.
 */
public class Main {
    static Scanner entrada = new Scanner(System.in);

    /**
     * Ponto de entrada do programa. Executa o fluxo principal do jogo.
     * * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        Mapa mapa = mapaSetup();
        Personagem jogador = gerarJogador();
        ArrayList <Integer> caminhoAndado = new ArrayList<Integer>();

        int escolha;
        while(jogador.vivo() && !mapa.fim()) {
            System.out.println(jogador.getNome());
            System.out.println("Ataque: " + jogador.getAtaque());
            System.out.println("Vida Atual: " + jogador.getVidaAtual());
            System.out.println("Vida Max: " + jogador.getVidaMax());
            System.out.println("Nível: " + jogador.getNivel());

            mapa.imprimeEscolha();
            while (true) {
                try {
                    escolha = entrada.nextInt() - 1;
                    mapa.escolherSala(escolha, jogador);
                    break;
                } catch (RuntimeException excecao) {
                    System.out.println("Entrada Inválida");
                    entrada.nextLine();
                }
            }
            caminhoAndado.addLast(escolha);
        }

        System.out.println();
        if (mapa.fim()) {
            System.out.println("PARABÉNS, VOCÊ VENCEU!");
        } else {
            System.out.println("PARABÉNS, VOCÊ PERDEU!");
        }
        System.out.println();

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("logs.txt"));
            // Lógica de gravação do arquivo pode ser inserida aqui
        } catch (java.io.IOException e) {
            System.out.println("deu ruim aqui piazada");
        }

        System.out.println("Inimigos derrotados: " + jogador.getVitorias());
        System.out.println();
        System.out.println("Caminho percorrido:");
        for (int i = 0; caminhoAndado.size() > 0; i++) {
            System.out.println((i + 1) + " Andar: " + mapa.getLogSala(i, caminhoAndado.removeFirst()));
        }
    }

    /**
     * Coleta os dados iniciais pelo console e instancia um novo jogador.
     * * @return Um objeto Personagem devidamente configurado.
     */
    static Personagem gerarJogador() {
        String nome, classe;
        System.out.println("Nome: ");
        nome = entrada.nextLine();
        System.out.println("Classe (Guerreiro, arqueiro, cavaleiro, lanceiro): ");
        while (true) {
            try {
                classe = entrada.nextLine();
                classe = classe.toUpperCase(Locale.ROOT);
                classeValida(classe);
                break;
            } catch (EntradaInvalidaException exception) {
                System.out.println(exception.getMessage());
            }
        }
        System.out.println();
        return new Personagem(nome, 5, classe);
    }

    /**
     * Valida se a classe de combate digitada pelo usuário existe no sistema.
     * * @param classe A string representando a classe desejada.
     * @throws EntradaInvalidaException Se a classe não pertencer à lista de válidas.
     */
    static void classeValida(String classe) throws EntradaInvalidaException {
        String[] classesValidas = new String[] {"GUERREIRO", "ARQUEIRO", "CAVALEIRO", "LANCEIRO"};
        boolean valida = false;
        for (String x : classesValidas) {
            if (classe.equals(x)) {
                valida = true;
            }
        }
        if(!valida) throw new EntradaInvalidaException("Classe Inválida");
    }

    /**
     * Define o tamanho do mapa interagindo com o usuário e constrói a instância principal.
     * * @return Uma instância preenchida de Mapa.
     */
    static Mapa mapaSetup() {
        int andares;
        System.out.println("Quantos andares (10 - 30)?");
        while (true) {
            try {
                andares = entrada.nextInt();
                if (andares < 10 || andares > 30) {
                    throw new EntradaInvalidaException("");
                }
                break;
            } catch (RuntimeException exception) {
                System.out.println("Tamanho inválido");
                entrada.nextLine();
            }
        }
        entrada.nextLine();
        return new Mapa(andares);
    }
}