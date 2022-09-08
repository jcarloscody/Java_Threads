
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

<br/>
<br/>

outra forma...
```
public class ThreadExampleAsync5 {
  static class HelloThread extends Thread {
    @Override public void run() {
      System.out.println("Hello world from thread " + this.getName());
    }
  }
public static void main(String[] args) {
    new HelloThread().start();
    System.out.println("Thread principal: " + Thread.currentThread().getName());
  }
}
```

outra...

```
public class ThreadExampleAsync2 {
 public static void main(String[] args) {
  class HelloParalelo implements Runnable {
    @Override public void run() {
      System.out.println("Hello world paralelo!");
    }
  }
  Thread t1 = new Thread(new HelloParalelo());
  t1.start();
  System.out.println("Thread principal: " + Thread.currentThread().getName());
 }
}
```

outra...

```
public class ThreadExampleAsync3 {
  public static void main(String[] args) {
    Thread t1 = new Thread(new Runnable() {
    @Override public void run() {
      System.out.println("Hello world paralelo!");
    }
    });
    t1.start();
    System.out.println("Thread principal: " + Thread.currentThread().getName());
  }
}
```

outra com lambda...

```
public class ThreadExampleAsync4 {
 public static void main(String[] args) {
  Thread t1 = new Thread(() -> System.out.println("Hello world paralelo!"));
  t1.start();
  System.out.println("Thread principal: " + Thread.currentThread().getName());
 }
}
```
# Controle de threads
- Interrupção de um thread: **interrupt()**
- Pondo um thread para dormir: **Thread.sleep()**
  - Um thread que está ocupando a CPU pode interromper sua execução temporariamente chamando o método estático **Thread.sleep(milissegundos)**


```sh
public class JoinExample {
  public static void main(String[] args) {
    Thread t1 = new Thread(new SimpleDelay(2000));
    t1.start();
    Thread t2 = new Thread(new SimpleDelay(5000));
    t2.start();

    System.out.println("Waiting for " + t1.getName());
    try {
      t1.join();
    } catch (InterruptedException e) { ... }
    System.out.println("Waiting for " + t2.getName());
    try {
      t2.join();
    } catch (InterruptedException e) { ... }
    System.out.println("Thread main is DONE!"); 
  }
}

```

# Comunicação entre threads e acesso exclusivo

> Threads podem rodar paralelamente em uma única CPU (disputando slots de tempo alocados pelo sistema operacional) ou em CPUs diferentes executando ao mesmo tempo. Uma sequência de instruções que executa no mesmo thread é sempre sequencial, mas se dois ou mais threads têm acesso compartilhado aos mesmos dados, os resultados finais poderão ser inconsistentes.

### Thread safety
> Thread-safety é uma característica que representa a imunidade de um componente a problemas
que podem surgir quando ele é usado em ambiente concorrente. Uma classe é thread-safe se
continua a funcionar corretamente quando acessada por múltiplos threads.

```
Se uma variável pode ser acessada por múltiplos threads e não for imutável ela precisa usar sincronização sempre que for acessada, pois é necessário coordenar o acesso caso mais de um
thread tentar mudar seu valor. Em Java há vários mecanismos nativos de sincronização: exclusão
mútua (com a palavra-chave synchronized), sincronização de visibilidade (com a palavra-chave
volatile). Há também uma API que fornece travas explícitas, sincronizadores e variáveis atômicas.
```

### Synchronized
> Em Java a exclusão mútua pode ser obtida usando um bloco synchronized: um mecanismo que
obtém uma trava exclusiva para um objeto, impedindo que ele seja acessível por outros threads
enquanto um thread estiver executando o conteúdo do bloco.

<img src="https://raw.githubusercontent.com/jcarloscody/Java_Threads/main/img/synchronized.PNG">

> Um bloco synchronized deve ser usado para garantir que um trecho de código produza
resultados previsíveis independente de ser executado por um único thread ou simultaneamente por
muitos. 