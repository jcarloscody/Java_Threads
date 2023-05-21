package org.example.recursosComum;

public class TarefaBanheiro implements Runnable {
    private  String tipo;
    private  Banheiro banheiro;

    public TarefaBanheiro(Banheiro banheiro, String tipo) {
       this.banheiro = banheiro;
       this.tipo = tipo;
    }

    @Override
    public void run() {
if (tipo.equals("1")){
    try {
        banheiro.n1();
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }

}

        if (tipo.equals("2")){
            try {
                banheiro.n2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        if (tipo.equals("3")){
            while (true){
                try {
                    banheiro.limpa();
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
}
