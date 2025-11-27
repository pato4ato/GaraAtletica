import java.util.ArrayList;

public class Giudice extends Thread {
    static int numero;
    static ArrayList<Atleta> Atleti = new ArrayList<>();
    static ArrayList<Atleta> Podio = new ArrayList<>();
    static ArrayList<Thread> threadAtleti = new ArrayList<>();

    private Giudice() { }

    public static void aggiungimi(Atleta a) {
        Atleti.add(a);
    }
public static void inizio(){
    for (int i = 3; i > 0; i--) {
        System.out.println("Inizio tra " + i);
        try { Thread.currentThread().sleep(900); }
        catch (InterruptedException e) { System.err.println("Errore sleep"); }
    }
    for (Atleta a : Atleti) {
        threadAtleti.add(new Thread(a));
        threadAtleti.getLast().start();
    }
}
    public static void finito(Atleta a) {
        Podio.add(a);
        if (Podio.size() == Atleti.size())
            Giudice.fineGara();
    }

    public static void fineGara() {
        System.out.println("\nLa staffetta dei 400m è terminata, ecco il Podio:");
        System.out.println("Il primo arrivato è " + Podio.get(0).nome);
        System.out.println("Il secondo è " + Podio.get(1).nome);
        System.out.println("Il terzo in classifica è " + Podio.get(2).nome);
    }
}