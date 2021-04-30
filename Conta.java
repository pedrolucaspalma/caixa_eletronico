public abstract class Conta {
    protected String cpf;
    protected String dataDeNascimento;
    protected String email;
    protected String telefone;
    protected String senha;

    protected String agencia;
    protected String numeroDaConta;

    public Conta(String cpf, String dataDeNascimento, String email, String telefone, String senha, String agencia, String numeroDaConta){
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.agencia = agencia;
        this.numeroDaConta = numeroDaConta;
    }
}