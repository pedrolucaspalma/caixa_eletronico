import java.util.ArrayList;

public abstract class Conta {
  Registrador registrador = new Registrador();

  protected String nome;
  protected String cpf;
  protected String dataDeNascimento;
  protected String email;
  protected String telefone;
  protected String senha;
  protected String agencia;
  protected String numeroDaConta;
  protected ArrayList<String> pix;
  protected ArrayList<String> historicoDeTransacoes;
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

  //Adicionar chamada de função para voltar pro menu
  public void adicionarPix(){
    int input = registrador.lerInt("Insira o que será utilizado como chave:\n1-CPF \n2- Email\n3- Telefone\n");

    switch(input){
      case 1:
              for(String i : pix){
                if(i.equals(cpf)){
                  System.out.println("CPF ja foi cadastrado como pix nesta conta. Operação abortada.");
                  return;
                }
              }
              pix.add(cpf);
              System.out.println("CPF cadastrado com sucesso!");
              break;
      case 2: 
              for(String i : pix){
                if(i.equals(email)){
                  System.out.println("Email ja foi cadastrado como pix nesta conta. Operação abortada.");
                  return;
                }
              }
              pix.add(email);
              System.out.println("Email cadastrado com sucesso!");
              break;
      case 3: 
              for(String i : pix){
                if(i.equals(telefone)){
                  System.out.println("Telefone ja foi cadastrado como pix nesta conta. Operação abortada.");
                  return;
                }
              }
              pix.add(telefone);
              System.out.println("Telefone cadastrado com sucesso!");
              break;
      default: System.out.println("Erro, valor inválido. Operação abortada.");
              break;
    }
  }

  public void transferir() {
    System.out.printf("\nQual metodo voce deseja utilizar para fazer a tranferencia?\n\n1. PIX\n2.Agencia + Numero da Conta\n\n0. Cancelar\n\n");
    switch(registrador.lerInt(".")) {
      case 1:
      case 2:
      case 0:
    }
  }
}
