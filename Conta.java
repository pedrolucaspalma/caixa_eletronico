public abstract class Conta {
    protected DadosPessoais dadosPessoais = new DadosPessoais();
    protected DadosBancarios dadosBancarios = new DadosBancarios();
    protected boolean contaAtiva;

    public Conta(DadosPessoais dadosPessoais, DadosBancarios dadosBancarios) {
    }

    //__GETS
    public boolean getContaAtiva() {
        return contaAtiva;
    }
}
