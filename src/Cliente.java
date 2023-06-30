package src;

public class Cliente extends Thread{
    private String nome;
    private int[] numeros;

    public Cliente (String nome, int[] numeros) {
        this.nome = nome;
        this.numeros = numeros;
    }

    public void run() {
        int recurso = Servidor.solicitaCalculadora(nome, numeros);
        while (recurso == 0) {
//            System.out.println("---------------------------------------\n⌛⌛ - " + nome + "" +
//                    " aguardando recurso...");
            Main.delay(10);
            recurso = Servidor.solicitaCalculadora(nome, numeros);
        }
    }

}
