package AccountsBanking;

import java.util.Date;

public class ContaCorrente extends ContaBancaria {
    private Double valorCustoServico;      // Valor cobrado por serviços
    private Double limitePixNoturno;       // Limite para PIX noturno

    // Construtor
    public ContaCorrente(Long id, Long bancoId, Long branchId, Long accountNumber, Double balance, Date openingDate, Long accountHolderId, String type,
                         Double valorCustoServico, Double limitePixNoturno) {
        super(id, bancoId, branchId, accountNumber, balance, openingDate, accountHolderId, type);
        this.valorCustoServico = valorCustoServico;
        this.limitePixNoturno = limitePixNoturno;
    }

    // Getters e Setters
    public Double getValorCustoServico() {
        return valorCustoServico;
    }

    public void setValorCustoServico(Double valorCustoServico) {
        this.valorCustoServico = valorCustoServico;
    }

    public Double getLimitePixNoturno() {
        return limitePixNoturno;
    }

    public void setLimitePixNoturno(Double limitePixNoturno) {
        this.limitePixNoturno = limitePixNoturno;
    }

    // Métodos adicionais
    @Override
    public void viewAccount() {
        super.viewAccount();
        System.out.println("Valor de Custos de Serviços: " + valorCustoServico);
        System.out.println("Limite de PIX Noturno: " + limitePixNoturno);
    }

    protected Double getBalance() {
        return null;
    }
}
