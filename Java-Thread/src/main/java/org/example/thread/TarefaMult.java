package org.example.thread;

public class TarefaMult implements Runnable{
    int num = 0;
    @Override
    public void run() {
        for (int i = 0; i < 20000; i++) {
            num = i;
            System.out.println("THREAD --->>>  " + num);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
