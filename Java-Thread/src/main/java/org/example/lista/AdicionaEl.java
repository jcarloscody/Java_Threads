package org.example.lista;

public class AdicionaEl implements Runnable {
    private  Lista lista;

    public AdicionaEl(Lista lista) {
        this.lista = lista;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            lista.addEl("Thread nome " + Thread.currentThread().getName());
        }
    }
}
