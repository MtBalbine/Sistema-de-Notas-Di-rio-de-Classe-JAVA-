# 📚 Sistema de Notas (Diário de Classe)

Este é um projeto acadêmico desenvolvido em Java para simular um Diário de Classe (Sistema de Notas). O sistema permite o cadastro de alunos, gerenciamento de notas com quantidade customizável e a geração de relatórios detalhados com estatísticas da turma.

Este projeto foi desenvolvido como parte da atividade **Lab04 - Sistema de Notas**.

## ✨ Funcionalidades

- **Configuração Dinâmica:** Permite definir o nome da matéria e a quantidade de notas (atividades) que o diário terá logo ao iniciar.
- **Cadastro de Alunos:** Adição de alunos informando Nome e Registro Acadêmico (RA).
- **Lançamento e Modificação de Notas:** Atualização de notas específicas de um aluno com base no índice da atividade.
- **Geração de Relatório de Notas:**
  - Lista todos os alunos, suas respectivas notas e média final.
  - Exibe a **maior nota** e a **menor nota** geral da turma, indicando qual aluno a tirou e em qual atividade.
  - Gera um **Histograma Numérico**, agrupando o desempenho da turma em faixas de notas (0-9, 10-19, ..., 90-100).
- **Tratamento de Erros:** O sistema conta com tratamento de exceções (`InputMismatchException`) para evitar que o programa feche abruptamente caso o usuário digite letras em campos numéricos.

## 🛠️ Tecnologias Utilizadas

- **Java** (JDK 8 ou superior)
- Orientação a Objetos (Classes, Encapsulamento, Associações)
- Estruturas de dados básicas (`List`, `ArrayList`, Arrays nativos)

## 📂 Estrutura do Projeto

O projeto é composto por dois arquivos principais:

1. `Aluno.java`: Classe responsável por armazenar os dados do aluno (nome, RA, array de notas) e calcular a sua média.
2. `Diario.java`: Classe principal que gerencia a lista de alunos, informações da disciplina, impressão dos relatórios e executa o menu interativo no terminal (`main`).

## 🚀 Como Executar

### Pré-requisitos
- Ter o [Java JDK](https://www.oracle.com/br/java/technologies/downloads/) instalado na sua máquina.
- Um terminal (Prompt de Comando, PowerShell, Terminal do Linux/Mac) configurado.

### Passos para compilação e execução

1. Clone este repositório ou baixe os arquivos `Aluno.java` e `Diario.java` para uma pasta no seu computador.
2. Abra o terminal e navegue até a pasta onde os arquivos foram salvos.
3. Compile os arquivos Java com o comando:
   ```bash
   javac Aluno.java Diario.java
