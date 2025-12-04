import java.util.Random;

/**  @pato4ato
 * @Version 7.0
 * Rappresenta un atleta che corre in un thread indipendente.
 * Ogni atleta avanza di una quantità casuale finché raggiunge i 100 metri.
 */
public class Atleta implements Runnable {

    /** Numero identificativo dell’atleta. */
    private int numero;

    /** Nome dell’atleta. */
    private String nome;

    /** Metri percorsi durante la corsa. */
    private double metri = 0;

    /** Lunghezza totale della gara in metri. */
    private final double LUNGHEZZA_GARA = 100.0;

    /**
     * Costruttore dell’atleta.
     *
     * @param numero numero identificativo
     * @param nome nome dell’atleta
     */
    public Atleta(int numero, String nome) {
        this.numero = numero;
        this.nome = nome;
        Giudice.aggiungiAtleta(this);
    }

    /**
     * Codice eseguito dal thread dell’atleta.
     * Avanza di un numero casuale di metri ogni secondo.
     */
    @Override
    public void run() {

        Random rnd = new Random();

        while (metri < LUNGHEZZA_GARA) {

            // Avanza di 0–15 metri
            metri += rnd.nextDouble() * 25;

            System.out.println(nome + " ha percorso: " + String.format("%.2f", metri) + " m");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Thread interrotto per: " + nome);
            }
        }

        // L’atleta segnala al giudice che ha finito
        Giudice.arrivo(this);
    }

    /**
     * @return nome dell’atleta
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return numero identificativo dell’atleta
     */
    public int getNumero() {
        return numero;
    }
}
