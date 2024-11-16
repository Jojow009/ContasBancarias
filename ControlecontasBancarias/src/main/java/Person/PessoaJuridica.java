package Person;


    import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class PessoaJuridica extends Pessoa {
        private Long cnpj;
        private String razaoSocial;
        private String nomeFantasia;
        private String inscrEstadual;

        // Construtor completo
        public PessoaJuridica(Long id, Long cep, int numero, String complemento, Long cnpj, String razaoSocial, String nomeFantasia, String inscrEstadual) {
            super(id, cep, numero, complemento);
            this.cnpj = cnpj;
            this.razaoSocial = razaoSocial;
            this.nomeFantasia = nomeFantasia;
            this.inscrEstadual = inscrEstadual;
        }

        // Construtor vazio
        public PessoaJuridica() {
            super();
        }

        // Ler informações da pessoa jurídica
        public void ler() {
            super.ler();
            System.out.println("CNPJ: " + cnpj);
            System.out.println("Razão Social: " + razaoSocial);
            System.out.println("Nome Fantasia: " + nomeFantasia);
            System.out.println("Inscrição Estadual: " + inscrEstadual);
        }

        // Salvar no banco de dados
        public void gravar() {
            String sql = this.getId() == null
                    ? "INSERT INTO PessoaJuridica (cnpj, razao_social, nome_fantasia, inscr_estadual, cep, numero, complemento, situacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
                    : "UPDATE PessoaJuridica SET cnpj = ?, razao_social = ?, nome_fantasia = ?, inscr_estadual = ?, cep = ?, numero = ?, complemento = ?, situacao = ? WHERE id = ?";
            try (Connection conn = conectar();
                 PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                stmt.setLong(1, cnpj);
                stmt.setString(2, razaoSocial);
                stmt.setString(3, nomeFantasia);
                stmt.setString(4, inscrEstadual);
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

                System.out.println("Pessoa Jurídica salva no banco de dados: ID = " + getId());

            } catch (SQLException e) {
                System.err.println("Erro ao gravar Pessoa Jurídica: " + e.getMessage());
            }
        }


        // Listar todas as pessoas jurídicas do banco de dados
        public static List<PessoaJuridica> listagem() {
            List<PessoaJuridica> pessoasJuridicas = new ArrayList<>();
            String sql = "SELECT * FROM PessoaJuridica";

            try (Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/BancoDePessoas", "root", "senha"); // Ajuste usuário/senha
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    PessoaJuridica pessoaJuridica = new PessoaJuridica(
                            rs.getLong("id"),
                            rs.getLong("cep"),
                            rs.getInt("numero"),
                            rs.getString("complemento"),
                            rs.getLong("cnpj"),
                            rs.getString("razao_social"),
                            rs.getString("nome_fantasia"),
                            rs.getString("inscr_estadual")
                    );
                    pessoasJuridicas.add(pessoaJuridica);
                }

            } catch (SQLException e) {
                System.err.println("Erro ao listar pessoas jurídicas: " + e.getMessage());
            }
            return pessoasJuridicas;
        }

        // Método de conexão com o banco de dados
        private Connection conectar() throws SQLException {
            String url = "jdbc:mysql://localhost:3306/BancoDePessoas";
            String user = "root";
            String password = "senha";
            return DriverManager.getConnection(url, user, password);
        }

        // Getters e Setters
        public Long getCnpj() {
            return cnpj;
        }

        public void setCnpj(Long cnpj) {
            this.cnpj = cnpj;
        }

        public String getRazaoSocial() {
            return razaoSocial;
        }

        public void setRazaoSocial(String razaoSocial) {
            this.razaoSocial = razaoSocial;
        }

        public String getNomeFantasia() {
            return nomeFantasia;
        }

        public void setNomeFantasia(String nomeFantasia) {
            this.nomeFantasia = nomeFantasia;
        }

        public String getInscrEstadual() {
            return inscrEstadual;
        }

        public void setInscrEstadual(String inscrEstadual) {
            this.inscrEstadual = inscrEstadual;
        }
    }

