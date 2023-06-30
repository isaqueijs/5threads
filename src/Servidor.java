package src;

public class Servidor {

    private static boolean lockCalculadora1 = false;
    private static boolean lockCalculadora2 = false;
//
//    private static Calculadora cal1 = new Calculadora("CALCULADORA 1");
//    private static Calculadora cal2 = new Calculadora("CALCULADORA 2");

    static Object lock1 = new Object();
    static Object lock2 = new Object();

    public static int solicitaCalculadora(String nome, int[] numeros) {
        if (!lockCalculadora1) {
            synchronized (lock1) {
                setLockCalculadora1(true);
                System.out.println("⚠️⚠️ - (CALCULADORA 1) - " + nome + " entrou na Região Crítica");
                System.out.println("➕\uD83D\uDD22 - (CALCULADORA 1) - A soma dos numeros do "+ nome + " é: " + calculadora1(numeros));
                setLockCalculadora1(false);
                System.out.println("✅✅ - (CALCULADORA 1) - " + nome + " saiu da Região Crítica");
            }
            return 1;

        } else if (!lockCalculadora2) {
            synchronized (lock2) {
                setLockCalculadora2(true);
                System.out.println("⚠️️️⚠️️️ - (CALCULADORA 2) - " + nome + " entrou na Região Crítica");
                System.out.println("➕\uD83D\uDD22 - (CALCULADORA 2) - A soma dos numeros do "+ nome + " é: " + calculadora2(numeros));
                setLockCalculadora2(false);
                System.out.println("✅✅ - (CALCULADORA 2) - " + nome + " saiu da Região Crítica");
            }
            return 1;
        }
//        synchronized (cal1) {
//            System.out.println("⚠️⚠️ - (" + cal1.getNome() + ") - " + nome + " entrou na Região Crítica");
//            System.out.println("➕\uD83D\uDD22 - (" + cal1.getNome() + ") - A soma dos numeros do "+ nome + " é: " + cal1.somar(numeros));
//            System.out.println("✅✅ - (" + cal1.getNome() + ") - " + nome + " saiu da Região Crítica");
//        }
//
//        synchronized (cal2) {
//            System.out.println("⚠️⚠️ - (" + cal2.getNome() + ") - " + nome + " entrou na Região Crítica");
//            System.out.println("➕\uD83D\uDD22 - (" + cal2.getNome() + ") - A soma dos numeros do "+ nome + " é: " + cal2.somar(numeros));
//            System.out.println("✅✅ - (" + cal2.getNome() + ") - " + nome + " saiu da Região Crítica");
//
//        }

        System.out.println("---------------------------------------\n⌛⌛ - " + nome + "" +
                " aguardando recurso...");
        return 0;
    }

    public static void setLockCalculadora1(boolean lockCalculadora1) {
        Servidor.lockCalculadora1 = lockCalculadora1;
    }

    public static void setLockCalculadora2(boolean lockCalculadora2) {
        Servidor.lockCalculadora2 = lockCalculadora2;
    }

    public static int calculadora1 (int[] numeros) {
        int soma = 0;
        for (int i = 0; i < numeros.length - 1; i++) {
            soma = soma + numeros[i];
        }
        return soma;
    }
    public static int calculadora2 (int[] numeros) {
        int soma = 0;
        for (int i = 0; i < numeros.length - 1; i++) {
            soma = soma + numeros[i];
        }
        return soma;
    }

}
