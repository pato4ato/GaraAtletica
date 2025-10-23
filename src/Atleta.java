public class Atleta implements Runnable{
    int numero;
    String nome;
    double tempo=0;
    double metri=0;
    final double LUNGHEZZAGARA= 400;
    @Override
            public void run(){

    }
    public Atleta(int pNumero, String pNome){
        numero=pNumero;
        nome=pNome;
    }
    while (metri <= 400) {
        System.out.println("Distanza percorsa: " + metri);

    }

}
