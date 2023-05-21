package org.example.lista;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lista {
    private String[] lista = new String[1000];
    private List<String> listaArrayListSync = Collections.synchronizedList(new ArrayList<>());
    private int indice = 0;

    public void addEl(String i){
   //     System.out.println(Thread.currentThread().getName() + " Tentando adicionar elemento no indice " + i);
        synchronized (this){
            lista[indice] = i;
            indice++;
        }
    }

    public String get(int i){
        return lista[i];
    }

  public  String[] gett(){
        return  this.lista;
    }

}
