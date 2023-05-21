package org.example.lista;

public class Prin {

    public static void main(String[] args) throws InterruptedException {
        Lista lista = new Lista();
        for (int i = 0; i < 100; i++) {
            new Thread(new AdicionaEl(lista), "lista " + i).start();
        }

        Thread.sleep(5000);

        for (int i = 0; i < lista.gett().length; i++) {
            System.out.println(lista.get(i));
        }
    }
}
