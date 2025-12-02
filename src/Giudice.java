import java.util.ArrayList;

/** @pato4ato
 * @Version 6.0
 * Gestisce la gara, registra gli atleti, avvia i thread e
 * determina l'ordine di arrivo dei partecipanti.
 */
public class Giudice {

    /** Lista di tutti gli atleti registrati. */
    static ArrayList<Atleta> atleti = new ArrayList<>();

    /** Lista degli atleti in ordine di arrivo. */
    static ArrayList<Atleta> podio = new ArrayList<>();

    /** Lista dei thread associati agli atleti. */
    static ArrayList<Thread> threadAtleti = new ArrayList<>();

    /**
     * Registra un atleta prima della partenza.
     * @param a atleta da aggiungere
     */
    public static void aggiungimi(Atleta a) {
        atleti.add(a);
    }

    /**
     * Avvia la gara, effettua un conto alla rovescia,
     * crea e avvia i thread per ogni atleta.
     */
    public static void via() {
        System.out.println("\n");
        for (int i = 3; i > 0; i--) {
            System.out.println("Inizio tra " + i);
            try { Thread.sleep(900); }
            catch (InterruptedException e) {
                System.err.println("Errore sleep");
            }
        }
        System.out.println("\n");
        for (Atleta a : atleti) {
            Thread t = new Thread(a);
            threadAtleti.add(t);
            t.start();
        }
    }

    /**
     * Metodo richiamato da un atleta quando conclude la gara.
     * Viene inserito nell'ordine di arrivo.
     *
     * @param a atleta che ha terminato
     */
    public static synchronized void finito(Atleta a) {

        podio.add(a);

        if (podio.size() == atleti.size()) {
            fineGara();
        }
    }

    /**
     * Elabora la classifica finale,
     * stampa i primi tre posti in console,
     * indica il vincitore e salva i risultati su file.
     */
    public static void fineGara() {

        System.out.println("\nLo sprint dei 100m è terminato! Podio finale:");

        int limite = Math.min(3, podio.size());

        System.out.println("\nVincitore: " + podio.get(0).getNomeAtleta());

        System.out.println("\n--------------------------");

        for (int i = 0; i < limite; i++) {
            Atleta a = podio.get(i);
            System.out.printf("\n%d - %s  [%d]",
                    i + 1, a.getNomeAtleta(), a.getIdCorrente());
        }

        System.out.println("\n--------------------------");

        gestoreFile GF = new gestoreFile();
        GF.stampaPodio(podio, "podio.txt");

        System.out.println("\nPodio salvato in podio.txt");
    }
}
