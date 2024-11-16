package AccountsBanking;
import java.util.Date;

public class ContaPoupanca extends ContaBancaria {
    private int diaAniversario;              // Dia do aniversário da conta
    private IndiceRemuneracao indiceRemuneracao; // Índice de remuneração vinculado
    private double percRendimentoReal;      // Percentual de rendimento real

    // Construtor
    public ContaPoupanca(Long id, Long bancoId, Long agenciaId, Long numeroConta, Double saldo, Date dataAbertura, Long titularId, String tipo,
                         int diaAniversario, IndiceRemuneracao indiceRemuneracao, double percRendimentoReal) {
        super(id, bancoId, agenciaId, numeroConta, saldo, dataAbertura, titularId, tipo);
        this.diaAniversario = diaAniversario;
        this.indiceRemuneracao = indiceRemuneracao;
        this.percRendimentoReal = percRendimentoReal;
    }

    // Métodos
    public void calcularRendimento() {
        if (indiceRemuneracao != null) {
            double rendimento = (getSaldo() * percRendimentoReal) / 100;
            setSaldo(getSaldo() + rendimento);
            System.out.println("Rendimento calculado: " + rendimento + ". Novo saldo: " + getSaldo());
        } else {
            System.out.println("Nenhum índice de remuneração vinculado à conta.");
        }
    }

    public void ler() {
        super.viewAccount();
        System.out.println("Dia do Aniversário: " + diaAniversario);
        System.out.println("Percentual de Rendimento Real: " + percRendimentoReal + "%");
        if (indiceRemuneracao != null) {
            System.out.println("Índice de Remuneração: " + indiceRemuneracao.getDescricao());
        } else {
            System.out.println("Nenhum índice de remuneração vinculado.");
        }
    }

    // Getters e Setters
    public int getDiaAniversario() {
        return diaAniversario;
    }

    public void setDiaAniversario(int diaAniversario) {
        this.diaAniversario = diaAniversario;
    }

    public IndiceRemuneracao getIndiceRemuneracao() {
        return indiceRemuneracao;
    }

    public void setIndiceRemuneracao(IndiceRemuneracao indiceRemuneracao) {
        this.indiceRemuneracao = indiceRemuneracao;
    }

    public double getPercRendimentoReal() {
        return percRendimentoReal;
    }

    public void setPercRendimentoReal(double percRendimentoReal) {
        this.percRendimentoReal = percRendimentoReal;
    }

    public String getAccountNumber() {
        return null;
    }
}
