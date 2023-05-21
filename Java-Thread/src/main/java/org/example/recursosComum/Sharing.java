package org.example.recursosComum;

public class Sharing {
    public static void main(String[] args) {
        Banheiro banheiro = new Banheiro();

        Thread joao = new Thread(new TarefaBanheiro(banheiro, "1"), "joao");
        Thread lucas = new Thread(new TarefaBanheiro(banheiro, "2"), "lucas");
        lucas.setPriority(10);
        new Thread(new TarefaBanheiro(banheiro, "1"), "marcos").start();
        new Thread(new TarefaBanheiro(banheiro, "2"), "josu").start();
        new Thread(new TarefaBanheiro(banheiro, "1"), "car").start();
        new Thread(new TarefaBanheiro(banheiro, "2"), "r").start();
        new Thread(new TarefaBanheiro(banheiro, "2"), "y").start();

        Thread sayo = new Thread(new TarefaBanheiro(banheiro, "3"), "sayo");
        sayo.setDaemon(true);
        lucas.start();
        joao.start();
        sayo.start();

    }
}
