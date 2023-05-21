package org.example.thread;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TarefaBuscaTextual implements Runnable {

    String file;
    String nome;
    public TarefaBuscaTextual(String file, String nome) {
        this.file = file;
        this.nome  = nome;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(new File(file));

            while (scanner.hasNext()){
                String linha = scanner.nextLine();
                if (linha.contains(nome)){
                    System.out.println("ECONTRADO ---  ");
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
