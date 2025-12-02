import java.util.Random;

/** @pato4ato
 * @Version 6.0
 * Rappresenta un atleta che partecipa a una gara di corsa.
 * Ogni atleta viene eseguito all'interno di un thread indipendente
 * e simula l'avanzamento casuale fino al completamento della gara.
 */
public class Atleta implements Runnable {

    /** Numero identificativo dell'atleta. */
    private int numero;

    /** Nome dell'atleta. */
    private String nome;

    /** Metri percorsi finora. */
    private double metri = 0;

    /** Lunghezza totale della gara in metri. */
    private final double LUNGHEZZAGARA = 100.0;

    /**
     * Costruttore dell'atleta.
     *
     * @param pNumero numero identificativo dell'atleta
     * @param pNome nome dell'atleta
     */
    public Atleta(int pNumero, String pNome) {
        this.numero = pNumero;
        this.nome = pNome;
        Giudice.aggiungimi(this);
    }

    /**
     * Metodo eseguito dal thread dell'atleta.
     * Simula la corsa tramite incrementi casuali di distanza.
     */
    @Override
    public void run() {

        Random rnd = new Random();

        while (metri <= LUNGHEZZAGARA) {

            metri += rnd.nextDouble(15);

            System.out.println(nome + " Metri Percorsi: " + metri);

            try { Thread.sleep(1000); }
            catch (InterruptedException e) {
                System.err.println("Errore sleep");
            }
        }

        Giudice.finito(this);
    }

    /**
     * Restituisce il numero identificativo dell'atleta.
     * @return numero atleta
     */
    public int getIdCorrente() { return numero; }

    /**
     * Restituisce il nome dell'atleta.
     * @return nome atleta
     */
    public String getNomeAtleta() { return nome; }
}
