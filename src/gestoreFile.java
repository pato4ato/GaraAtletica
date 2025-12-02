import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/** @pato4ato
 * @Version 6.0
 * Classe che gestisce operazioni di input/output su file,
 * come la lettura di elenchi e la scrittura del podio finale.
 */
class gestoreFile {

    /**
     * Legge una lista di nomi da un file di testo.
     *
     * @param nomeFile percorso del file da leggere
     * @return lista di stringhe contenenti i nomi trovati
     */
    public List<String> leggiAtleti(String nomeFile) {

        List<String> nomi = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeFile))) {

            String riga;

            while ((riga = br.readLine()) != null) {
                riga = riga.trim();

                if (!riga.isEmpty()) {
                    nomi.add(riga);
                }
            }

        } catch (IOException e) {
            System.err.println("Errore lettura file: " + e.getMessage());
        }

        return nomi;
    }

    /**
     * Scrive su file i primi tre atleti del podio e il vincitore.
     *
     * @param podio lista ordinata degli atleti arrivati
     * @param nomeFile percorso del file dove salvare il podio
     */
    public void stampaPodio(List<Atleta> podio, String nomeFile) {

        try (PrintWriter pw = new PrintWriter(new FileWriter(nomeFile))) {

            int limite = Math.min(3, podio.size());

            for (int i = 0; i < limite; i++) {
                Atleta c = podio.get(i);
                pw.printf("\n%d - %s - %d",
                        i + 1,
                        c.getNomeAtleta(),
                        c.getIdCorrente());
            }

            pw.println("\n--------------------------");
            pw.println("Vincitore: " + podio.get(0).getNomeAtleta());

            System.out.println("\nPodio scritto nel file: " + nomeFile);

        } catch (IOException e) {
            System.err.println("\nErrore scrittura podio: " + e.getMessage());
        }
    }
}
