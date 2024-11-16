package Person;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Localidade extends Pessoa  {
    private Long id;
    private Long cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String logradouro;

    // Construtor
    public Localidade(Long id, Long cep, String estado, String cidade, String bairro, String logradouro) {
        this.id = id;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
    }

    // Construtor vazio
    public Localidade() {}

    // Ler Localidade
    public void ler() {
        System.out.println("ID: " + id);
        System.out.println("CEP: " + cep);
        System.out.println("Estado: " + estado);
        System.out.println("Cidade: " + cidade);
        System.out.println("Bairro: " + bairro);
        System.out.println("Logradouro: " + logradouro);
    }

    // Gravar Localidade no banco de dados
    public void gravar() {
        String sql = this.id == null
                ? "INSERT INTO Localidade (cep, estado, cidade, bairro, logradouro) VALUES (?, ?, ?, ?, ?)"
                : "UPDATE Localidade SET cep = ?, estado = ?, cidade = ?, bairro = ?, logradouro = ? WHERE id = ?";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setLong(1, cep);
            stmt.setString(2, estado);
            stmt.setString(3, cidade);
            stmt.setString(4, bairro);
            stmt.setString(5, logradouro);

            if (this.id != null) {
                stmt.setLong(6, id);  // Para atualizar
            }

            stmt.executeUpdate();

            // Se for uma nova localidade, pega o ID gerado
            if (this.id == null) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    this.id = generatedKeys.getLong(1);
                }
            }

            System.out.println("Localidade salva no banco de dados: ID = " + id);

        } catch (SQLException e) {
            System.err.println("Erro ao gravar Localidade: " + e.getMessage());
        }
    }

    // Buscar Localidade pelo ID
    public static Localidade buscar(Long id) {
        String sql = "SELECT * FROM Localidade WHERE id = ?";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Localidade localidade = new Localidade(
                        rs.getLong("id"),
                        rs.getLong("cep"),
                        rs.getString("estado"),
                        rs.getString("cidade"),
                        rs.getString("bairro"),
                        rs.getString("logradouro")
                );
                return localidade;
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar Localidade: " + e.getMessage());
        }
        return null;
    }

    // Listar todas as localidades
    public static List<Localidade> listar() {
        List<Localidade> localidades = new ArrayList<>();
        String sql = "SELECT * FROM Localidade";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Localidade localidade = new Localidade(
                        rs.getLong("id"),
                        rs.getLong("cep"),
                        rs.getString("estado"),
                        rs.getString("cidade"),
                        rs.getString("bairro"),
                        rs.getString("logradouro")
                );
                localidades.add(localidade);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar Localidades: " + e.getMessage());
        }
        return localidades;
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

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
}
