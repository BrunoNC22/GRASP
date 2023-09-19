# Aplicação de Resolução do Problema da Mochila Binária com a Metaheurística GRASP

Este projeto Java tem como objetivo resolver o clássico Problema da Mochila Binária, um problema de otimização combinatória, utilizando a metaheurística GRASP (Greedy Randomized Adaptive Search Procedure). O código é composto por várias classes que desempenham papéis específicos na resolução do problema.

## Estrutura do Projeto

### Classe `Item`

A classe `Item` representa um item que pode ou não ser colocado na mochila binária. Cada item possui três atributos:

- `peso` (int): O peso do item.
- `valor` (float): O valor do item.
- `alocado` (boolean): Indica se o item está alocado na mochila.

### Classe `Mochila`

A classe `Mochila` representa a mochila binária em que os itens serão alocados. Ela inclui os seguintes atributos:

- `capacidade` (int): A capacidade máxima de peso que a mochila pode conter.
- `valorTotal` (float): O valor total dos itens alocados na mochila.
- `pesoAtual` (float): O peso total dos itens alocados na mochila.
- `itens` (Set<Item>): Um conjunto de itens alocados na mochila.

### Classe `ArchiveReader`

A classe `ArchiveReader` é uma classe auxiliar para ler dados de um arquivo. Ela lê a capacidade da mochila e informações dos itens a partir de um arquivo de entrada.

### Classe `Main`

A classe `Main` é a classe principal do projeto. Ela realiza as seguintes ações:

- Lê os dados do arquivo de entrada usando a classe `ArchiveReader`.
- Executa a metaheurística GRASP para alocar os itens na mochila, maximizando o valor total e respeitando a capacidade máxima.
- Exibe os itens alocados na mochila, juntamente com seu valor total e peso total.

## Metaheurística GRASP

A abordagem principal deste projeto é a aplicação da metaheurística GRASP para resolver o Problema da Mochila Binária. Aqui estão os principais pontos sobre a metaheurística GRASP:

- **Construção Aleatória Gulosa**: A função `construcaoAleatoriaGulosa` é responsável por construir uma solução inicial de maneira aleatória e gulosa. Ela seleciona itens com base na relação valor/peso, considerando um parâmetro ajustável chamado `alpha`. Itens que têm uma relação maior ou igual a `alpha` são considerados candidatos.

- **Iterações GRASP**: A função `graspMochila` executa várias iterações da metaheurística GRASP, procurando alocar itens de forma a maximizar o valor total dentro da capacidade da mochila. A melhor solução encontrada é armazenada e retornada.

## Executando o Projeto

Para a execução do projeto:

1. Certifique-se de que o arquivo de entrada esteja presente e contenha os dados necessários no formato correto.

2. Execute a classe `Main`. Ela lerá os dados do arquivo, aplicará a metaheurística GRASP e exibirá os resultados na saída.

3. Experimente diferentes valores de `alpha` e iterações para ajustar o comportamento do GRASP.