public abstract class Conta {
    protected String cpf;
    protected String dataDeNascimento;
    protected String email;
    protected String telefone;
    protected String senha;

    protected String agencia;
    protected String numeroDaConta;

    protected ContaCorrente contaCorrente;
    protected ContaPoupanca contaPoupanca;

    public Conta (String cpf, String dataDeNascimento, String email, String telefone, String senha, String agencia, String numeroDaConta) {
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.agencia = agencia;
        this.numeroDaConta = numeroDaConta;

        // TODO: Selecionar tipo de conta para abrir.
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public String getEmail() {
        return email;
    }
    public String getTelefone() {
        return telefone;
    }
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
