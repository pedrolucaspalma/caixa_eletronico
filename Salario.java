import java.time.LocalDate;

public class Salario {
    private boolean ativa;
    private float pagamento;
    private LocalDate diaDoPagamento;
    
    public Salario(boolean ativa, float pagamento, LocalDate diaDoPagamento) {
        this.ativa = ativa;
        this.pagamento = pagamento;
        this.diaDoPagamento = diaDoPagamento;
    }

    public boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public float getPagamento() {
        return pagamento;
    }

    public void setPagamento(float pagamento) {
        this.pagamento = pagamento;
    }

    public LocalDate getDiaDoPagamento() {
        return diaDoPagamento;
    }

    public void setDiaDoPagamento(LocalDate diaDoPagamento) {
        this.diaDoPagamento = diaDoPagamento;
    }
}