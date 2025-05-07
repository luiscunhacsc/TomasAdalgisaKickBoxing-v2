# Kickboxing Fighter Ranker

Este projeto é um exemplo didático de Programação Orientada a Objetos (POO) em Java, utilizando Maven. Ele permite buscar lutadores de kickboxing através de uma API, e foi especialmente preparado para demonstrar todos os principais conceitos de OOP de forma prática e comentada para fins de estudo e defesa acadêmica.

---

## Estrutura do Projeto

```
src/
 └── main/
     └── java/
         └── com/
             └── tomas/
                 └── kickboxing/
                     ├── Main.java
                     ├── api/
                     │    └── ApiSportsClient.java
                     ├── model/
                     │    └── Fighter.java
                     └── service/
                          └── RankingService.java
```

---

## Conceitos de POO Demonstrados

### 1. **Classes e Objetos**
- O projeto possui várias classes: `Fighter`, `ApiSportsClient`, `RankingService`, `Main`.
- Objetos são instanciados no código, por exemplo: `Fighter f = new Fighter(...);`.

### 2. **Encapsulamento**
- Os atributos das classes são privados e acessados por métodos públicos (getters/setters).

### 3. **Construtores**
- Classes como `Fighter` possuem construtores para inicializar seus atributos.

### 4. **Herança**
- Pode ser demonstrada criando uma classe abstrata ou interface (ver sugestões no fim do README).

### 5. **Polimorfismo**
- Pode ser demonstrado sobrescrevendo o método `toString()` em `Fighter` e usando listas de objetos.

### 6. **Composição**
- Se desejar, pode criar uma classe `Team` e adicionar como atributo em `Fighter` para mostrar composição.

### 7. **Interfaces**
- Pode ser criada uma interface `Person` para ser implementada por `Fighter`.

### 8. **Classes Abstratas**
- Pode ser criada uma classe abstrata `Athlete` para ser herdada por `Fighter`.

### 9. **Coleções e Estruturas de Dados**
- Uso de `List<Fighter>` para manipular múltiplos lutadores.

### 10. **Tratamento de Exceções**
- Uso de `try/catch` para capturar e tratar erros de execução, especialmente acesso à API.

---

## Como Executar

### Pré-requisitos
- Java 17 ou superior
- Maven 3.8+

### Passos

1. **Clone o repositório:**
   ```sh
   git clone <URL_DO_REPOSITORIO>
   cd TomasAdalgisaKickBoxing-main
   ```
2. **Compile o projeto:**
   ```sh
   mvn clean package
   ```
3. **Execute o programa:**
   ```sh
   mvn exec:java -Dexec.mainClass="com.tomas.kickboxing.Main"
   ```
4. **Digite o nome (ou parte do nome) de um lutador quando solicitado.**

---

## Exemplo de Uso

```
=== Kickboxing Fighter Ranker ===
Digite o nome (ou parte do nome) do lutador: Silva

Ranking:
1. Anderson Silva ("The Spider")
  Idade: 45
  Altura: 1.88  Peso: 84kg  Alcance: 197cm
  Categoria: Middleweight  Equipe: Black House
  Stance: Southpaw
  Última atualização: 2024-01-01
```

---

## Explicações Didáticas para a Defesa

- **Classes e Objetos:** Cada arquivo `.java` define uma classe, e objetos são instanciados no `Main` e em outros pontos do código.
- **Encapsulamento:** Os atributos das classes são privados, acessados por métodos públicos.
- **Construtores:** `Fighter` tem um construtor que inicializa todos os atributos.
- **Herança e Polimorfismo:** Podem ser facilmente adicionados criando uma classe abstrata/interface e sobrescrevendo métodos.
- **Composição:** Pode ser demonstrada adicionando um atributo do tipo `Team` em `Fighter`.
- **Coleções:** Uso de `List<Fighter>` para manipular vários lutadores.
- **Tratamento de Exceções:** Uso de `try/catch` no `Main` para lidar com erros de API.

### Sugestão para ampliar o projeto e demonstrar todos os conceitos:
- Criar uma interface `Person` e uma classe abstrata `Athlete`.
- Fazer `Fighter` herdar de `Athlete` e implementar `Person`.
- Criar uma classe `Team` e usar como atributo em `Fighter` (composição).
- Adicionar comentários detalhados em cada classe e método explicando o conceito de OOP aplicado.

---

## Possíveis Perguntas de Banca

- Qual a diferença entre herança e composição?
- Por que atributos são privados?
- Explique o conceito de polimorfismo presente no código.
- Como garantir que todos os atletas tenham nome e idade?
- Por que usar interface se já existe uma classe abstrata?
- Como o tratamento de exceções melhora a robustez do sistema?
- Como seria fácil adicionar um novo tipo de atleta ao sistema?
- Como a estrutura de pacotes ajuda na organização do projeto?

---

## Dicas para a Defesa

- Mostre o código comentado em cada conceito.
- Explique a motivação para cada escolha de design.
- Dê exemplos de extensibilidade (adicionar novos esportes, times, etc).
- Mostre a robustez do sistema ao tratar falhas de API.
- Destaque a clareza e organização do código.

---

## Contato

Dúvidas ou sugestões? Fale com [Seu Nome] em [seu.email@dominio.com].

---

# Comentários didáticos sugeridos para o código

> **Adicione comentários como estes nos arquivos do projeto para mostrar os conceitos de OOP:**

## Exemplo em Fighter.java
```java
// Classe Fighter representa um lutador (Exemplo de Classe e Objeto)
public class Fighter {
    // Encapsulamento: atributos privados
    private int id;
    private String name;
    ...

    // Construtor: inicializa os atributos
    public Fighter(...) {
        ...
    }

    // Métodos públicos (getters)
    public int getId() { return id; }
    ...

    // Polimorfismo: sobrescrita do método toString()
    @Override
    public String toString() {
        ...
    }
}
```

## Exemplo em Main.java
```java
public class Main {
    public static void main(String[] args) {
        // Instanciação de objetos
        Scanner scanner = new Scanner(System.in);
        ApiSportsClient apiClient = new ApiSportsClient();
        RankingService rankingService = new RankingService();
        ...
        // Coleção de objetos
        List<Fighter> fighters = apiClient.getFighters(search);
        ...
        // Tratamento de Exceções
        try {
            ...
        } catch (Exception e) {
            ...
        }
    }
}
```

Se quiser exemplos prontos para interfaces, classes abstratas ou composição, peça que eu gero para você!
