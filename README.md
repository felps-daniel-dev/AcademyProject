# Sistema de Gestão de Academia - Versão 1.0

Este projeto é um protótipo de um sistema de gestão para academias de artes marciais, desenvolvido em Java. A aplicação foi criada para ajudar a gerenciar o cadastro de alunos, planos de pagamento e o controle de mensalidades de forma simples e eficiente.

A versão atual funciona via linha de comando (console) e serve como a fundação para futuras evoluções.

---

## Funcionalidades Atuais

* Cadastro de Alunos: Permite o registro de novos alunos com informações como nome, CPF, telefone e data de nascimento.
* Busca de Alunos: Permite buscar um aluno específico pelo CPF e visualizar seus dados.
* Alteração de Dados: Permite alterar dados de um aluno existente (como nome e telefone) no banco de dados.
* Listagem de Alunos: Exibe uma lista completa de todos os alunos cadastrados.
* Persistência de Dados: Todos os dados são salvos em um banco de dados MySQL para garantir que não se percam após o encerramento da aplicação.

---

## Próximas Etapas e Futuras Versões

* Interface Gráfica (GUI): A interface atual de linha de comando será substituída por uma interface gráfica mais amigável, facilitando o uso para o usuário final.
* Gestão de Planos e Pagamentos: Implementação de funcionalidades para registrar e controlar os planos de treino contratados por cada aluno.
* Controle de Vencimento: O sistema terá a capacidade de verificar e exibir automaticamente os alunos cujos planos estão prestes a vencer ou já venceram, com base na data de pagamento.

---

## Tecnologias Utilizadas

* **Linguagem:** [Java]
* **Banco de Dados:** [MySQL]
* **Conectividade:** [JDBC]
* **Gerenciador de Dependências:**[Maven]

---

## Como Executar o Projeto

1. Clone este repositório para a sua máquina.

2. Certifique-se de que o Java Development Kit (JDK) e o MySQL estão instalados e configurados em seu ambiente.

3. Rode o script SQL alunos_db.sql (ou o script CREATE TABLE que você criou) no seu MySQL Workbench para criar o banco de dados e as tabelas necessárias.

4. Abra o projeto na sua IDE (IntelliJ IDEA, por exemplo).

5. Configure as credenciais do seu banco de dados na classe AlunoDAO.java (o usuário, a senha e a URL).

6. Execute a classe Main.java.

## Observação 

 ** Esta aplicação foi meu primeiro projeto ultilizando JDBC. Serviu de grande apredizado e exploração de ferramentas

---

## Contato

* [Felipe Daniel da Silva](https://github.com/felps-daniel-dev/)
