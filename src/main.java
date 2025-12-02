public class main {
    public static void main(String[] args) {

        // Titolo della gara.
        System.out.println("Gara Atletica");

        // Creazione dei partecipanti alla gara, gni atleta si registra dal Giudice.
        new Atleta(7, "Penaldo (CR7)");
        new Atleta(10, "Lionello (LM10)");
        new Atleta(13, "Hames (LB)");
        new Atleta(36, "Janniko (S)");
        new Atleta(69, "Marcello (J)");

        // Avvio della gara.
        Giudice.via();
    }
}
