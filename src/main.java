/**
 * Classe principale che avvia l'applicazione.
 * Crea gli atleti, li registra presso il Giudice e fa partire la gara.
 */
public class main {

    /** @pato4ato
     * @Version 6.0
     * Metodo principale dell'applicazione.
     * @param args argomenti da linea di comando (non utilizzati)
     */
    public static void main(String[] args) {

        System.out.println("\nGara Atletica");

        new Atleta(7, "!RONNY! (CR7)");
        new Atleta(10, "Lionello (LM10)");
        new Atleta(13, "Hames (LB)");
        new Atleta(36, "Janniko (S)");
        new Atleta(69, "Marcello (J)");

        Giudice.via();
    }
}
