import java.util.Calendar;

public class CaixaEletronico {
	private Registrador input = new Registrador();
	private BancoDeContas contas = new BancoDeContas();
	private Calendar calendar = Calendar.getInstance();

	public int lerSelecao() {
		return input.lerInt(".");
	}

	public void menuLogin() {
		System.out.printf(
				"Digite um desses numeros:\n\n1. Acessar conta corrente\n2. Acessar conta poupanca\n3. Abrir conta corrente\n4. Abrir conta poupanca\n\n0. Sair\n\n");

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
			//TODO: avançarTempo();
			case 5:
				menuLogin();
				break;
			case 0:
				return;
		}
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

	public void avancarTempo(int dias) {
		calendar.add(Calendar.DATE, dias);
	}

	public void menuContaCorrente(ContaCorrente conta) {
		System.out.printf(
				"Digite um desses numeros:\n\n1. Sacar\n2. Depositar\n3. Emitir extrato\n4. Transferencia\n5. Configurar PIX\n6. Pagar boleto\n7. Avancar no tempo\n\n0. Encerrar Sessao\n");

		//TODO Consertar esse switch que ta todo torto
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
		}
	}
}
