public abstract class Conta {
  protected String nome;
  protected String cpf;
  protected String dataDeNascimento;
  protected String email;
  protected String telefone;
  protected String senha;
  protected String agencia;
  protected String numeroDaConta;
  protected float saldo;

  public Conta(String nome, String cpf, String dataDeNascimento, String email, String telefone, String senha, String numeroDaConta, float saldo) {
    this.nome = nome;
    this.cpf = cpf;
    this.dataDeNascimento = dataDeNascimento;
    this.email = email;
    this.telefone = telefone;
    this.senha = senha;
    this.agencia = "0001";
    this.numeroDaConta = numeroDaConta;
    this.saldo = saldo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getDataDeNascimento() {
    return dataDeNascimento;
  }

  public void setDataDeNascimento(String dataDeNascimento) {
    this.dataDeNascimento = dataDeNascimento;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getAgencia() {
    return agencia;
  }

  public void setAgencia(String agencia) {
    this.agencia = agencia;
  }

  public String getNumeroDaConta() {
    return numeroDaConta;
  }

  public void setNumeroDaConta(String numeroDaConta) {
    this.numeroDaConta = numeroDaConta;
  }

  public float getSaldo() {
    return saldo;
  }

  public void setSaldo(float saldo) {
    this.saldo = saldo;
  }
}
