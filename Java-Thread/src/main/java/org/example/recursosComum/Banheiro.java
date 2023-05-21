package org.example.recursosComum;

public class Banheiro {

    private boolean sujo = true;

    void n1() throws InterruptedException {
        String nome = Thread.currentThread().getName();
        System.out.println(nome + " solicitando entrada");
        synchronized (this){
            System.out.println(nome + " entrou");
            while (sujo){
                this.espereFora();
            }
            System.out.println(nome + " fazendo numero 1");
            System.out.println(nome + " lavou as maos");
            Thread.sleep(5000);
            System.out.println(nome + " saiu");
            sujo=true;
        }
    }

    void espereFora() throws InterruptedException {
      synchronized (this ){
          String nome = Thread.currentThread().getName();
          System.out.println(nome + " Saiu pq estava sujo agora está Esperando do lado de fora");
          this.wait();
      }
    }

    public void limpa() throws InterruptedException {
        synchronized (this ){
            System.out.println(Thread.currentThread().getName() + " entrando para limpar o banheiro");
            this.sujo = false;
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " limpou o banheiro");
            this.notifyAll();

        }

    }


    void n2() throws InterruptedException {
        String nome = Thread.currentThread().getName();
        System.out.println(nome + " solicitando entrada");
        synchronized (this){
            System.out.println(nome + " entrou");
            while (sujo){
                this.espereFora();
            }

                System.out.println(nome + " fazendo numero 2");
                Thread.sleep(8000);
            System.out.println(nome + " lavou as maos");
            System.out.println(nome + " saiu");
            sujo=true;

        }

    }
}
