package AccountsBanking;

import java.util.ArrayList;
import java.util.List;

public class IndiceRemuneracao {
    private final ArrayList<Object> cotacoes;
    private Long codigo;
    private String descricao;
    private int periodicidade; // Dias entre atualizações
    private int situacao;      // 1: Ativo, 0: Inativo

    private List<ContaPoupanca> contasPoupanca; // Relação com várias contas poupança

    // Construtor
    public IndiceRemuneracao(Long codigo, String descricao, int periodicidade, int situacao) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.periodicidade = periodicidade;
        this.situacao = situacao;
        this.cotacoes = new ArrayList<>();
        this.contasPoupanca = new ArrayList<>();
    }

    // Adicionar cotação
    public void adicionarCotacao(Cotacao cotacao) {
        cotacoes.add(cotacao);
        System.out.println("Cotação adicionada ao índice: " + descricao);
    }

    // Listar cotações
    public ArrayList<Object> listarCotacoes() {
        return cotacoes;
    }

    // Getters e Setters
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(int periodicidade) {
        this.periodicidade = periodicidade;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }
    public void ler() {
        System.out.println("Código: " + codigo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Periodicidade: " + periodicidade);
        System.out.println("Situação: " + (situacao == 1 ? "Ativo" : "Inativo"));
        System.out.println("Contas Poupança vinculadas: " + contasPoupanca.size());
    }

    public void gravar() {
        System.out.println("Índice de Remuneração salvo no banco de dados: Código = " + codigo);
    }

    public List<IndiceRemuneracao> listagem() {
        // Implementar lógica de listagem se necessário
        return new ArrayList<>();
    }

    // Relacionamento: Adicionar e Remover Contas Poupança
    public void adicionarContaPoupanca(ContaPoupanca conta) {
        this.contasPoupanca.add(conta);
        System.out.println("Conta Poupança adicionada ao Índice de Remuneração: " + conta.getAccountNumber());
    }

    public void removerContaPoupanca(ContaPoupanca conta) {
        if (this.contasPoupanca.remove(conta)) {
            System.out.println("Conta Poupança removida do Índice de Remuneração: " + conta.getAccountNumber());
        } else {
            System.out.println("Conta Poupança não encontrada: " + conta.getAccountNumber());
        }
    }


}

