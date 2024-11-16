package Conections;

import Person.Pessoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySql{

    // Conexão com o Banco de Dados
    private static final String URL = "jdbc:mysql://localhost:3306/BancoDePessoas";
    private static final String USER = "root";
    private static final String PASSWORD = "senha";

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Adicionar Pessoa
    public void gravarPessoa(Pessoa pessoa) {
        String sql = "INSERT INTO Pessoa (cep, numero, complemento, situacao) VALUES (?, ?, ?, ?)";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setLong(1, pessoa.getCep());
            stmt.setInt(2, pessoa.getNumero());
            stmt.setString(3, pessoa.getComplemento());
            stmt.setInt(4, pessoa.getSituacao());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                pessoa.setId(generatedKeys.getLong(1));
            }

            System.out.println("Pessoa adicionada com sucesso: ID = " + pessoa.getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Ler Pessoa
    public Pessoa lerPessoa(Long id) {
        String sql = "SELECT * FROM Pessoa WHERE id = ?";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Pessoa pessoa = new Pessoa(
                        rs.getLong("id"),
                        rs.getLong("cep"),
                        rs.getInt("numero"),
                        rs.getString("complemento")
                );
                pessoa.setSituacao(rs.getInt("situacao"));
                return pessoa;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Remover Pessoa
    public void removerPessoa(Long id) {
        String sql = "DELETE FROM Pessoa WHERE id = ?";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pessoa removida com sucesso: ID = " + id);
            } else {
                System.out.println("Nenhuma pessoa encontrada com o ID: " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar Pessoas
    public List<Pessoa> listarPessoas() {
        String sql = "SELECT * FROM Pessoa";
        List<Pessoa> pessoas = new ArrayList<>();

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pessoa pessoa = new Pessoa(
                        rs.getLong("id"),
                        rs.getLong("cep"),
                        rs.getInt("numero"),
                        rs.getString("complemento")
                );
                pessoa.setSituacao(rs.getInt("situacao"));
                pessoas.add(pessoa);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pessoas;
    }

    // Adicionar Telefone
    public void adicionarTelefone(Long pessoaId, String telefone) {
        String sql = "INSERT INTO Telefone (pessoa_id, numero) VALUES (?, ?)";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, pessoaId);
            stmt.setString(2, telefone);
            stmt.executeUpdate();

            System.out.println("Telefone adicionado: " + telefone);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Remover Telefone
    public void removerTelefone(Long pessoaId, String telefone) {
        String sql = "DELETE FROM Telefone WHERE pessoa_id = ? AND numero = ?";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, pessoaId);
            stmt.setString(2, telefone);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Telefone removido: " + telefone);
            } else {
                System.out.println("Telefone não encontrado: " + telefone);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}