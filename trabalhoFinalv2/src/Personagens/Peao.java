package Personagens;

/**
 * Interface que define as ações básicas e o estado de uma entidade dentro do jogo.
 */
public interface Peao {
    /**
     * Aplica dano à entidade, considerando possíveis vantagens de tipo.
     * * @param dano O valor base do dano recebido.
     * @param tipo O tipo de combate do atacante.
     */
    public void apanhar(int dano, TipoCombate tipo);

    /**
     * Restaura pontos de vida da entidade até o seu limite máximo.
     * * @param cura A quantidade de pontos de vida a ser recuperada.
     */
    public void curar(int cura);

    /**
     * Verifica se a entidade ainda possui pontos de vida.
     * * @return true se a vida for maior que zero, false caso contrário.
     */
    public boolean vivo();

    /**
     * Aumenta os atributos da entidade com base na experiência recebida.
     * * @param xp A quantidade de níveis a subir.
     */
    public void subirNivel(int xp);

    /**
     * @return A vida atual da entidade.
     */
    public int getVidaAtual();

    /**
     * @return O tipo de combate associado à entidade.
     */
    public TipoCombate getTipo();

    /**
     * @return O poder de ataque atual da entidade.
     */
    public int getAtaque();

    /**
     * @return O nível atual da entidade.
     */
    public int getNivel();

    /**
     * @return O nome formatado da entidade.
     */
    public String getNome();

    /**
     * Incrementa o contador de vitórias da entidade.
     */
    public void registrarVitoria();
}