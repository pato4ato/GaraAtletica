import java.io.*;
import java.util.ArrayList;
import java.util.List;

/** @pato4ato
 * @Version 7.0
 * Gestisce la lettura da file e la scrittura del podio finale.
 */
public class gestoreFile {

    /**
     * Legge i nomi degli atleti da un file.
     * Ogni riga contiene solo il nome dell’atleta.
     *
     * @param nomeFile percorso del file
     * @return lista di nomi letti
     */
    public List<String> leggiNomi(String nomeFile) {

        List<String> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeFile))) {

            String riga;

            while ((riga = br.readLine()) != null) {
                riga = riga.trim();
                if (!riga.isEmpty()) {
                    lista.add(riga);
                }
            }

        } catch (IOException e) {
            System.err.println("Errore lettura file: " + e.getMessage());
        }

        return lista;
    }

    /**
     * Scrive i primi tre classificati su un file.
     *
     * @param podio lista degli atleti in ordine di arrivo
     * @param nomeFile percorso del file di output
     */
    public void scriviPodio(List<Atleta> podio, String nomeFile) {

        try (PrintWriter pw = new PrintWriter(new FileWriter(nomeFile))) {

            int limite = Math.min(3, podio.size());

            pw.println("    PODIO    ");

            for (int i = 0; i < limite; i++) {
                Atleta a = podio.get(i);
                pw.printf("%d) %s  [N° %d]\n", i + 1, a.getNome(), a.getNumero());
            }

            pw.println("\nVincitore: " + podio.get(0).getNome());

        } catch (IOException e) {
            System.err.println("Errore scrittura file: " + e.getMessage());
        }
    }
}
