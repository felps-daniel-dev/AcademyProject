package com.academia.app.DAO;

import com.academia.app.Model.Aluno;


import java.sql.*;

import java.util.ArrayList;
import java.util.List;



public class AlunoDAO {

    private static final String url = "jdbc:mysql://localehost:3306/alunos?useTimezone=true&serverTimezone=UTC";
    private static final String usuario = "root";
    private static final String senha = " ";

    public void salvar(Aluno aluno) {
        String sql = "INSERT INTO aluno (nome, cpf, telefone, data_nascimento, data_cadastro) VALUES (?, ?, ?, ?, ?)";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getTelefone());
            stmt.setDate(4, Date.valueOf(aluno.getNascimento()));
            stmt.setDate(5, Date.valueOf(aluno.getDia_cadastro()));

            stmt.executeUpdate();

            System.out.println("Aluno " + aluno.getNome() + " registrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao registrar aluno: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Aluno buscarPorCpf(String cpf) {
        String sql = "SELECT * FROM aluno WHERE cpf = ?";
        Aluno alunoEncontrado = null;

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cpf);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    alunoEncontrado = new Aluno();
                    alunoEncontrado.setIdUsuario(rs.getInt("idusuario"));
                    alunoEncontrado.setNome(rs.getString("nome"));
                    alunoEncontrado.setCpf(rs.getString("cpf"));
                    alunoEncontrado.setTelefone(rs.getString("telefone"));
                    alunoEncontrado.setNascimento(rs.getDate("data_nascimento").toLocalDate());
                    alunoEncontrado.setDia_cadastro(rs.getDate("data_cadastro").toLocalDate());
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar aluno: " + e.getMessage());
            e.printStackTrace();
        }

        return alunoEncontrado;
    }


    // Na sua classe AlunoDAO.java
    public void alterarAluno(Aluno aluno) {
        String sql = "UPDATE aluno SET nome = ?, cpf = ?, telefone = ?, data_nascimento = ?, data_cadastro = ? WHERE idusuario = ?";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            // 1. Seta os novos valores nos placeholders da query
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getTelefone());
            stmt.setDate(4, java.sql.Date.valueOf(aluno.getNascimento()));
            stmt.setDate(5, java.sql.Date.valueOf(aluno.getDia_cadastro()));

            // 2. Seta o ID do aluno no WHERE para que a alteração seja feita apenas nele
            stmt.setInt(6, aluno.getIdUsuario());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Dados do aluno alterados com sucesso!");
            } else {
                System.out.println("Nenhum aluno foi encontrado para alteração.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao alterar aluno: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Aluno> listarTodosAlunos() {
        String sql = "SELECT * FROM aluno";
        List<Aluno> alunos = new ArrayList<>();

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setIdUsuario(rs.getInt("idusuario"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setTelefone(rs.getString("telefone"));
                aluno.setNascimento(rs.getDate("data_nascimento").toLocalDate());
                aluno.setDia_cadastro(rs.getDate("data_cadastro").toLocalDate());
                alunos.add(aluno);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar alunos: " + e.getMessage());
            e.printStackTrace();
        }

        return alunos;
    }
}
