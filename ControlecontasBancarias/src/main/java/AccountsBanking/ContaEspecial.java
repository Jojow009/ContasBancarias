package AccountsBanking;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class ContaEspecial extends ContaCorrente {
    private Double limiteCredito;     // Limite de crédito disponível
    private Date dataVencimentoContrato; // Data de vencimento do contrato

    // Construtor
    public ContaEspecial(Long id, Long bancoId, Long branchId, Long accountNumber, Double balance, Date openingDate, Long accountHolderId, String type,
                         Double valorCustoServico, Double limitePixNoturno, Double limiteCredito, Date dataVencimentoContrato) {
        super(id, bancoId, branchId, accountNumber, balance, openingDate, accountHolderId, type, valorCustoServico, limitePixNoturno);
        this.limiteCredito = limiteCredito;
        this.dataVencimentoContrato = dataVencimentoContrato;
    }

    // Getters e Setters
    public Double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(Double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public Date getDataVencimentoContrato() {
        return dataVencimentoContrato;
    }

    public void setDataVencimentoContrato(Date dataVencimentoContrato) {
        this.dataVencimentoContrato = dataVencimentoContrato;
    }

    // Métodos adicionais
    @Override
    public void viewAccount() {
        super.viewAccount();
        System.out.println("Limite de Crédito: " + limiteCredito);
        System.out.println("Data de Vencimento do Contrato: " + dataVencimentoContrato);
    }

    // Método para verificar se há crédito disponível
    public void verificarCreditoDisponivel() {
        System.out.println("Crédito Disponível: " + (getBalance() + limiteCredito));
    }


    // Método para usar o limite de crédito
    public void usarCredito(Double valor) {
        if (valor > 0 && valor <= limiteCredito) {
            limiteCredito -= valor;
            setSaldo(getBalance() + valor);
            System.out.println("Crédito utilizado: " + valor);
            System.out.println("Novo saldo: " + getBalance());
            System.out.println("Crédito restante: " + limiteCredito);
        } else {
            System.out.println("Valor inválido ou excede o limite de crédito.");
        }
    }

    @Override
    public Double getBalance() {
        Double balance = super.getBalance(); // Obtém o saldo original da classe pai
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        System.out.println("Saldo atual: " + formatter.format(balance));
        return balance;
    }
}