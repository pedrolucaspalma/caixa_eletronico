public abstract class Conta {
    protected DadosPessoais dadosPessoais = new DadosPessoais();
    protected DadosBancarios dadosBancarios = new DadosBancarios();

    public Conta(DadosPessoais dadosPessoais, DadosBancarios dadosBancarios) {
    }

    //__GETS
    public String getSenha() {
        return senha;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumeroDaConta() {
        return numeroDaConta;
    }
}
