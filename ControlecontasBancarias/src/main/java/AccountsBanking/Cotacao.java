package AccountsBanking;

import java.util.Date;

public class Cotacao {
    private Long id;                  // Código da cotação
    private Date data;                // Data da cotação
    private Double valor;             // Valor da cotação
    private IndiceRemuneracao indice; // Relacionamento com o índice de remuneração

    // Construtor
    public Cotacao(Long id, Date data, Double valor, IndiceRemuneracao indice) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.indice = indice;
    }

    // Construtor sem ID (para novas cotações)
    public Cotacao(Date data, Double valor, IndiceRemuneracao indice) {
        this.data = data;
        this.valor = valor;
        this.indice = indice;
    }

    // Método para exibir informações da cotação
    public void ler() {
        System.out.println("ID da Cotação: " + id);
        System.out.println("Data: " + data);
        System.out.println("Valor: " + valor);
        if (indice != null) {
            System.out.println("Índice de Remuneração: " + indice.getDescricao());
        } else {
            System.out.println("Nenhum índice de remuneração vinculado.");
        }
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public IndiceRemuneracao getIndice() {
        return indice;
    }

    public void setIndice(IndiceRemuneracao indice) {
        this.indice = indice;
    }
}
