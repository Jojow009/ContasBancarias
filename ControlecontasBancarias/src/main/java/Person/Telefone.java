package Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Telefone extends Pessoa {
    private Long id;
    private Long pessoaId;  // Referência para a pessoa
    private String numero;
    private String tipo; // Exemplo: "Residencial", "Comercial", "Celular"

    // Construtor completo
    public Telefone(Long id, Long pessoaId, String numero, String tipo) {
        this.id = id;
        this.pessoaId = pessoaId;
        this.numero = numero;
        this.tipo = tipo;
    }

    // Construtor vazio
    public Telefone() {
    }

    // Método para ler informações do telefone
    public void ler() {
        System.out.println("ID: " + id);
        System.out.println("Pessoa ID: " + pessoaId);
        System.out.println("Número: " + numero);
        System.out.println("Tipo: " + tipo);
    }

    // Método para gravar telefone no banco de dados
    public void gravar() {
        String sql = this.id == null
                ? "INSERT INTO Telefone (pessoa_id, numero, tipo) VALUES (?, ?, ?)"
                : "UPDATE Telefone SET numero = ?, tipo = ? WHERE id = ?";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            if (this.id == null) {
                stmt.setLong(1, pessoaId);  // Associa o telefone à pessoa
                stmt.setString(2, numero);
                stmt.setString(3, tipo);
            } else {
                stmt.setString(1, numero);
                stmt.setString(2, tipo);
                stmt.setLong(3, id);
            }

            stmt.executeUpdate();

            // Se o telefone foi inserido e o id é nulo, obtém o id gerado
            if (this.id == null) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    this.id = generatedKeys.getLong(1);
                }
            }

            System.out.println("Telefone salvo no banco de dados: ID = " + id);

        } catch (SQLException e) {
            System.err.println("Erro ao gravar Telefone: " + e.getMessage());
        }
    }

    // Método para listar todos os telefones associados a uma pessoa
    public static List<Telefone> listaFone(Long pessoaId) {
        List<Telefone> telefones = new ArrayList<>();
        String sql = "SELECT * FROM Telefone WHERE pessoa_id = ?";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, pessoaId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Telefone telefone = new Telefone(
                        rs.getLong("id"),
                        rs.getLong("pessoa_id"), // Obtém o ID da pessoa associada
                        rs.getString("numero"),
                        rs.getString("tipo")
                );
                telefones.add(telefone);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar telefones: " + e.getMessage());
        }
        return telefones;
    }

    // Método para conectar ao banco de dados
    private static Connection conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/BancoDePessoas";
        String user = "root";
        String password = "senha";
        return DriverManager.getConnection(url, user, password);
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
