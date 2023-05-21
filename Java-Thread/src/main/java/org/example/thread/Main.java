package org.example.thread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");

        Thread calcular = new Thread(new TarefaMult());
        calcular.start();

        String nome = "josue";
        Thread busca1 = new Thread(new TarefaBuscaTextual("C:\\Users\\JOSUE\\OneDrive\\Documentos\\Repositories\\Studing\\Java-Thread\\Java-Thread\\src\\main\\java\\assinatura1.txt", nome));
        busca1.start();
        System.out.println(calcular.getId());
        
        
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
            Thread.sleep(1000);

        }

        
    }
}