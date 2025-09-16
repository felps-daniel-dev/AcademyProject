package com.academia.app.view;

import com.academia.app.DAO.AlunoDAO;
import com.academia.app.Model.Aluno;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import static com.academia.app.Main.*;

public class Menus {

    // objeto para leitura
    private static final Scanner sc = new Scanner(System.in);

    // Esse menu sera incrementado futuramente ao crias os status do aluno e o resto
    //Menu principal
   /* public static void menuPrincipal() {

        int op;
        while (true) {

            System.out.println("|==========> Menu Principal <==========|");
            System.out.println("| -------- Escolha uma opção --------- |");
            System.out.println("| 1 - Alunos                           |");
            System.out.println("| 2 - Planos                           |");
            System.out.println("| 3 - Pagamentos                       |");
            System.out.println("| 4 - Sair                             |");
            System.out.println("| -------------------------------------|");
            System.out.print(" ==> ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    menuAlunos();
                    break;

                    //case 2 : menuPlanos();
                    //break;

                    //case 3 : menuPagamentos();
                    //break;

                case 4:
                    System.exit(0);
            }
        }


    }
*/

    //menu da entidade aluno
    public static void menuAlunos() {
        // objetos para instancias de funçoes
        AlunoDAO alunoDAO = new AlunoDAO();
        Aluno aluno = new Aluno();

        //variavel para a opição
        int op;
        do {
            System.out.println("|==========> Menu de Alunos <==========|");
            System.out.println("| -------- Escolha uma opção --------- |");
            System.out.println("| 1 - Registrar novo Aluno             |");
            System.out.println("| 2 - Buscar Aluno                     |");
            System.out.println("| 3 - Listar todos os Aluno            |");
            System.out.println("| 4 - Altera informaçõe                |");
            System.out.println("| 6 - Voltar                           |");
            System.out.println("| -------------------------------------|");
            System.out.print(" ==> ");
            op = sc.nextInt();

            sc.nextLine();

            switch (op) {

                case 1:
                    registraAluno();
                    break;
                case 2:
                    buscarAluno();
                    break;
                case 3:
                    listarAlunos();
                    break;
                case 4 :
                    alterarAluno();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opção inválida! ");
            }
        }while (op != 4);
    }

    // função para listar alunos
    public static void listarAlunos(){

        System.out.println("----- LISTA DE ALUNOS -----");

        AlunoDAO alunoDAO = new AlunoDAO();
        List<Aluno> alunos = alunoDAO.listarTodosAlunos();

        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno encontrado.");
        } else {
            // define o formato das datas
            DateTimeFormatter formatadorBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            //for each percorre todos os elemntos do objeto do tipo lista
            for (Aluno aluno : alunos) {
                // vai exibir os alunos em uma linha por aluno
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("ID.: " + aluno.getIdUsuario() +
                        "   | Nome.: " + aluno.getNome() +
                        "   | CPF.: " + aluno.getCpf() +
                        "   | Telefone.: " + aluno.getTelefone() +
                        "   | Nascimento.: " + aluno.getNascimento().format(formatadorBR) +
                        "   | Data de cadastro....: " + aluno.getDia_cadastro().format(formatadorBR) +" |");
            }
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Pressione enter pra continuar....");
            sc.nextLine();

        }
    }

    public static void buscarAluno(){

        // objeto para chamar os metodos
        AlunoDAO alunoDAO = new AlunoDAO();

        System.out.print("Insira o CPF  para a busca..: ");
        String cpfBusca = sc.nextLine();

        // busca para o banco de dados (o metodo buscarPorCpf class AlunoDAO - ln39)
        Aluno alunoDaBusca = alunoDAO.buscarPorCpf(cpfBusca);

        if (alunoDaBusca != null){
            System.out.println("|-------Dados do Aluno-------|");
            System.out.println("| Id..................: " + alunoDaBusca.getIdUsuario());
            System.out.println("| CPF.................: " + alunoDaBusca.getCpf());
            System.out.println("| Nome................: " + alunoDaBusca.getNome());
            System.out.println("| Telefone............: " + alunoDaBusca.getTelefone());

            // Formata e exibe a data de nascimento
            DateTimeFormatter formatadorBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String dataFormatada = alunoDaBusca.getNascimento().format(formatadorBR);
            System.out.println("| Data de Nacimento...: " + dataFormatada);

            // Formata e exibe a data de registro do aluno
            String dataRegistroFormatada = alunoDaBusca.getDia_cadastro().format(formatadorBR);
            System.out.println("| Data de Registro....: " + dataRegistroFormatada);

        } else {
            System.out.println("O Aluno com o CPF -> "+ cpfBusca+" não foi encontrado");
        }


    }


    public static void alterarAluno(){

        // objeto para chamar os metodos
        Aluno aluno = new Aluno();
        AlunoDAO alunoDAO = new AlunoDAO();

        Scanner sc = new Scanner(System.in);

        int op = -1;// variavel para organizar as escolhas

        // entrada de dados
        System.out.println("|==========> Alterar Informações do Aluno <==========|");
       do {

           System.out.print("Digite o CPF do aluno que quer alterar...: ");
           String cpfBusca = sc.nextLine();

           Aluno alunoDaBusca = alunoDAO.buscarPorCpf(cpfBusca);

           if (alunoDaBusca != null){

               // exibe dados do aluno
               System.out.println("|-------Dados do Aluno-------|");
               System.out.println("| Id..................: " + alunoDaBusca.getIdUsuario());
               System.out.println("| 1- CPF.................: " + alunoDaBusca.getCpf());
               System.out.println("| 2- Nome................: " + alunoDaBusca.getNome());
               System.out.println("| 3- Telefone............: " + alunoDaBusca.getTelefone());
               // Formata e exibe a data de nascimento
               DateTimeFormatter formatadorBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
               String dataFormatada = alunoDaBusca.getNascimento().format(formatadorBR);
               System.out.println("| 4- Data de Nacimento...: " + dataFormatada);


               // Formata e exibe a data de registro do aluno
               String dataRegistroFormatada = alunoDaBusca.getDia_cadastro().format(formatadorBR);
               System.out.println("| 5- Data de Registro....: " + dataRegistroFormatada);
               System.out.println("| 6- Voltar ");

           }else{
               System.out.println("O aluno com o CPF "+ cpfBusca + " não foi encontrado!");
           }
           int opNovamente = -1;
           do {
               System.out.print(" Selecione qual informação quer alterar...: ");
               op = sc.nextInt();
               sc.nextLine();

               switch (op) {
                   case 1:
                       alterarCpfAluno(alunoDaBusca);
                       break;
                   case 2:
                       alterarNomeAluno(alunoDaBusca);
                       break;
                   case 3:
                       alterarTelefoneAluno(alunoDaBusca);
                       break;
                   case 4:
                       alterarNacimentoAluno(alunoDaBusca);
                       break;
                   case 5:
                       alterarCadastroAluno(alunoDaBusca);
                       break;
                   case 6:
                       opNovamente = 6;
                       break;
               }
           }while(opNovamente != 6);

           System.out.print("Deseja alterar outro aluno? [1-sim   2-não]....: ");
           op = sc.nextInt();

           if (op == 1){
               continue;
           } else if(op == 2){
               return;
           } else{
               System.out.println("Opção inválida!");
           }
       }while(op != 6);


    }



    // Alterações direto que sao chamadas nas opções que chamam a função do DAO////////////////////////////////////
    public static void alterarNomeAluno(Aluno aluno) {
        System.out.print("Novo Nome...: ");
        String novoNome = sc.nextLine();// pega a informação que vai ser alterada
        aluno.setNome(novoNome);//altera o conteudo no objeto

        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.alterarAluno(aluno); // altera o conteudo no banco salvando o objeto que ja foi alterado
        System.out.println("O nome foi alterado com sucesso!");
    }

    public static void alterarCpfAluno(Aluno aluno) {
        System.out.print("Novo CPF...: ");
        String novoCpf = sc.nextLine();
        aluno.setCpf(novoCpf);

        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.alterarAluno(aluno); // O DAO faz o trabalho no banco
        System.out.println("O CPF foi alterado com sucesso!");
    }

    public static void alterarTelefoneAluno(Aluno aluno) {
        System.out.print("Novo Telefone...: ");
        String novoTel = sc.nextLine();
        aluno.setTelefone(novoTel);

        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.alterarAluno(aluno);
        System.out.println("O telefone foi alterado com sucesso!");
    }

    public static void alterarNacimentoAluno(Aluno aluno) {
        System.out.print("Nova data de nacimento...: ");
        LocalDate novoNaci = solicitaDataNascimento(sc, formatadorBR);
        aluno.setNascimento(novoNaci);

        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.alterarAluno(aluno);
        System.out.println("A data de nacimento foi alterado com sucesso!");
    }

    public static void alterarCadastroAluno(Aluno aluno) {
        System.out.print("Nova data de cadastro...: ");
        LocalDate novaDtCadastro = solicitaDataRegistro(sc, formatadorBR);
        aluno.setDia_cadastro(novaDtCadastro);

        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.alterarAluno(aluno);
        System.out.println("O telefone foi alterado com sucesso!");
    }
}



