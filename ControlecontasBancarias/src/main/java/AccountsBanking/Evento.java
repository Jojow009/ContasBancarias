package AccountsBanking;

import java.util.ArrayList;
import java.util.List;

public class Evento {
    private Long id;                     // ID do evento
    private String descricao;            // Descrição do evento
    private int tipoMovimentacao;        // Tipo da movimentação (1: Crédito, 2: Débito)
    private int situacao;                // Situação do evento (1: Ativo, 0: Inativo)
    private List<Movimentacao> movimentacoes; // Lista de movimentações associadas (1:N)

    // Construtor
    public Evento(Long id, String descricao, int tipoMovimentacao, int situacao) {
        this.id = id;
        this.descricao = descricao;
        this.tipoMovimentacao = tipoMovimentacao;
        this.situacao = situacao;
        this.movimentacoes = new ArrayList<>();
    }

    // Métodos da classe
    // Ler evento
    public void ler() {
        System.out.println("ID: " + id);
        System.out.println("Descrição: " + descricao);
        System.out.println("Tipo de Movimentação: " + (tipoMovimentacao == 1 ? "Crédito" : "Débito"));
        System.out.println("Situação: " + (situacao == 1 ? "Ativo" : "Inativo"));
    }

    // Gravar evento (simulação de gravação no banco de dados)
    public void gravar() {
        System.out.println("Evento gravado: " + descricao);
    }

    // Listar todas as movimentações associadas
    public void listarMovimentacoes() {
        System.out.println("Movimentações associadas ao Evento ID " + id + ":");
        for (Movimentacao movimentacao : movimentacoes) {
            movimentacao.exibirDetalhes();
        }
    }

    // Adicionar movimentação ao evento
    public void adicionarMovimentacao(Movimentacao movimentacao) {
        movimentacoes.add(movimentacao);
        System.out.println("Movimentação adicionada ao Evento: " + descricao);
    }

    // Remover movimentação do evento
    public void removerMovimentacao(Movimentacao movimentacao) {
        if (movimentacoes.remove(movimentacao)) {
            System.out.println("Movimentação removida do Evento: " + descricao);
        } else {
            System.out.println("Movimentação não encontrada no Evento: " + descricao);
        }
    }

    // Listagem de eventos (simulação)
    public static List<Evento> listagem() {
        // Simula a recuperação de eventos de um banco de dados
        return new ArrayList<>();
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(int tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }
}
