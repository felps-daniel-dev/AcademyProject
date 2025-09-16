package com.academia.app;

import com.academia.app.DAO.AlunoDAO;
import com.academia.app.Model.Aluno;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import static com.academia.app.view.Menus.menuAlunos;

public class Main {
    //objeto de leitura
    private static final Scanner sc = new Scanner(System.in);

    // definindo um formatador global
    public static final DateTimeFormatter formatadorBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    // INICIO DO PROGRAMA ///////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {

        // objeto para instanciar os menus
        Menu menus = new Menu();

        menuAlunos();}

    // metodo de registro de um novo aluno
    public static void registraAluno() {
        System.out.println("-=====> CADASTRAR ALUNO <=====-");

        System.out.print(" NOME.....: ");
        String nome = sc.nextLine();



        System.out.print(" CPF......: ");
        String cpf = sc.nextLine();

        System.out.print(" TELEFONE.: ");
        String telefone = sc.nextLine();

        LocalDate nascimento = solicitaDataNascimento(sc, formatadorBR);

        // registro do dia de cadastro
        LocalDate dia_cadastro = LocalDate.now();

        Aluno novoAluno = new Aluno(
                nome,
                cpf,
                telefone,
                nascimento,
                dia_cadastro
        );

        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.salvar(novoAluno);
    }

    // metodo recebe  a entrada e formata para a data de nascimento verificando se esta correta e formata
    public static LocalDate solicitaDataNascimento(Scanner sc, DateTimeFormatter formatador) {
        LocalDate nascimento = null;
        boolean dataValida = false;

        System.out.print(" DATA DE NASCIMENTO...: ");
        while (!dataValida) {
            String entradaData = sc.nextLine();
            try {
                nascimento = LocalDate.parse(entradaData, formatador);
                dataValida = true;
            } catch (DateTimeParseException e) {
                System.out.print("Formato de data inválido. Use o formato dd/MM/yyyy: ");
            }
        }
        return nascimento;
    }



    // metodo recebe  a entrada e formata para a data de cadastro verificando se esta correta e formata
    public static LocalDate solicitaDataRegistro(Scanner sc, DateTimeFormatter formatador) {
        LocalDate registro = null;
        boolean dataValida = false;

        System.out.print(" DATA DE REGISTRO...: ");
        while (!dataValida) {
            String entradaData = sc.nextLine();
            try {
                registro = LocalDate.parse(entradaData, formatador);
                dataValida = true;
            } catch (DateTimeParseException e) {
                System.out.print("Formato de data inválido. Use o formato dd/MM/yyyy: ");
            }
        }
        return registro;
    }
}