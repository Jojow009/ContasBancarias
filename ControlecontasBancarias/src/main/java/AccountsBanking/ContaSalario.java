package AccountsBanking;

import java.util.Date;

public class ContaSalario extends ContaBancaria {
    private String cnpjVinculado;           // CNPJ da empresa vinculada
    private String limiteConsignado;       // Limite para empréstimos consignados
    private Double limiteAntecipacaoMes;   // Limite de antecipação salarial
    private Boolean permiteAntecipacao;    // Indica se é permitido antecipação salarial
    private Long contaVinculada;           // ID da conta vinculada

    // Construtor
    public ContaSalario(Long id, Long bancoId, Long branchId, Long accountNumber, Double balance, Date openingDate, Long accountHolderId, String type,
                        String cnpjVinculado, String limiteConsignado, Double limiteAntecipacaoMes, Boolean permiteAntecipacao, Long contaVinculada) {
        super(id, bancoId, branchId, accountNumber, balance, openingDate, accountHolderId, type);
        this.cnpjVinculado = cnpjVinculado;
        this.limiteConsignado = limiteConsignado;
        this.limiteAntecipacaoMes = limiteAntecipacaoMes;
        this.permiteAntecipacao = permiteAntecipacao;
        this.contaVinculada = contaVinculada;
    }

    // Getters e Setters
    public String getCnpjVinculado() {
        return cnpjVinculado;
    }

    public void setCnpjVinculado(String cnpjVinculado) {
        this.cnpjVinculado = cnpjVinculado;
    }

    public String getLimiteConsignado() {
        return limiteConsignado;
    }

    public void setLimiteConsignado(String limiteConsignado) {
        this.limiteConsignado = limiteConsignado;
    }

    public Double getLimiteAntecipacaoMes() {
        return limiteAntecipacaoMes;
    }

    public void setLimiteAntecipacaoMes(Double limiteAntecipacaoMes) {
        this.limiteAntecipacaoMes = limiteAntecipacaoMes;
    }

    public Boolean getPermiteAntecipacao() {
        return permiteAntecipacao;
    }

    public void setPermiteAntecipacao(Boolean permiteAntecipacao) {
        this.permiteAntecipacao = permiteAntecipacao;
    }

    public Long getContaVinculada() {
        return contaVinculada;
    }

    public void setContaVinculada(Long contaVinculada) {
        this.contaVinculada = contaVinculada;
    }

    // Métodos adicionais
    @Override
    public void viewAccount() {
        super.viewAccount();
        System.out.println("CNPJ Vinculado: " + cnpjVinculado);
        System.out.println("Limite Consignado: " + limiteConsignado);
        System.out.println("Limite Antecipação Mensal: " + limiteAntecipacaoMes);
        System.out.println("Permite Antecipação: " + permiteAntecipacao);
        System.out.println("Conta Vinculada ID: " + contaVinculada);
    }
}
