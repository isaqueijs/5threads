package src;

public class Main {
    public static void main(String[] args) {
        int[] v1 = {1,2,3,4,5,6,7,8,9,10};
        int[] v2 = {10,20,30,40,50,60,70,80,90,100};
        int[] v3 = {100,200,300,400,500,600,700,800,900,1000};
        int[] v4 = {1000,2000,3000,4000,5000,6000,7000,8000,9000,10000};
        int[] v5 = {10000,20000,30000,40000,50000,60000,70000,80000,90000,10000};

        Cliente c1 = new Cliente("Cliente 1", v1);
        Cliente c2 = new Cliente("Cliente 2", v2);
        Cliente c3 = new Cliente("Cliente 3", v3);
        Cliente c4 = new Cliente("Cliente 4", v4);
        Cliente c5 = new Cliente("Cliente 5", v5);

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();

        delay(3000);
    }

    public static void delay(int tempo){
        try {
            Thread.sleep(tempo); // Dorme por 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}