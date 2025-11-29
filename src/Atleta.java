import java.util.Random;

// Classe che rappresenta un atleta che corre in un thread separato
public class Atleta implements Runnable {

    // Numero dell’atleta
    private int numero;

    // Nome dell’atleta
    private String nome;

    // Metri percorsi durante la gara
    private double metri = 0;

    // Lunghezza totale della gara
    private final double LUNGHEZZAGARA = 400.0;

    // Costruttore
    public Atleta(int pNumero, String pNome) {
        this.numero = pNumero;
        this.nome = pNome;
        Giudice.aggiungimi(this);
    }

    // Metodo eseguito dal thread dell’atleta
    @Override
    public void run() {

        // Generatore casuale per simulare i metri percorsi ogni secondo
        Random rnd = new Random();

        // Salva il tempo di partenza
        long start = System.currentTimeMillis();

        // Ciclo finché non supera i 400 metri
        while (metri <= LUNGHEZZAGARA) {

            // Aumenta di un valore casuale tra 0 e 50
            metri += rnd.nextDouble(50);

            System.out.println(nome + " Metri Percorsi: " + metri);

            // Pausa di 1 secondo per simulare la corsa reale
            try { Thread.sleep(1000); }
            catch (InterruptedException e) { System.err.println("Errore sleep"); }
        }
        // Comunica al Giudice che è arrivato
        Giudice.finito(this);
    }
    // GETTER richiesti dal GestoreFile
    public int getIdCorrente() { return numero; }
    public String getNomeAtleta() { return nome; }
}
