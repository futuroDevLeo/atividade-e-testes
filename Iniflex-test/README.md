# Iniflex Test

Este projeto é um exemplo de aplicação Java que gerencia uma lista de funcionários, aplicando aumentos salariais, agrupando-os por função, e realizando outras operações como impressão de aniversariantes e cálculo de salários mínimos.

## Estrutura do Projeto

O projeto contém os seguintes arquivos principais:

- `src/App.java`: Contém a lógica principal do programa.
- `src/Funcionario.java`: Define a classe `Funcionario` que herda de `Pessoa`.
- `src/Pessoa.java`: Define a classe `Pessoa`.

## Funcionalidades

### Adicionar Funcionários

Os funcionários são adicionados à lista `funcionarios` na inicialização da classe `App`.

### Remover Funcionário

O funcionário "João" é removido da lista no método `main`.

### Aplicar Aumento

O método `aplicarAumento` aplica um aumento percentual ao salário de todos os funcionários.

### Imprimir Funcionários

O método `printFuncionarios` imprime todos os funcionários com suas informações formatadas.

### Agrupar por Função

O método `agruparPorFuncao` agrupa os funcionários por função e retorna um mapa.

### Imprimir Funcionários por Função

O método `printFuncionariosPorFuncao` imprime os funcionários agrupados por função.

### Imprimir Aniversariantes

O método `printAniversariantes` imprime os funcionários que fazem aniversário nos meses especificados.

### Imprimir Funcionário Mais Velho

O método `printFuncionarioMaisVelho` imprime o funcionário com a maior idade.

### Imprimir Funcionários em Ordem Alfabética

O método `printFuncionariosOrdemAlfabetica` imprime os funcionários em ordem alfabética.

### Imprimir Total dos Salários

O método `printTotalSalarios` imprime o total dos salários de todos os funcionários.

### Imprimir Salários em Salários Mínimos

O método `printSalariosMinimos` imprime quantos salários mínimos cada funcionário ganha.

## Estrutura de Pastas

O workspace contém as seguintes pastas por padrão:

- `src`: Pasta que contém os arquivos fonte.
- `lib`: Pasta que contém as dependências.

Os arquivos compilados serão gerados na pasta `bin` por padrão.

> Se você quiser personalizar a estrutura de pastas, abra `.vscode/settings.json` e atualize as configurações relacionadas.

## Gerenciamento de Dependências

A visualização `JAVA PROJECTS` permite que você gerencie suas dependências. Mais detalhes podem ser encontrados [aqui](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## Executando o Projeto

Para compilar e executar o projeto, siga os passos abaixo:

1. **Abrir o terminal integrado**:
   - Você pode abrir o terminal integrado no Visual Studio Code pressionando Ctrl + (crase) ou navegando até `Terminal > New Terminal` no menu superior.

2. **Compilar o código**:
   - Compile o código Java usando o comando `javac`. Execute o seguinte comando no terminal:
     ```sh
     javac -d bin src/*.java
     ```

3. **Executar o código**:
   - Após a compilação bem-sucedida, execute o seguinte comando no terminal:
     ```sh
     java -cp bin App
     ```

Isso deve compilar e executar o seu projeto, permitindo que você veja a saída no terminal integrado do Visual Studio Code.
