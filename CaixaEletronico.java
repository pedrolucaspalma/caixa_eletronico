import java.time.LocalDate;

public class CaixaEletronico {
	private Registrador input = new Registrador();
	private BancoDeContas contas = new BancoDeContas();
	private LocalDate data = LocalDate.now();

	public int lerSelecao() {
		return input.lerInt(".");
	}

	public void avancarTempo(int dias) {
		data = data.plusDays(dias);
	}

	public void login() {
		String numeroDaConta = input.lerString("Digite o numero da conta");
		String senha = input.lerString("Digite a sua senha");

		int posConta = contas.acharContaCorrentePorNumeroDaConta(numeroDaConta);

		if (posConta != -1 && contas.getContasCorrente().get(posConta).senha.equals(senha)) {
			menuContaCorrente(contas.getContasCorrente().get(posConta));
		} else {
			System.out.printf("\nDados invalidos\n\n");
		}
	}

	public void menuLogin() {
		System.out.println(
				"Digite um desses numeros:\n\n" +
				"1. Acessar conta corrente\n" +
				"2. Acessar conta poupanca\n" +
				"3. Abrir conta corrente\n" +
				"4. Abrir conta poupanca\n" +
				"5. Avancar no tempo\n\n" +
				"0. Sair\n\n"
		);

		switch (lerSelecao()) {
			case 1:
				login();
				menuLogin();
				break;
			case 3:
				contas.abrirContaCorrente();
				menuLogin();
				break;
			case 4:
				contas.abrirContaPoupanca();
				menuLogin();
				break;
			case 5:
				menuLogin();
				break;
			case 0:
				return;
		}
	}

	public void menuContaPoupanca(ContaPoupanca conta){
		System.out.printf("Ola %s\nTipo de conta: Poupanca\nSaldo: %s\n", conta.getNome(), conta.getSaldo());
		System.out.println(
				"Digite um desses numeros:\n\n" +
				"1. Sacar\n" + 
				"2. Depositar\n" +
				"3. Emitir extrato\n" +
				"4. Transferencia\n" +
				"5. Configurar PIX\n" +
				"6. Pagar boleto\n" +
				"7. Avancar no tempo\n\n" +
				"0. Encerrar Sessao\n"
		);

		switch (lerSelecao()) {
			case 1: // Sacar
				conta.sacar();
				menuContaPoupanca(conta);
				return;
			case 2: // Depositar
				conta.depositar();
				menuContaPoupanca(conta);
				break;
			case 3: // Emitir Extrato
				conta.imprimirExtrato();
				menuContaPoupanca(conta);
				break;
			case 4: // Fazer transferencia atraves de (Agencia ∧ Conta) ∨ PIX
				//TODO:Implementar transferencia
				menuLogin();
				break;
			case 5: // Configurar PIX ⇔ Definir qual informação será utilizada para transferências
				conta.adicionarPix(contas);
				menuContaPoupanca(conta);
				break;
			case 6: // TODO: Pagar boleto (Digitando o codigo de barras de 48 digitos, valor e data de vencimento)
				break;
			case 0 :
				menuLogin();
				break;
			default:
				System.out.println("Input Invalido!");
				menuContaPoupanca(conta);
				break;
		}
	}

	public void menuContaCorrente(ContaCorrente conta) {
		System.out.printf("Ola %s\nTipo de conta: Corrente\nSaldo: %s\n", conta.getNome(), conta.getSaldo());
		System.out.println(
				"Digite um desses numeros:\n\n" + 
				"1. Sacar\n" +
				"2. Depositar\n" +
				"3. Emitir extrato\n" +
				"4. Transferencia\n" +
				"5. Configurar PIX\n" +
				"6. Pagar boleto\n" +
				"7. Avancar no tempo\n\n" +
				"0. Encerrar Sessao\n"
		);

		switch (lerSelecao()) {
			case 1: // Sacar
				conta.sacar();
				menuContaCorrente(conta);
				return;
			case 2: // Depositar
				conta.depositar();
				menuContaCorrente(conta);
				break;
			case 3: // Emitir Extrato
				conta.imprimirExtrato();
				menuContaCorrente(conta);
				break;
			case 4: // Fazer transferencia atraves de (Agencia ∧ Conta) ∨ PIX
				//TODO:Implementar transferencia
				menuLogin();
				break;
			case 5: // Configurar PIX ⇔ Definir qual informação será utilizada para transferências
				conta.adicionarPix(contas);
				menuContaCorrente(conta);
				break;
			case 6: // TODO: Pagar boleto (Digitando o codigo de barras de 48 digitos, valor e data de vencimento)
				break;
			case 0 :
				menuLogin();
				break;
			default:
				System.out.println("Input Invalido!");
				menuContaCorrente(conta);
				break;
		}
	}
}
