package AccountsBanking;

import Person.Pessoa;
import Tools.Validacoes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContaBancaria extends Pessoa {
    private Long id;
    private Long bancoId;
    private Long agenciaId;
    private Long numeroConta;
    private Double saldo;
    private Date dataAbertura;
    private Long titularId;
    private String tipoConta;
    private List<Movimentacao> movimentacoes;

    // Construtor
    public ContaBancaria(Long id, Long bancoId, Long agenciaId, Long numeroConta, Double saldo, Date dataAbertura, Long titularId, String tipoConta) {
        super();
        this.id = id;
        this.bancoId = bancoId;
        this.agenciaId = agenciaId;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.dataAbertura = dataAbertura;
        this.titularId = titularId;
        this.tipoConta = tipoConta;
        this.movimentacoes = new ArrayList<>();
    }

    public ContaBancaria() {}

    // Métodos para validar CPF, CNPJ e telefone
    public boolean validarCPF(String cpf) {
        if (Validacoes.EhCPFValido(cpf)) {
            System.out.println("CPF válido.");
            return true;
        } else {
            System.out.println("CPF inválido.");
            return false;
        }
    }

    public boolean validarCNPJ(String cnpj) {
        if (Validacoes.EhCNPJValido(cnpj)) {
            System.out.println("CNPJ válido.");
            return true;
        } else {
            System.out.println("CNPJ inválido.");
            return false;
        }
    }

    public boolean validarTelefone(String telefone) {
        if (Validacoes.EhTelefoneValido(telefone)) {
            System.out.println("Telefone válido.");
            return true;
        } else {
            System.out.println("Telefone inválido.");
            return false;
        }
    }

    // Métodos para a relação 1:N (movimentações)
    public void adicionarMovimentacao(Movimentacao movimentacao) {
        movimentacoes.add(movimentacao);
        System.out.println("Movimentação adicionada com sucesso: " + movimentacao.getEvento());
    }

    public void listarMovimentacoes() {
        System.out.println("Movimentações da Conta " + numeroConta + ":");
        for (Movimentacao movimentacao : movimentacoes) {
            movimentacao.exibirDetalhes();
        }
    }

    public Movimentacao buscarMovimentacaoPorId(Long movimentacaoId) {
        for (Movimentacao movimentacao : movimentacoes) {
            if (movimentacao.getId().equals(movimentacaoId)) {
                return movimentacao;
            }
        }
        System.out.println("Movimentação não encontrada: ID " + movimentacaoId);
        return null;
    }

    public void atualizarSaldo(Movimentacao movimentacao) {
        if (movimentacao.getEvento().equalsIgnoreCase("DEPÓSITO")) {
            saldo += movimentacao.getValor();
        } else if (movimentacao.getEvento().equalsIgnoreCase("SAQUE")) {
            if (saldo >= movimentacao.getValor()) {
                saldo -= movimentacao.getValor();
            } else {
                System.out.println("Saldo insuficiente para realizar o saque.");
                return;
            }
        }
        System.out.println("Saldo atualizado: " + saldo);
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBancoId() {
        return bancoId;
    }

    public void setBancoId(Long bancoId) {
        this.bancoId = bancoId;
    }

    public Long getAgenciaId() {
        return agenciaId;
    }

    public void setAgenciaId(Long agenciaId) {
        this.agenciaId = agenciaId;
    }

    public Long getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Long numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Long getTitularId() {
        return titularId;
    }

    public void setTitularId(Long titularId) {
        this.titularId = titularId;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    protected void viewAccount() {
    }
}