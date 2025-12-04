import java.util.ArrayList;

/**  @pato4ato
 * @Version 7.0
 * Gestisce la gara: registra gli atleti, avvia i thread e crea il podio.
 */
public class Giudice {

    /** Elenco degli atleti partecipanti. */
    private static ArrayList<Atleta> atleti = new ArrayList<>();

    /** Ordine di arrivo (riempito dai thread). */
    private static ArrayList<Atleta> podio = new ArrayList<>();

    /** Lista dei thread degli atleti. */
    private static ArrayList<Thread> threads = new ArrayList<>();

    /**
     * Registra un atleta nella gara.
     *
     * @param a atleta da aggiungere
     */
    public static void aggiungiAtleta(Atleta a) {
        atleti.add(a);
    }

    /**
     * Avvia la gara con un conto alla rovescia
     * e crea un thread per ogni atleta.
     */
    public static void startGara() {

        System.out.println("\n    PARTENZA TRA    ");

        for (int i = 3; i > 0; i--) {
            System.out.println(i);
            try { Thread.sleep(900); }
            catch (InterruptedException e) { }
        }

        System.out.println("\nVIA!\n");

        for (Atleta a : atleti) {
            Thread t = new Thread(a);
            threads.add(t);
            t.start();
        }
    }

    /**
     * Viene chiamato da un atleta quando termina la corsa.
     * Sincronizzato per evitare conflitti.
     *
     * @param a atleta arrivato
     */
    public static synchronized void arrivo(Atleta a) {

        podio.add(a);

        // Quando arrivano tutti → stampa risultati
        if (podio.size() == atleti.size()) {
            stampaRisultati();
        }
    }

    /**
     * Stampa il podio finale e salva i risultati su file.
     */
    private static void stampaRisultati() {

        System.out.println("\n   RISULTATI FINALI  ");

        int limite = Math.min(3, podio.size());

        System.out.println("\nVincitore: " + podio.get(0).getNome());

        System.out.println("\n    PODIO    ");
        for (int i = 0; i < limite; i++) {
            Atleta a = podio.get(i);
            System.out.printf("%d) %s  [N° %d]\n", i + 1, a.getNome(), a.getNumero());
        }

        // Salva su file
        new gestoreFile().scriviPodio(podio, "podio.txt");
    }
}
