package Enums;

public enum MascaraAgenciaBanco {
    AGENCIA("0000-0"), // Máscara para agência
    CONTA("00000-0");  // Máscara para conta

    private String valor;

    MascaraAgenciaBanco(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
