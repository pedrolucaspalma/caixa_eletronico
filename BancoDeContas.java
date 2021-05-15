import java.util.ArrayList;

public class BancoDeContas {
    private Registrador registrador = new Registrador();
    private ArrayList<ContaCorrente> contasCorrente = new ArrayList<ContaCorrente>();
    private ArrayList<ContaPoupanca> contasPoupanca = new ArrayList<ContaPoupanca>();
    
    public int acharContaCorrentePorCPF(String cpf) {
        for (ContaCorrente contaCorrente : contasCorrente) {
            if (contaCorrente.cpf.equals(cpf)) {
                return contasCorrente.indexOf(contaCorrente);
            }
        }
        return -1;
    }

    public int acharContaPoupancaPorCPF(String cpf) {
        for (ContaPoupanca contaPoupanca : contasPoupanca) {
            if (contaPoupanca.cpf.equals(cpf)) {
                return contasPoupanca.indexOf(contaPoupanca);
            }
        }
        return -1;
    }

    public int acharContaCorrentePorNumeroDaConta(String numeroDaConta) {
        for (ContaCorrente contaCorrente : contasCorrente) {
            if (contaCorrente.numeroDaConta.equals(numeroDaConta)) {
                return contasCorrente.indexOf(contaCorrente);
            }
        }
        return -1;
    }

    public int acharContaPoupancaPorNumeroDaConta(String numeroDaConta) {
        for (ContaPoupanca contaPoupanca : contasPoupanca) {
            if (contaPoupanca.numeroDaConta.equals(numeroDaConta)) {
                return contasPoupanca.indexOf(contaPoupanca);
            }
        }
        return -1;
    }

	public void abrirContaCorrente() {
        String cpf = registrador.lerCPF("Insira o CPF");

        if (acharContaCorrentePorCPF(cpf) == -1) {
            if (acharContaPoupancaPorCPF(cpf) == -1) {
                String numeroDaConta = gerarNumeroDaConta();

                ContaCorrente contaCorrente  = new ContaCorrente(
                        registrador.lerString("Insira o seu nome"),
                        cpf,
                        registrador.lerData("Insira sua data de nascimento"),
                        registrador.lerEmail("Insira o seu email"),
                        registrador.lerTelefone("Insira o seu telefone"),
                        registrador.lerString("Insira a sua senha"),
                        numeroDaConta,
                        0
                );

                contasCorrente.add(contaCorrente);
                System.out.printf("\nConta corrente criada com sucesso!\nO seu numero da conta e %s", numeroDaConta);
            } else {
                ContaPoupanca copiaDaContaPoupanca = contasPoupanca.get(acharContaPoupancaPorCPF(cpf));
                String numeroDaConta = gerarNumeroDaConta();

                ContaCorrente contaCorrente  = new ContaCorrente(
                        copiaDaContaPoupanca.getNome(),
                        cpf,
                        copiaDaContaPoupanca.getDataDeNascimento(),
                        copiaDaContaPoupanca.getEmail(),
                        copiaDaContaPoupanca.getTelefone(),
                        copiaDaContaPoupanca.getSenha(),
                        numeroDaConta,
                        0
                );

                contasCorrente.add(contaCorrente);
                System.out.printf("\nConta corrente criada com sucesso!\nO seu numero da conta e %s", numeroDaConta);
            }
		} else {
			System.out.printf("\nO usuario ja possui uma conta corrente!\n");
		}
	}

    public void abrirContaPoupanca() {
        String cpf = registrador.lerCPF("Insira o CPF");

        if (acharContaPoupancaPorCPF(cpf) == -1) {
            if (acharContaCorrentePorCPF(cpf) == -1) {
                String numeroDaConta = gerarNumeroDaConta();

                ContaPoupanca contaPoupanca  = new ContaPoupanca(
                        registrador.lerString("Insira o seu nome"),
                        cpf,
                        registrador.lerData("Insira sua data de nascimento"),
                        registrador.lerEmail("Insira o seu email"),
                        registrador.lerTelefone("Insira o seu telefone"),
                        registrador.lerString("Insira a sua senha"),
                        numeroDaConta,
                        0
                );

                contasPoupanca.add(contaPoupanca);
                System.out.printf("\nConta corrente criada com sucesso!\nO seu numero da conta e %s\n\n", numeroDaConta);
            } else {
                ContaCorrente copiaDaContaCorrente = contasCorrente.get(acharContaCorrentePorCPF(cpf));
                String numeroDaConta = gerarNumeroDaConta();

                ContaPoupanca contaPoupanca  = new ContaPoupanca(
                        copiaDaContaCorrente.getNome(),
                        cpf,
                        copiaDaContaCorrente.getDataDeNascimento(),
                        copiaDaContaCorrente.getEmail(),
                        copiaDaContaCorrente.getTelefone(),
                        copiaDaContaCorrente.getSenha(),
                        numeroDaConta,
                        0
                );

                contasPoupanca.add(contaPoupanca);
                System.out.printf("\nConta corrente criada com sucesso!\nO seu numero da conta e %s", numeroDaConta);
            }
		} else {
			System.out.printf("\nO usuario ja possui uma conta poupanca!\n");
		}
	}

	public String gerarNumeroDaConta() {
		return contasCorrente.size() + contasPoupanca.size() + "";
	}
}