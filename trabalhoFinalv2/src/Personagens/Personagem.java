package Personagens;

/**
 * Representa um personagem no jogo, podendo ser o jogador ou um inimigo.
 * Gerencia atributos, progressão de nível e interações de combate.
 */
public class Personagem implements Peao {

    private String nome;
    private int vidaMax;
    private int vidaAtual;
    private int ataque;
    private int nivel;
    private TipoCombate tipo;
    private int vitorias;

    /**
     * Construtor da classe Personagem.
     * * @param nome O nome do personagem.
     * @param xp Nível inicial ou bônus de experiência.
     * @param tipo A classe de combate (ex: "GUERREIRO").
     */
    public Personagem(String nome, int xp, String tipo) {
        this.nome = nome;
        this.tipo = TipoCombate.valueOf(tipo);

        this.vidaMax = this.tipo.getVidaInicial();
        this.vidaAtual = this.vidaMax;
        this.ataque = this.tipo.getAtaqueInicial();

        subirNivel(xp);
    }

    public boolean vivo(){
        return (vidaAtual > 0);
    }

    public int getVidaAtual(){
        return vidaAtual;
    }

    public int getVidaMax(){
        return vidaMax;
    }

    public int getAtaque(){
        return ataque;
    }

    public TipoCombate getTipo(){
        return tipo;
    }

    public int getNivel(){
        return nivel;
    }

    public String getNome(){
        return getTipo() + "  " + nome;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void registrarVitoria(){
        vitorias++;
    }

    public void subirNivel(int xp){
        nivel += xp;
        float multiplicador = (float) Math.pow(1.1, xp);
        vidaAtual = (int) (vidaAtual * multiplicador);
        vidaMax = (int) (vidaMax * multiplicador);
        ataque = (int) (ataque * multiplicador);
    }

    public void apanhar(int danoBase, TipoCombate tipoAtacante){
        int danoFinal = danoBase;

        if (tipoAtacante.temVantagemContra(tipo)){
            danoFinal = (int) (danoBase * 1.5);
            System.out.println("O ataque foi super efetivo!");
        }

        vidaAtual -= danoFinal;

        if (this.vidaAtual < 0){
            vidaAtual = 0;
        }
        System.out.println(nome + " perdeu: " + danoFinal + " pontos de vida.");
    }

    public void curar(int cura){
        if (vidaAtual + cura > vidaMax) {
            cura = vidaMax - vidaAtual;
        }
        vidaAtual += cura;
        System.out.println(nome + " recuperou: " + cura + " pontos de vida.");
        System.out.println();
    }
}