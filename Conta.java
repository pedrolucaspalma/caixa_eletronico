import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;

public abstract class Conta {
  Registrador registrador = new Registrador();

  protected String nome;
  protected String cpf;
  protected LocalDate dataDeNascimento;
  protected String email;
  protected String telefone;
  protected String senha;
  protected String agencia;
  protected String numeroDaConta;
  protected LocalDate dataDeCriacao;
  protected ArrayList<String> pix;
  protected ArrayList<Transacao> extrato = new ArrayList<Transacao>();
  protected float saldo;

  public Conta(
        String nome,
        String cpf,
        LocalDate dataDeNascimento,
        String email,
        String telefone,
        String senha,
        String numeroDaConta,
        LocalDate dataDeCriacao,
        float saldo
  ) {
    this.nome = nome;
    this.cpf = cpf;
    this.dataDeNascimento = dataDeNascimento;
    this.email = email;
    this.telefone = telefone;
    this.senha = senha;
    this.agencia = "0001";
    this.numeroDaConta = numeroDaConta;
    this.dataDeCriacao = dataDeCriacao;
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

  public LocalDate getDataDeNascimento() {
    return dataDeNascimento;
  }

  public void setDataDeNascimento(LocalDate dataDeNascimento) {
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

  //TODO: Explicar o porque de nao termos criar um objeto boleto
  public void pagarBoleto(LocalDate dataAtual) {
    String codigoDeBoleto = registrador.lerCodigoDeBoleto("Insira o codigo de boleto");
    Float valor = registrador.lerFloat("Insira o valor do boleto: ");

    LocalDate dataDeVencimento = registrador.lerData("Digite a data de vencimento do boleto");

    //TODO: Calcular multa
    if (dataDeVencimento.isAfter(dataAtual)) {
      Period periodoDeDias = Period.between(dataAtual, dataDeVencimento);
      int quantidadeDeDiasAposVencimento = periodoDeDias.getDays();
    }


    // TODO: Atualizar valor com multa

    if (saldo - valor >= -3000) {
      saldo -= valor;

      Transacao transacao = new Transacao(nome, "Pagamento de boleto numero: " + codigoDeBoleto + " no valor de: R$" + valor, "Pagamento de boleto", "N/A",valor);

      extrato.add(transacao);
    } else {
      System.out.println("O pagamento ultrapassaria seu limite de cheque especial. Transacao cancelada");
    }
  }

  public ArrayList<String> getPix() {
    return pix;
  }

  public void sacar() {
    float valor = registrador.lerFloat("Digite o valor que deseja sacar");
    float saldoAtual = getSaldo();

    if (saldoAtual - valor >= -3000) {
      setSaldo(saldoAtual - valor);
      System.out.println("Saque feito com sucesso.");
    } else {
      System.out.println("Valor ultrapassa o limite do cheque especial. Operação abortada");
    }

    Transacao transacao = new Transacao(nome, "Saque de R$" + valor, "Saque", "N/A", valor);

    extrato.add(transacao);
  }

  public void depositar() {
    float valor = registrador.lerFloat("Digite o valor que deseja depositar:");
    float saldoAtual = getSaldo();

    setSaldo(saldoAtual + valor);
    System.out.println("Deposito feito com sucesso.");

    Transacao transacao = new Transacao(nome, "Deposito de R$" + valor, "Deposito", "N/A", valor);

    extrato.add(transacao);
  }

  public void adicionarPix(BancoDeContas contas) {
    int input = registrador.lerInt("Insira o que será utilizado como chave:\n1-CPF \n2- Email\n3- Telefone\n");

    switch (input) {
      case 1:
        if (contas.acharContaPoupancaPorPIX(cpf) == -1) {
          if (contas.acharContaCorrentePorPIX(cpf) == -1) {
            pix.add(cpf);
          } else {
            System.out.println("CPF ja cadastrado como PIX. Selecione outra forma de chave.");
          }
        } else {
          System.out.println("CPF ja cadastrado como PIX. Selecione outra forma de chave.");
        }
        break;
      case 2:
        if (contas.acharContaPoupancaPorPIX(email) == -1) {
          if (contas.acharContaCorrentePorPIX(email) == -1) {
            pix.add(telefone);
          } else {
            System.out.println("Email ja cadastrado como PIX. Selecione outra forma de chave.");
          }
        } else {
          System.out.println("Email ja cadastrado como PIX. Selecione outra forma de chave");
        }
        break;
      case 3:
        if (contas.acharContaPoupancaPorPIX(telefone) == -1) {
          if (contas.acharContaCorrentePorPIX(telefone) == -1) {
            pix.add(telefone);
          } else {
            System.out.println("Telefone já cadastrado como PIX. Selecione outra forma de chave.");
          }
        } else {
          System.out.println("Telefone já cadastrado como PIX. Selecione outra forma de chave.");
        }
        break;
      default:
        System.out.println("Erro, valor inválido. Operação abortada.");
        break;
    }
  }

  public void transferirPorPIX(Conta destinatario, float valor, LocalDate data) {
    if ((saldo - valor) >= -3000.) {
      saldo -= valor;
      destinatario.setSaldo(destinatario.getSaldo() + valor);

      String chavePIX = registrador.lerString("Digite a chave PIX do destinatario");

      // TODO: Adicionar data
      Transacao transacao = new Transacao(nome,
          "Transferencia PIX para " + destinatario.nome + "no valor de R$" + valor, "Transferencia PIX",
          destinatario.nome, valor);
    } else {
      System.out.printf("\nSaldo insuficiente\n\n");
    }
  }

  public void transferirPorTED(Conta destinatario, float valor) {
    if ((saldo - valor) >= -3000.) {
      saldo -= valor;
      destinatario.setSaldo(destinatario.getSaldo() + valor);

      // TODO: Adicionar data
      Transacao transacao = new Transacao(nome,
          "Transferencia TED para " + destinatario.nome + "no valor de R$" + valor, "Transferencia TED",
          destinatario.nome, valor);
    } else {
      System.out.printf("\nSaldo insuficiente\n\n");
    }
  }

  public void imprimirExtrato() {
    System.out.println("-------------------------Extratos-----------------------------------");
    for (Transacao i : extrato) {
      // Todo EXIBIR DETALHES DA TRANSACAO
      System.out.println("------------------------------------------------------------------");
      // System.out.println("Data " +);
      System.out.println("Tipo de operacao: " + i.getTipoOperacao());
      System.out.println("Descricao: " + i.getDescricao());
      System.out.println("Valor: " + i.getValor());
      System.out.println("-------------------------------------------------------------------");
    }
  }
}