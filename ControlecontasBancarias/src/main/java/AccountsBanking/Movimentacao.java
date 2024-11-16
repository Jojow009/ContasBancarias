package AccountsBanking;

import java.util.Date;

public class Movimentacao {
    private Long id;              // ID da movimentação
    private Long contaBancariaId; // ID da conta bancária relacionada
    private Long eventoId;        // ID do evento relacionado
    private Date data;            // Data da movimentação
    private String evento;        // Nome do evento (descrição)
    private Double valor;         // Valor da movimentação

    // Construtor
    public Movimentacao(Long contaBancariaId, Long eventoId, Date data, String evento, Double valor) {
        this.contaBancariaId = contaBancariaId;
        this.eventoId = eventoId;
        this.data = data;
        this.evento = evento;
        this.valor = valor;
    }

    // Método para exibir detalhes da movimentação
    public void exibirDetalhes() {
        System.out.println("ID: " + id);
        System.out.println("Conta Bancária ID: " + contaBancariaId);
        System.out.println("Evento ID: " + eventoId);
        System.out.println("Evento: " + evento);
        System.out.println("Data: " + data);
        System.out.println("Valor: " + valor);
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContaBancariaId() {
        return contaBancariaId;
    }

    public void setContaBancariaId(Long contaBancariaId) {
        this.contaBancariaId = contaBancariaId;
    }

    public Long getEventoId() {
        return eventoId;
    }

    public void setEventoId(Long eventoId) {
        this.eventoId = eventoId;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
