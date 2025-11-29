import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

class gestoreFile {

    // Legge una lista di nomi dal file
    public List<String> leggiAtleti(String nomeFile) {

        List<String> nomi = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeFile))) {

            String riga;

            // Legge riga per riga
            while ((riga = br.readLine()) != null) {
                riga = riga.trim();

                // Salta righe vuote
                if (!riga.isEmpty()) {
                    nomi.add(riga);
                }
            }

        } catch (IOException e) {
            System.err.println("Errore lettura file: " + e.getMessage());
        }

        return nomi; // Può essere vuota
    }


    // Scrive il podio sul file indicato
    public void stampaPodio(List<Atleta> podio, String nomeFile) {

        try (PrintWriter pw = new PrintWriter(new FileWriter(nomeFile))) {

            int posizione = 1;

            // Scrive ogni atleta in ordine
            for (Atleta c : podio) {
                pw.printf("\n%d - %s - %d",
                        posizione++,                   // Posizione in classifica
                        c.getNomeAtleta(),             // Nome
                        c.getIdCorrente());             // ID atleta
            }

            System.out.println("\n\nPodio scritto nel file: " + nomeFile);

        } catch (IOException e) {
            System.err.println("\nErrore scrittura podio: " + e.getMessage());
        }
    }
}
