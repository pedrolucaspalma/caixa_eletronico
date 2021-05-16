public class Salario {
    private boolean ativa;
    private float pagamento;
    private String diaDoPagamento;
    
    public Salario(boolean ativa, float pagamento, String diaDoPagamento) {
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

    public String getDiaDoPagamento() {
        return diaDoPagamento;
    }

    public void setDiaDoPagamento(String diaDoPagamento) {
        this.diaDoPagamento = diaDoPagamento;
    }
}