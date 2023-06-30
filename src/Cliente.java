package src;

public class Cliente extends Thread{
    private String nome;
    private int[] numeros;

    public Cliente (String nome, int[] numeros) {
        this.nome = nome;
        this.numeros = numeros;
    }

    public void run() {
        int soma = Servidor.solicitaCalculadora(nome, numeros);
        while (soma == 0) {
//            System.out.println("---------------------------------------\n⌛⌛ - " + nome + "" +
//                    " aguardando recurso...");
            Main.delay(4000);
            soma = Servidor.solicitaCalculadora(nome, numeros);
        }
    }

}
