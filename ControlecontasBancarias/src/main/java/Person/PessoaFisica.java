package Person;



import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PessoaFisica extends Pessoa {
    private Long cpf;
    private String nome;
    private Date dtNasc;
    private int sexo; // 1: Masculino, 2: Feminino, 3: Outro

    // Construtor completo
    public PessoaFisica(Long id, Long cep, int numero, String complemento, Long cpf, String nome, Date dtNasc, int sexo) {
        super(id, cep, numero, complemento);
        this.cpf = cpf;
        this.nome = nome;
        this.dtNasc = dtNasc;
        this.sexo = sexo;
    }

    // Construtor vazio
    public PessoaFisica() {
        super();
    }

    // Ler informações da pessoa física
    public void ler() {
        super.ler();
        System.out.println("CPF: " + cpf);
        System.out.println("Nome: " + nome);
        System.out.println("Data de Nascimento: " + dtNasc);
        System.out.println("Sexo: " + (sexo == 1 ? "Masculino" : sexo == 2 ? "Feminino" : "Outro"));
    }

    // Salvar no banco de dados
    public void gravar() {
        String sql = this.getId() == null
                ? "INSERT INTO PessoaFisica (cpf, nome, dt_nasc, sexo, cep, numero, complemento, situacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
                : "UPDATE PessoaFisica SET cpf = ?, nome = ?, dt_nasc = ?, sexo = ?, cep = ?, numero = ?, complemento = ?, situacao = ? WHERE id = ?";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setLong(1, cpf);
            stmt.setString(2, nome);
            stmt.setDate(3, new java.sql.Date(dtNasc.getTime()));
            stmt.setInt(4, sexo);
            stmt.setLong(5, getCep());
            stmt.setInt(6, getNumero());
            stmt.setString(7, getComplemento());
            stmt.setInt(8, getSituacao());

            if (this.getId() != null) {
                stmt.setLong(9, getId());
            }

            stmt.executeUpdate();

            if (this.getId() == null) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    this.setId(generatedKeys.getLong(1));
                }
            }

            System.out.println("Pessoa Física salva no banco de dados: ID = " + getId());

        } catch (SQLException e) {
            System.err.println("Erro ao gravar Pessoa Física: " + e.getMessage());
        }
    }


    // Listar todas as pessoas físicas do banco de dados
    public static List<PessoaFisica> listagem() {
        List<PessoaFisica> pessoasFisicas = new ArrayList<>();
        String sql = "SELECT * FROM PessoaFisica";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/BancoDePessoas", "root", "senha"); // Ajuste usuário/senha
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                PessoaFisica pessoaFisica = new PessoaFisica(
                        rs.getLong("id"),
                        rs.getLong("cep"),
                        rs.getInt("numero"),
                        rs.getString("complemento"),
                        rs.getLong("cpf"),
                        rs.getString("nome"),
                        rs.getDate("dt_nasc"),
                        rs.getInt("sexo")
                );
                pessoasFisicas.add(pessoaFisica);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar pessoas físicas: " + e.getMessage());
        }
        return pessoasFisicas;
    }

    // Método de conexão com o banco de dados
    private Connection conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/BancoDePessoas";
        String user = "root";
        String password = "senha";
        return DriverManager.getConnection(url, user, password);
    }

    // Getters e Setters
    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Date dtNasc) {
        this.dtNasc = dtNasc;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }
}
