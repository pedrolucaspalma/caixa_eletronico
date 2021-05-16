import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public abstract class Conta {
  protected String nome;
  protected String cpf;
  protected LocalDate dataDeNascimento;
  protected String email;
  protected String telefone;
  protected String senha;
  protected String agencia;
  protected String numeroDaConta;
  protected LocalDate dataDeCriacao;
  protected ArrayList<String> pix = new ArrayList<String>();
  protected ArrayList<Transacao> extrato = new ArrayList<Transacao>();
  protected float saldo;
  protected Salario salario;

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
    this.salario = new Salario(false, 0, "00");
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

  public LocalDate getDataDeCriacao() {
    return dataDeCriacao;
  }

  public float getSaldo() {
    return saldo;
  }

  public void setSaldo(float saldo) {
    this.saldo = saldo;
  }

  public Salario getSalario() {
    return salario;
  }

  //TODO: Explicar o porque de nao termos criar um objeto boleto
  public void pagarBoleto(LocalDate dataAtual) {
    Registrador registrador = new Registrador();
    String codigoDeBoleto = registrador.lerCodigoDeBoleto("Insira o codigo de boleto");
    Float valor = registrador.lerFloat("Insira o valor do boleto: ");

    LocalDate dataDeVencimento = registrador.lerData("Digite a data de vencimento do boleto");

    if (dataDeVencimento.isAfter(dataAtual)) {
      Period periodoDeDias = Period.between(dataAtual, dataDeVencimento);
      int quantidadeDeDiasAposVencimento = periodoDeDias.getDays();

      float valorComMulta = (float)(Math.pow(valor * (1 + 0.01), quantidadeDeDiasAposVencimento));

      if (saldo - valorComMulta >= -3000) {
        saldo -= valorComMulta;
  
        Transacao transacao = new Transacao(
            nome, //Nome do pagador
            "Pagamento de boleto numero: " + codigoDeBoleto + " no valor de: R$" + valor + "com acrescimo de R$"+ (valorComMulta - valor) + "Totalizando R$" + valorComMulta,
            "Pagamento de boleto", //Tipo de transacao
            "N/A",//Destinatario do pagamento
            valorComMulta,//Valor pago
            dataAtual//Data do dia de pagamento do boleto
        );
  
        extrato.add(transacao);
        System.out.println("O boleto foi pago com sucesso.");

      } else {
        System.out.println("O pagamento ultrapassaria seu limite de cheque especial. Transacao cancelada");
      }

      
    } else{
      if (saldo - valor >= -3000) {
        saldo -= valor;
  
        Transacao transacao = new Transacao(
            nome,
            "Pagamento de boleto numero: " + codigoDeBoleto + " no valor de: R$" + valor + " .Sem acrescimo de multa",
            "Pagamento de boleto",
            "N/A",
            valor,
            dataAtual
        );
  
        extrato.add(transacao);
        System.out.println("O boleto foi pago com sucesso.");

      } else {
        System.out.println("O pagamento ultrapassaria seu limite de cheque especial. Transacao cancelada");
      }
    }
  }

  public ArrayList<String> getPix() {
    return pix;
  }

  public void sacar(LocalDate data) {
    Registrador registrador = new Registrador();
    float valor = registrador.lerFloat("Digite o valor que deseja sacar");
    float saldoAtual = getSaldo();

    if (saldoAtual - valor >= -3000) {
      setSaldo(saldoAtual - valor);
      System.out.println("Saque feito com sucesso.");
    } else {
      System.out.println("Valor ultrapassa o limite do cheque especial. Operação abortada");
    }

    Transacao transacao = new Transacao(nome, "Saque de R$" + valor, "Saque", "N/A", valor, data);

    extrato.add(transacao);
  }

  public void depositar(LocalDate data) {
    Registrador registrador = new Registrador();
    float valor = registrador.lerFloat("Digite o valor que deseja depositar");
    float saldoAtual = getSaldo();

    setSaldo(saldoAtual + valor);
    System.out.println("Deposito feito com sucesso.");

    Transacao transacao = new Transacao(nome, "Deposito de R$" + valor, "Deposito", "N/A", valor, data);

    extrato.add(transacao);
  }

  public void adicionarPix(BancoDeContas contas) {
    Registrador registrador = new Registrador();
    int input = registrador.lerInt("Insira o que será utilizado como chave:\n1-CPF \n2- Email\n3- Telefone\n.");

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
    if (this == destinatario) {
      if ((saldo - valor) >= -3000.) {
        saldo -= valor;
        destinatario.setSaldo(destinatario.getSaldo() + valor);
  
        Transacao transacaoRemetente = new Transacao(
            nome,
            "Transferencia PIX para " + destinatario.nome + "no valor de R$" + valor,
            "Transferencia PIX",
            destinatario.nome,
            valor,
            data
        );
  
        Transacao transacaoDestinatario = new Transacao(
          nome,
          "Transferencia PIX de " + destinatario.nome + "no valor de R$" + valor,
          "Transferencia PIX",
          destinatario.nome,
          valor,
          data
        );
  
        extrato.add(transacaoRemetente);
        destinatario.extrato.add(transacaoDestinatario);
      } else {
        System.out.printf("\nSaldo insuficiente\n\n");
      }
    } else {
      System.out.printf("\nOperacao invalida\n\n");
    }
  }

  public void transferirPorTED(Conta destinatario, float valor, LocalDate data) {
    if (this == destinatario) {
      if ((saldo - valor) >= -3000.) {
        System.out.println("SaldoR antes: " + saldo);
        System.out.println("SaldoD antes: " + destinatario.getSaldo());
        saldo -= valor;
        destinatario.setSaldo(destinatario.getSaldo() + valor);
        System.out.println("SaldoR depois: " + saldo);
        System.out.println("SaldoD antes: " + destinatario.getSaldo());
  
        Transacao transacaoRemetente = new Transacao(
            nome,
            "Transferencia TED para " + destinatario.nome + "no valor de R$" + valor,
            "Transferencia TED",
            destinatario.nome,
            valor,
            data
        );
  
        Transacao transacaoDestinatario = new Transacao(
          nome,
          "Transferencia TED de " + destinatario.nome + "no valor de R$" + valor,
          "Transferencia TED",
          destinatario.nome,
          valor,
          data
        );
  
        extrato.add(transacaoRemetente);
        destinatario.extrato.add(transacaoDestinatario);
      } else {
        System.out.printf("\nSaldo insuficiente\n\n");
      }
    } else {
      System.out.printf("\nOperacao invalida\n\n");
    }
  }

  public void imprimirDescricao(int index){
    for(Transacao i : extrato){
      if(extrato.indexOf(i) == index){
        System.out.println(i.getDescricao());
        return;
      }
    }
    System.out.println("O indice inserido nao corresponde a um item do extrato");
  }

  public void imprimirExtrato() {
    Registrador registrador = new Registrador();

    System.out.println("-------------------------Extratos-----------------------------------");
    for (Transacao i : extrato) {
      // Todo EXIBIR DETALHES DA TRANSACAO
      System.out.println
      ("------------------------------------------------------------------");
      System.out.println(extrato.indexOf(i) + ".");
      System.out.println("Data de pagamento: " + i.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
      System.out.println("Pagador: "+ i.getRemetente());
      System.out.println("Tipo de operacao: " + i.getTipoOperacao());
      System.out.println("Destinatario: "+ i.getDestinatario());
      System.out.println("Valor: " + i.getValor());
      System.out.println("-------------------------------------------------------------------");
    }
    int input = registrador.lerInt("Voce deseja ver detalhes de um item do extrato?\n1.Sim\n2.Nao\n");
    
    switch(input){
      case 1: {
        int index = registrador.lerInt("Insira o indice localizado na primeira linha do item do extrato que voce deseja ver");
        imprimirDescricao(index);
        break;
      }
      case 2: {
        break;
      }
      default:
        System.out.println("Input Invalido");
        break;
    }
  }

  public void ativarContaSalario(Conta conta){
    Registrador registrador = new Registrador();
    salario = new Salario(true, registrador.lerFloat("Insira o seu pagamento"), registrador.lerString("Insira o dia da sua data de pagamento [dd]"));
  }

  public void atualizarSalario(Salario salario, LocalDate antigaData, LocalDate novaData) {
    DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    String antigaDataString = antigaData.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    String novaDataString = antigaData.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    LocalDate antigaDataConvertida = LocalDate.parse(salario.getDiaDoPagamento() + antigaDataString.substring(1), formatoData);
    LocalDate novaDataConvertida = LocalDate.parse(salario.getDiaDoPagamento() + novaDataString.substring(1), formatoData);

    Period periodoSalario = Period.between(antigaDataConvertida, novaDataConvertida);
    
    int meses = periodoSalario.getMonths();

    for (int i = 0; i < meses; i++) {
      saldo += salario.getPagamento();
    }
  }
}