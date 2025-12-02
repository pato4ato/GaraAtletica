<h1>Simulazione Gara Atletica 400m</h1>
<br>
Il progetto rappresenta una simulazione di una gara di atletica sui 400 metri, dove ogni atleta viene gestito come un thread indipendente. Gli atleti avanzano in modo casuale e il Giudice registra l’ordine di arrivo. Al termine della gara vengono mostrati i primi tre classificati e il nome del vincitore su una riga separata. Inoltre, il sistema salva i risultati in un file dedicato.



<br>
<h2>Obiettivi</h2>

Comprendere la gestione dei thread in un programma Java.

Gestire processi concorrenti che operano in parallelo.

Coordinare l’arrivo degli atleti tramite sincronizzazione.

Produrre un output ordinato e salvare i risultati in un file.

Documentare il progetto in modo chiaro tramite Javadoc.



<br>
<h2>Componenti Principali</h2>

<h3>Main</h3>

Avvia la simulazione.

Registra gli atleti.

Inizia la gara tramite il Giudice.

<h3>Atleta</h3>

Ogni atleta è un thread.

Avanza di una distanza casuale ad intervalli regolari.

Comunica al Giudice quando raggiunge la linea d’arrivo.

<h3>Giudice</h3>

Avvia il countdown della gara.

Lancia i thread degli atleti.

Registra l’ordine di arrivo tramite un metodo sincronizzato.

Determina il podio (primi tre classificati).

Stampa i risultati finali.

Salva il podio su file.

<h3>Gestore File</h3>

Legge da file un elenco di atleti, se necessario.

Salva il podio e il nome del vincitore su un file testuale chiamato “podio”.



<br>
<h2>Funzionamento della Gara</h2>

Gli atleti vengono creati e registrati.

Il Giudice effettua un breve countdown.

Ogni atleta avanza in modo indipendente e casuale.

Quando un atleta termina i 400 metri, viene registrato nell’ordine d’arrivo.

Una volta arrivati tutti:

Vengono mostrati i primi tre classificati.

Viene indicato chiaramente il vincitore.

I risultati vengono salvati su file.



<br>
<h2>Output Atteso</h2>

Visualizzazione dei primi tre classificati in ordine.

Conferma della creazione del file dei risultati.

<h3>File di testo contenente:</h3>

Primo, secondo e terzo classificato.

Indicazione del vincitore.



<br>
<h2>Documentazione</h2>

<h3>La documentazione Javadoc descrive:</h3>

Scopo delle classi.

Funzione di ogni metodo.

Parametri e variabili importanti.

Flusso generale della simulazione.

