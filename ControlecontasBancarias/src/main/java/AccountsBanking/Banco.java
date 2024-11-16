package AccountsBanking;

import Enums.MascaraAgenciaBanco;

public class Banco extends ContaBancaria {
    private Long codigo;         // Código do banco
    private String nome;         // Nome do banco
    private MascaraAgenciaBanco mascaraAgenciaBancoAgencia; // Máscara da agência (usando o enum)
    private MascaraAgenciaBanco mascaraAgenciaBancoConta;   // Máscara da conta (usando o enum)

    // Construtor
    public Banco(Long codigo, String nome, MascaraAgenciaBanco mascaraAgenciaBancoAgencia, MascaraAgenciaBanco mascaraAgenciaBancoConta) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.mascaraAgenciaBancoAgencia = mascaraAgenciaBancoAgencia;
        this.mascaraAgenciaBancoConta = mascaraAgenciaBancoConta;
    }

    public Banco() {

    }

    // Método para exibir os dados do banco
    public void exibirBanco() {
        System.out.println("Código do Banco: " + codigo);
        System.out.println("Nome do Banco: " + nome);
        System.out.println("Máscara da Agência: " + mascaraAgenciaBancoAgencia.getValor());
        System.out.println("Máscara da Conta: " + mascaraAgenciaBancoConta.getValor());
    }

    // Getters e Setters
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public MascaraAgenciaBanco getMascaraAgencia() {
        return mascaraAgenciaBancoAgencia;
    }

    public void setMascaraAgencia(MascaraAgenciaBanco mascaraAgenciaBancoAgencia) {
        this.mascaraAgenciaBancoAgencia = mascaraAgenciaBancoAgencia;
    }

    public MascaraAgenciaBanco getMascaraConta() {
        return mascaraAgenciaBancoConta;
    }

    public void setMascaraConta(MascaraAgenciaBanco mascaraAgenciaBancoConta) {
        this.mascaraAgenciaBancoConta = mascaraAgenciaBancoConta;
    }
}
