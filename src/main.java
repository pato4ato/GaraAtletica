/** @pato4ato
 * @Version 7.0
 * Classe principale che crea gli atleti e fa partire la gara.
 */
public class main {

    public static void main(String[] args) {

        System.out.println("    Gara di Atletica 100m    ");

        new Atleta(7, "Ronny (CR7)");
        new Atleta(10, "Lionello (LM10)");
        new Atleta(13, "Hames (LB)");
        new Atleta(36, "Janniko (S)");
        new Atleta(69, "Marcello (J)");

        Giudice.startGara();
    }
}
