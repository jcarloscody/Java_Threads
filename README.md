p2
> **THREAD**
- **fio - linha** -, é portanto uma **linha contínua de execução**, uma sequência de instruções que pode, potencialmente, executar em paralelo com outros threads.
- Apesar de ser uma sequência contínua, um thread não precisa executar inteiro de uma vez. Ele pode ser interrompido quantas vezes for necessário, sempre continuando do ponto onde parou.

> **FORMAS**

<img src="https://raw.githubusercontent.com/jcarloscody/Java_Threads/main/img/formasthreads.PNG">

- **`exclusiva`**: único programa executando em uma CPU
- **`concorrente`**: sendo constantemente interrompido para revezar a CPU com outros programas
- **`paralela`**: ocupando uma CPU em um sistema com múltiplos processadores, e executando simultaneamente com outros programas, sem interrupções.
  - A execução paralela `só é possível` em sistemas que possuem **múltiplas unidades de processamento** (CPUs). Isto ocorre em computadores que têm **mais de um processador** (múltiplos chips), ou em processadores que disponibilizam **mais de um núcleo** (core) de processamento.
  - Para o sistema operacional, é comum o nível de paralelismo aparecer dobrado, devido à tecnologia de hyper-threading empregada pela maior parte dos
processadores que simula 2 CPUs para cada core. Portanto, em um computador quad-core (com 4
CPUs físicas) o sistema enxerga 8 CPUs lógicas.

<br/>
<br/>

#  Fundamentos de threads em Java
## Class Thread
-  Qualquer programa em Java possui pelo **menos um thread**, que é a sequência de instruções que começa e termina no método main() da aplicação.
-  classe java.lang.Thread
```
Thread principal = Thread.currentThread();
System.out.println("Nome do thread: " + principal.getName());
System.out.println("Thread toString(): " + principal);
```

## A interface Runnable
- A partir do thread main, podemos criar outros threads. Esses threads irão rodar em paralelo ou disputar a CPU com o thread principal.
-  para executar threads novos, é preciso criar uma classe que implemente a interface **java.lang.Runnable**
-  interface funcional
```
public class RunnableHelloWorld implements Runnable {
 @Override
 public void run() {
    System.out.println("Hello world paralelo!");
    System.out.println("Eu sou o thread: " + Thread.currentThread ().getName());
 }
}
```
- O método run() acima tem o mesmo papel que o main() em uma classe Java executável: ele contém o código que será chamado quando um thread for iniciado. 

```
public class ThreadExampleSync {
 public static void main(String[] args) {
      Runnable paralelo = new RunnableHelloWorld();
      Thread t1 = new Thread(paralelo);
      t1.start();
      System.out.println("Thread principal: " + Thread.currentThread().getName());
 }
}
```

<img src="https://raw.githubusercontent.com/jcarloscody/Java_Threads/main/img/threads.PNG">


pag 20