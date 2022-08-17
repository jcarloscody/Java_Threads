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

pag 17