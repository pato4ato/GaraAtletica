import java.io.FileWriter;
import java.io.IOException;

public class gestoreFile {

    public static synchronized void salvaPodio(String Classifica) {
        try (FileWriter file = new FileWriter("Ordine arrivo ultima gara.txt")) {
            file.write(Classifica + "\n");
        } catch (IOException e) {
            System.err.println("Errore scrittura file: " + e.getMessage());
        }
    }
}
