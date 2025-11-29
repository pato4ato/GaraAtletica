import java.util.ArrayList;

public class Giudice {

    // Lista di tutti gli atleti che partecipano alla gara
    static ArrayList<Atleta> atleti = new ArrayList<>();

    // Lista degli atleti nell'ordine d'arrivo
    static ArrayList<Atleta> podio = new ArrayList<>();

    // Thread associati agli atleti
    static ArrayList<Thread> threadAtleti = new ArrayList<>();

    // Metodo richiamato dagli atleti per registrarsi
    public static void aggiungimi(Atleta a) {
        atleti.add(a);
    }

    // Da il via alla gara
    public static void via() {

        // Countdown prima della partenza
        for (int i = 3; i > 0; i--) {
            System.out.println("Inizio tra " + i);
            try { Thread.sleep(900); }
            catch (InterruptedException e) { System.err.println("Errore sleep"); }
        }

        // Crea il Thread per ogni atleta e lo avvia
        for (Atleta a : atleti) {
            Thread t = new Thread(a);
            threadAtleti.add(t);
            t.start();
        }
    }

    // Chiamato da ogni atleta quando arriva al traguardo
    public static synchronized void finito(Atleta a) {

        // Aggiunge nel podio in ordine di arrivo
        podio.add(a);

        // Se tutti gli atleti sono arrivati stampa il podio
        if (podio.size() == atleti.size()) {
            fineGara();
        }
    }

    // Stampa il podio finale e lo salva su file
    public static void fineGara() {

        System.out.println("\nLa staffetta dei 400m è terminata! Podio finale:");

        // Stampa classifica in console
        for (int i = 0; i < podio.size(); i++) {
            Atleta a = podio.get(i);
            System.out.printf("\n%d - %s  [%d] ",
                    i + 1, a.getNomeAtleta(), a.getIdCorrente());
        }

        // Scrive su file il podio usando il GestoreFile
        gestoreFile GF = new gestoreFile();
        GF.stampaPodio(podio, "podio.txt");

        System.out.println("Podio salvato in podio.txt");
    }
}
